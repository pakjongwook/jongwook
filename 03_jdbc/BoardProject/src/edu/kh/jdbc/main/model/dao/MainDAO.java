package edu.kh.jdbc.main.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

public class MainDAO {
	
	// 필드
	// JDBC 객체 참조 변수
	// 필드에 private 설정 캡슐화 원칙으로 외부로부터 정보을 차단하기 위해
	private Statement stmt; // SQL 수행, 결과 반환 => Statment 
	private PreparedStatement pstmt; // placeholder 를 포함한 SQL 세팅/수행
	private ResultSet rs; // SELECT 수행 결과 저장
	
	private Properties prop; 
	
	
	// - Map<String, String> 형태
	// - XML 파일 입/출력 메서드를 제공
	
	public MainDAO() { // 기본 생성자
	
		// DAO 객체가 생성될 때 XML 파일을 읽어와 Properties 객체에 저장
		
		try {
			prop = new Properties(); // prop 객체를 담아주는 것
			
			prop.loadFromXML(new FileInputStream("main-sql.xml"));
			// -> Properties 객체에
			// key:value 형식으로 xml 내용이 저장됨
			// loadFromXML : xml 로부터 읽어 오겠다. 
			
			// -> prop.getProperty("key") 호출
			// --> value (SQL) 반환 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	/** 아이디 , 비밀번호 일치 회원 조회
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception {
		
		// 1. 결과 저장용 변수 선언/객체 선언 // 변수선언 : 기본 자료형, 참조형 선언 할 수 있게
		Member member = null;
		
		try {
			// 2. SQL 작성 후 수행
			String sql = prop.getProperty("login");
			
			// PreaparedStatement 객체를 생성하고 SQL를 담아둠 placeholder (?)
			pstmt = conn.prepareStatement(sql);
			
			// placeholder에 알맞은 값 대입
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery(); // sql 이미 담았기 때문에 안써야 함
								  	   // SELECT 수행 후 결과 반환 받기
			// executeUpdate : DB 에서 DELETE,INSERT,CREATE,DROP ... 사용할 때 사용
			
			// 3. 조회 결과를 1행씩 접근해서 얻어오기
			if(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
//				String memberId = rs.getString("MEMBER_ID"); 오류는 변수명 중복
				// 입력 받은 아이디 == 조회한 아이디
				// -> DB에서 얻어올 필요가 없음
				
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("MEMBER_GENDER"); // DB : CHAR == String
				String enrollDate = rs.getString("ENROLL_DT");
				
				// Member 객체 생성 후 값 세팅
				member = new Member();
				
				member.setMemberNO(memberNo);
				member.setMemberId(memberId);
				member.setMemberName(memberName);
				member.setMemberGender(memberGender);
				member.setEnrollDate(enrollDate);
				
			}
			
		}finally {
			// 4. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(pstmt);
			
			
		}
		
		return member;
	}


	/** 아이디 중복 검사 SQL 수행
	 * @param conn
	 * @param memberId
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(Connection conn, String memberId) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDuplicationCheck");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}


	/** 회원 가입 SQL 수행(INSERT)
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp"); // signUp key의 value 얻어오겠다.
			
			pstmt = conn.prepareStatement(sql);
			
			// 
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberGender());
			
			// 수행 후 결과 반환
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}
	
	
	
}
