package edu.kh.jdbc.board.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jdbc.board.model.dao.CommentDAO;
import edu.kh.jdbc.board.model.dto.Comment;




public class CommentService {

	
	private static CommentDAO commentDao = new CommentDAO();
	
	/** 댓글 삽입 서비스
	 * @param string
	 * @param boardNo
	 * @param memberNO
	 * @return
	 * @throws Exception
	 */
	public static int insertComment(String string, int boardNo, int memberNO) throws Exception {
		
		Connection conn = getConnection();
		
		int comment = commentDao.insertComment(conn,string,boardNo,memberNO);
		
		if(comment >0) {
			commit(conn);
			comment = boardNo;
		}else {
			rollback(conn);
		}
		close(conn);
		
		return comment;
	}

	/** 댓글 수정 서비스
	 * @param commentContent
	 * @param string
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public static int updateComment(String commentContent,  int commentNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = commentDao.updateComment(conn,commentContent,commentNo);
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
	
		
		return result;
	}

	/** 댓글 번호 확인 서비스
	 * @param commentNo
	 * @return 
	 * @throws Exception
	 */
	public static int commentNo(int commentNo) throws Exception{
		
		int result = 0;
		
		Connection conn = getConnection();
		
		result = commentDao.commentNo(conn,commentNo);  // int result 로 쓰면 오류 -->위에서 int 선언했기 때문
		
		if(result>0) commit(conn);
		else         rollback(conn);
		
		close(conn);
	
		
		return result;
	}

	/** 현재 댓글 확인
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public static List<Comment> comm(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		List<Comment> comm = commentDao.comm(conn,boardNo);
		
		if(!comm.isEmpty()) commit(conn);
		else         rollback(conn);
		
		close(conn);
		
		return comm;
	}
	
	

}
