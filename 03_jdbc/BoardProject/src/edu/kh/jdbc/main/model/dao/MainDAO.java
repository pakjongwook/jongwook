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
			// loadFromXML : 
			
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
			
			System.out.println(sql);
			
		}finally {
			
		}
		
		return null;
	}
	
	
}
