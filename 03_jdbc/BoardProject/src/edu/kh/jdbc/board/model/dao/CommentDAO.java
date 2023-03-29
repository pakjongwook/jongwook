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

import edu.kh.jdbc.board.model.dto.Comment;


public class CommentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public CommentDAO() {
		try {
			prop = new Properties();
			prop.loadFromXML(new FileInputStream("comment-sql.xml"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 댓글 목록 조회 SQL 조회
	 * @param conn
	 * @param input
	 * @return commentList
	 * @throws Exception
	 */
	public List<Comment> selectCommentList(Connection conn, int input) throws Exception {
		
		
		// 결과 저장용 객체 생성
		List<Comment> commentList = new ArrayList<>();
		
		
		
		try {
			String sql = prop.getProperty("SelectCommentList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, input);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				
				c.setCommentNo(rs.getInt(1));
				c.setCommentContent(rs.getString(2));
				c.setMemberNo(rs.getInt(3));
				c.setMemberName(rs.getString(4));
				c.setCreateDate(rs.getString(5));
				
				commentList.add(c); // 리스트에 추가 
				
				
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return commentList; // 메서드이름 부분이 오류뜨면 return 값이 확인 
		
		
	}

	/** 댓글 삽입 SQL 
	 * @param conn
	 * @param string 
	 * @param boardNo
	 * @param memberNO 
	 * @return result
	 * @throws Exception
	 */
	public int insertComment(Connection conn, String string, int boardNo, int memberNO) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("insertComment");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,string);
			pstmt.setInt(2, memberNO);
			pstmt.setInt(3,boardNo);
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 댓글 수정 SQL 
	 * @param conn
	 * @param commentContent
	 * @param string
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public int updateComment(Connection conn, String commentContent, int commentNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateComment");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContent);
			pstmt.setInt(2, commentNo);
			
			result = pstmt.executeUpdate();  // rs 안 넣는 이유 : 행이 하나도 없을 때  rs을 넣는 이유 : 행의 값이 필요할 때
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

	/** 
	 * @param conn
	 * @param commentNo
	 * @return result
	 * @throws Exception
	 */
	public int commentNo(Connection conn, int commentNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("commentNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, commentNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("MEMBER_NO"); // DB에 SELECT 구문 쓴것
				
			}
		}finally {
			close(rs);
			
		}
		return result;
	}

	/** 현재 댓글 확인 SQL
	 * @param conn
	 * @param boardNo
	 * @return
	 * @throws Exception
	 */
	public List<Comment> comm(Connection conn, int boardNo) throws Exception {
		
		List<Comment> comm = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("comm");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment co = new Comment();
				co.setCommentNo(rs.getInt("COMMENT_NO"));
				comm.add(co);
			}
			
		}finally {
			close(rs);
			
		}
		
		return comm;
	}

}
