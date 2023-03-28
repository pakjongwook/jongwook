package edu.kh.jdbc.board.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.board.model.dto.Board;


public class BoardDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// XML에 작성된 SQL을 읽어와 저장할 객체를 참조하는 변수
	private Properties prop;
	
	public BoardDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("board-sql.xml"));
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public List<Board> selectAllBoard(Connection conn) throws Exception{
		
		// 결과 저장용 객체 생성
		List<Board> boardList = new ArrayList<>();
		
		
		try {
			// SQL 작성 (Properties 이용)
			String sql = prop.getProperty("selectAllBoard");
		
			// SQL 수행 후 결과 반환 받기
			stmt = conn.createStatement(); // DB에 전달한 데이터 통로 만들기
			rs = stmt.executeQuery(sql);
			
			
			// 1행 씩 접근하여 컬럼 값을 얻어와 옮겨담기
			while(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memeberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				int commentCount = rs.getInt("COMMENT_COUNT");
				
				Board board = new Board();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memeberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setCommentCount(commentCount);
									  
									  // 컬렉션 : 자료 구조		
				boardList.add(board); // List에 추가  List: 객체를 저장하는 것
				// 다시 board의 객체를 쓰기 위해
			}
			
			
		}finally {
			// JDBC 객체 자원 반환
			close(stmt);
			close(rs);
			
			
		}
		// 결과 반환 
		return boardList;
		
	}

	/** 게시글 상세 조회 SQL 수행
	 * @param conn
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int input) throws Exception {
		
		Board board = null;
		
		try {
			
			String sql = prop.getProperty("selcetBoard");
			
			pstmt = conn.prepareStatement(sql); // "selcetBoard" 집어넣음
			
			pstmt.setInt(1, input);
			
			pstmt.executeQuery(); // select 구문
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int boardNo = rs.getInt("BOARD_NO");
				String boardTitle = rs.getString("BOARD_TITLE");
				String memeberName = rs.getString("MEMBER_NM");
				int readCount = rs.getInt("READ_COUNT");
				String createDate = rs.getString("CREATE_DT");
				
				String boardContent= rs.getString("BOARD_CONTENT");
				int memberNo = rs.getInt("MEMBER_NO");
				
				board = new Board();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setMemberName(memeberName);
				board.setReadCount(readCount);
				board.setCreateDate(createDate);
				board.setBoardContent(boardContent);
				board.setMemberNo(memberNo);
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return board;
	}

	/** 조회수 증가 SQL 수행
	 * @param conn
	 * @param input
	 * @return
	 * @throws Exception
	 */
	public int updateReadCount(Connection conn, int input) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateReadCount");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input); // 몇번 인덱스에 결과값(위쪽 메서드: int input)을 입력
			
			result = pstmt.executeUpdate();
			// 몇행 결과을 나타내는지 (int)
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}

	/** 게시글 수정 SQL 수행
	 * @param conn
	 * @param boardTitle
	 * @param boardContent
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, String boardTitle, String boardContent, int boardNo) throws Exception {
		
		// DML 행의 개수 반환
		int result = 0; // 값이 대입안되는 경우 문제가 많음 따라서 0으로 값을 대입 || DML 실패하면 0이기 때문에
		
		try {
			String sql = prop.getProperty("updateBoard");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardTitle);
			pstmt.setString(2, boardContent);
			pstmt.setInt(3, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 게시글 삭제 SQL 수행
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int deleteBoard(Connection conn, int boardNo) throws Exception {
		
		int result = 0; // 결과 저장용 변수 선언
		
		try { // 예외가 발생 할거같은 구문을 작성
			String sql = prop.getProperty("deleteBoard"); // xml 읽어온 Properties에서 꺼내어서 쓴다. 
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo); 
			
			result = pstmt.executeUpdate();
							// DDL(CREATE ,ALTER ,DROP) 수행도 가능
							// DDL 구문만 결과로 -1 반환 
			
		}finally { // 예외구문이 발생하든 안하든 무조건 한번 실행해라
			close(pstmt);  // close(pstmt) 한번은 닫아라
			
		}
		
		return result;  // run 에 에러 안뜨고 삭제 실패 뜨면 return 구문 확인
	}

	/** 다음 게시글 번호 조회 SQL 수행 
	 * @param conn
	 * @return
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception {
		int boardNo =0;
		
		try {
			String sql = prop.getProperty("nextBoardNo");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) { //조회 결과가 1행만
					boardNo= rs.getInt(1); // 컬럼 순서 
			}
				
		}finally {
			close(rs);
			close(stmt);
		}
		
		return boardNo;
	}

	/** 게시글 삽입
	 * @param conn
	 * @param boardContent
	 * @param memberNo
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, String boardTitle, String boardContent,
			int memberNo, int boardNo) throws Exception {
			
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertBoard");
			
			pstmt = conn.prepareStatement(sql);
			
//			INSERT INTO "BOARD"          
//			VALUES(BOARD_NO,BOARD_TITLE,BOARD_CONTENT,
//			DEFAULT, DEFAULT, DEFAULT, MEMBER_NO)  
			
			// 1,2,3,4 : placeholder 값을 입력, ? 의 순서대로 쓰기
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, boardTitle);
			pstmt.setString(3, boardContent);
			pstmt.setInt(4, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}





	
	
	

}
