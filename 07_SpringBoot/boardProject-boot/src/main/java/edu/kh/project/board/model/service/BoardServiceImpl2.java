package edu.kh.project.board.model.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import edu.kh.project.board.model.dao.BoardMapper2;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;
import edu.kh.project.board.model.exception.FileUploadException;
import edu.kh.project.board.model.exception.ImageDeleteException;
import edu.kh.project.common.utility.Util;

// 게시글 삽입
@Transactional(rollbackFor=Exception.class)
@Service
@PropertySource("classpath:/config.properties")  // build path -> source -> 등록안되어있다면 등록
public class BoardServiceImpl2 implements BoardService2{
	
	// alt + shift + R 클릭된 상태에서 모두 mapper 바꾸기 dao부분을
	
	@Autowired
	private BoardMapper2 mapper;
	
	@Value("${my.board.webpath}")
	private String webPath;
	
	@Value("${my.board.location}")  // config.properties에서 등록
	private String filePath;
	
	

	@Override
	public int boardInsert(Board board, List<MultipartFile> images) throws IllegalStateException, IOException {
		
//		// 0. XSS 방지 처리 거꾸로 해석
//		board.setBoardContent(Util.XSSHandling(board.getBoardContent() ) );
//		board.setBoardTitle(Util.XSSHandling(board.getBoardTitle() ) );  // 사용안한 이유 : th:text / [[${text}]]   /  summerNote : th:utext/   [(${text})] 쓰기 때문에
		
		
		// 1. BOARD 테이블 INSERT 하기 (제목, 내용, 작성자, 게시판코드)
		// -> boardNo (시퀀스로 생성한 번호) 반환 받기 
		int result = mapper.boardInsert(board); 
		
		// 실패 시 서비스 종료
 		if(result == 0) return 0;
 		
 		// mapper.xml에서  selectKey에서 얻어온 boardNo 
 		int boardNo = board.getBoardNo();
		
		// 2. 게시글 삽입 성공 시
		// 업로드된 이미지가 있다면 BOARD_IMG 테이블에 삽입하는 DAO 호출
		
		if(boardNo >0) { // 게시글 삽입 성공 시
			
			// List<MultipartFile> images
			// -> 업로드된 파일이 담긴 객체 MutipartFile이 5개 존재
			// -> 단, 업로드된 파일이 없어도 MutipartFile 객체는 존재
			
			// 실제 업로드된 파일의 정보를 기록할 List
			List<BoardImage> uploadList = new ArrayList<BoardImage>();
			
			
			// images에 담겨있는 파일 중 실제 업로드된 파일만 분류
			for(int i=0; i<images.size(); i++) { // Java List는 size == length
			
				// i번째 요소에 업로드한 파일이 있다면
				if(images.get(i).getSize() > 0) { 
					
					BoardImage img = new BoardImage();
					
					// img에 파일 정보를 담아서 uploadList에 추가
					
					img.setImagePath(webPath); // 웹 접근 경로
					img.setBoardNo(boardNo); // 게시글 번호
					img.setImageOrder(i); // 이미지 순서
					
					String fileName = images.get(i).getOriginalFilename(); // 파일 원본명
					
					img.setImageOriginal(fileName); // 원본명
					
					img.setImageReName(Util.fileRename(fileName));
					
					uploadList.add(img);
					
				}
			} // 분류 for문 종료
			
			
			// 분류 작업 후 uploadList가 비어있지 않은 경우
			// == 업로드한 파일이 있다.
			
			if(!uploadList.isEmpty() ) {
				
				// BOARD_IMG 테이블에 INSERT하는 DAO 호출
				result = mapper.insertImageList(uploadList);
				// result == 삽입된 행의 개수 == uploadList.size()
				
				
				// 삽입된 행의 개수와 uploadList의 개수가 같다면
				// == 전체 insert 성공
				if(result == uploadList.size()) {
					
					// 서버에 파일을 저장 (transferTo())
					
					
					// images      : 실제 파일이 담긴 객체 리스트
					//              (업로드 안된 인덱스는 빈칸)
					
					// uploadList  : 업로드된 파일의 리스트
					//              (원본명, 변경명, 순서, 경로, 게시글 번호)
					
					// 순서 == images 업로드된 인덱스
					
					
					for(int i=0; i<uploadList.size(); i++) {
						
						int index = uploadList.get(i).getImageOrder();
						
						// 파일로 변환 // 위에 있는 index
						String rename = uploadList.get(i).getImageReName(); 
						
						images.get(index).transferTo( new File(filePath + rename));
						
					}
					
					
				} else { // 일부 또는 전체 insert 실패
					
					// ** 웹 서비스 수행 중 1개라도 실패하면 전체 실패 **
					// -> rollback 필요
					
					// @Transactional(rollbackFor=Exception.class)
					// -> 예외가 발생해야지만 롤백
					
					// [결론]
					// 예외를 강제 발생 시켜서 rollback 해야된다.
					// -> 사용자 정의 예외 생성
					throw new FileUploadException(); // 예외 강제 발생
					
				}
			}
		}
		return boardNo;
	}
	
	// 게시글 수정 서비스
	@Transactional(rollbackFor=Exception.class) // 수많은 DML 구문의 예외 처리을 하기 위해서
	@Override
	public int boardUpdate(Board board, List<MultipartFile> images,
			String deleteList) throws IllegalStateException, IOException {
		
		
		
		// 2) DAO 호출
		int rowCount = mapper.boardUpdate(board);
		
		
		// 2. 게시글 부분이 수정 성공 했을 때
		if(rowCount > 0) {
			
			if(!deleteList.equals("")) { // 삭제할 이미지가 있다면
			
				// 3. deleteList에 작성된 이미지 모두 삭제
				Map<String, Object> deleteMap = new HashMap<String, Object>();
				deleteMap.put("boardNo", board.getBoardNo());
				deleteMap.put("deleteList", deleteList);
			
				rowCount = mapper.imageDelete(deleteMap);
				
				if(rowCount == 0) { // 이미지 삭제 실패 시 전체 롤백
									// -> 예외 강제로 발생
					throw new ImageDeleteException();
					
				}
			}
			
			// 4. 새로 업로드된 이미지 분류 작업
			
			// images : 실제 파일이 담긴 List
			//        -> input type = "false" 개수만큼 요소가 존재
			//        -> 제출된 파일이 없어서 MultipartFile 객체가 존재
			
			List<BoardImage> uploadList = new ArrayList<BoardImage>();
			
			for(int i=0; i<images.size(); i++) {
				
				if(images.get(i).getSize()>0) { // 업로드된 파일이 있을 경우
					
					// BoardImage 객체를 만드어 값 세팅 후
					// uploadList에 추가
					BoardImage img = new BoardImage();
					
					// img에 파일 정보를 담아서 uploadList에 추가
		               img.setImagePath(webPath); // 웹 접근 경로
		               img.setBoardNo(board.getBoardNo()); // 게시글 번호
		               img.setImageOrder(i); // 이미지 순서
		               
		               // 파일 원본명
		               String fileName = images.get(i).getOriginalFilename();
		               
		               img.setImageOriginal(fileName); // 원본명
		               img.setImageReName( Util.fileRename(fileName) ); // 변경명    
		               
		               uploadList.add(img);
		               
		               // 오라클은 다중 UPDATE를 지원하지 않기 때문에
		               // 하나씩 UPDATE 수행
		               
		               rowCount= mapper.ImageUpdate(img);
		               
		               if(rowCount == 0) {
		            	   // 수정 실패 == DB에 이미지가 없었다
		            	   // -> 이미지를 삽입
		            	   rowCount = mapper.imageInsert(img);
		            	   
		               }
		               
				}
				
			}
			
			// 5. uploadList에 있는 이미지들만 서버에 저장(transferTo())
			
			if(!uploadList.isEmpty()) {
	               for(int i=0 ; i< uploadList.size(); i++) {
	                   
	                   int index = uploadList.get(i).getImageOrder();
	                   
	                   // 파일로 변환
	                   String rename = uploadList.get(i).getImageReName();
	                   
	                   images.get(index).transferTo( new File(filePath + rename)  );                    
	                }
	                
				
				
			}
			
			
		}
		
		
			return rowCount;
	}
	
	// 게시글 삭제
	@Override
	public int boardDelete(int boardNo, int boardCode) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardNo", boardNo);
		map.put("boardCode", boardCode);
		
		return mapper.boardDelete(map);
	}

}
