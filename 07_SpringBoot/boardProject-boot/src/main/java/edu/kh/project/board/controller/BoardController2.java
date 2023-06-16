
package edu.kh.project.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.service.BoardService;
import edu.kh.project.board.model.service.BoardService2;
import edu.kh.project.member.model.dto.Member;
import jakarta.servlet.http.HttpSession;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/board2")
@SessionAttributes({ "loginMember" })
public class BoardController2 {

	@Autowired
	private BoardService2 service;

	@Autowired // 게시글 수정 시 상세조회 서비스 호출용
	private BoardService boardService;

	// 게시글 작성 화면 전환 / boardCode : 게시글 번호
	@GetMapping("/{boardCode:[0-9]+}/insert") // + 한자리 이상
	public String BoardInsert(@PathVariable("boardCode") int boardCode) {
		// @Pathvariable : 주소 값 가져오기 + request scope에 값 올리기

		return "board/boardWrite"; // forward : jsp로 요청을 해서 위임
	}

	// 게시글 작성 "/board2/**1**/insert --> ** int **
	@PostMapping("/{boardCode:[0-9]+}/insert")
	public String boardInsert(@PathVariable("boardCode") int boardCode, Board board // 커멘드 객체(필드에 파라미터 담겨있음!!)
			, @RequestParam(value = "images", required = false) List<MultipartFile> images,
			@SessionAttribute("loginMember") Member loginMember, RedirectAttributes ra)
			throws IllegalStateException, IOException {

		// 파라미터 : 제목, 내용, 파일(0~5개)
		// 파일 저장 경로 : HttpSession
		// 세션 : 로그인한 회원의 번호
		// 리다이렉트 시 데이터 전달 : RedirectAttributes
		// 작성 성공 시 이동할 게시판 코드 : @PathVariable("boardCode")

		/*
		 * List<MultipartFile> - 업로드된 이미지가 없어도 List에 요소 MultipartFile 객체가 추가됨
		 * 
		 * -- 단, 업로드된 이미지가 없는 MultipartFile 객체는 파일크기(size)가 0 또는
		 * 파일명(getOriginalFileName())이
		 * 
		 */

		// 1. 로그인한 회원 번호를 얻어와 board에 세팅
		board.setMemberNo(loginMember.getMemberNo());

		// 2. boardCode도 board에 세팅
		board.setBoardCode(boardCode);

		// 3. 업로드된 이미지 서버에 실제로 저장되는 경로
		// + 웹에서 요청 시 이미지를 볼수 있는 경로(웹 접근 경로) 사용안한 이유 : resources가 없기 떄문에  config.properties에 다 뺏놓았기 때문 / webapp에 없기 때문
//		String webPath = "/resources/images/board/";
//		String filePath = session.getServletContext().getRealPath(webPath); // applicatrion -> server 단위 객체 ==> server
//																			// 진짜 주소를 얻어와라

		// 게시글 삽입 서비스 호출 후 삽입된 게시글 번호 반환 받기
		int boardNo = service.boardInsert(board, images);

		// 게시글 삽입 성공 시
		// -> 방금 삽입한 게시글의 상세 조회 페이지 리다이렉트
		// -> /board/{boardCode}/{boardNo}

		String message = null;
		String path = "redirect:";

		if (boardNo > 0) { // 성공 시
			message = "게시글 등록 성공";
			path += "/board/" + boardCode + "/" + boardNo;

		} else {
			message = "게시글 등록 실패 ................";
			path += "insert"; // 게시글 쓰는 화면

		}

		ra.addFlashAttribute("message", message);

		return path;
	}

	// 게시글 수정 화면 전환
	@GetMapping("{boardCode}/{boardNo}/update")
	public String boardUpdate(@PathVariable("boardCode") int boardCode, @PathVariable("boardNo") int boardNo,
			Model model
	// Model : 데이터 전달용 객체(기본 scope : request)
	// -> Controller 에서 데이터을 전달 -> board.jsp 의 화면의 정보가 없어서 그 정보을 전달해주는 객체
	) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);

		Board board = boardService.selectBoard(map); // 수정의 제목과 내용의 DB 조회한 내용을

		// if(로그인회원번호 != 작성자 번호)리다이렉트

		model.addAttribute("board", board);
		// forward(요청위임) -> request scope 유지

		return "board/boardUpdate"; // 전달
	}

	@PostMapping("/{boardCode}/{boardNo}/update")
	public String boardUpdate(Board board // 커멘드 객체(name속성 값 == 필드 경우 필드에 파라미터 세팅 (ModelAttribute 생략))
			, @RequestParam(value = "cp", required = false, defaultValue = "1") int cp // 쿼리 스트링을 유지하는 용도
			, @RequestParam(value = "deleteList", required = false) String deleteList // 삭제할 이미지 순서
			, @RequestParam(value = "images", required = false) List<MultipartFile> images // 업로드된 파일 리스트
			, @PathVariable("boardCode") int boardCode, @PathVariable("boardNo") int boardNo 
																										         
																													
			, RedirectAttributes ra // 리다이렉트 시 값 전달용
	) throws IllegalStateException, IOException {

		// 1) boardCode, boardNo를 커멘드 객체(board)에 세팅
		board.setBoardCode(boardCode);
		board.setBoardNo(boardNo);

		// board(boardCode, boardNo, boardTitle, boardContent)

	
		// 3) 게시글 수정 서비스 호출
		int rowCount = service.boardUpdate(board, images, deleteList);

		// 4) 결과에 따라 message 설정
		String message = null;
		String path = "redirect:";

		if (rowCount > 0) {
			message = "게시글이 수정됨";
			path += "/board/" + boardCode + "/" + boardNo + "?cp" + cp; // 상세조회 페이지
		} else {
			message = "게시글 수정 실패";
			path += "update";
		}
		ra.addFlashAttribute("message", message);

		return path;
	}

	@GetMapping("/{boardCode}/{boardNo}/delete") // boardCode --> {boardCode 정보} //
	public String boardDelete(Board board, @PathVariable("boardCode") int boardCode,
			@PathVariable("boardNo") int boardNo, RedirectAttributes ra // GetMapping 방식
	) {

		board.setBoardCode(boardCode);

		int boardNo1 = service.boardDelete(boardNo, boardCode);

		String message = null;
		String path = "redirect:";

		if (boardNo1 > 0) {
			message = "게시글 삭제 성공";
			path += "/board/{boardCode}";

		} else {
			message = "게시글 삭제 실패 ";
			path += "/board/{boardCode}/{boardNo}";

		}

		ra.addFlashAttribute("message", message);

		return path;
	}

}