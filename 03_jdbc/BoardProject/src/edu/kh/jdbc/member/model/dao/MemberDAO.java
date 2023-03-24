package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class MemberDAO {
	
	// JDBC 객체 참조 변수
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// xml에 작성된 SQL을 읽어와 저장할 객체 참조 변수
	private Properties prop;
	
	public MemberDAO() { // 기본 생성자로 객체 생성 시 XML 읽어오기
		try {
			prop = new Properties(); // 객체 생성
			
			prop.loadFromXML(new FileInputStream("member-sql.xml"));
			// String 으로 읽어옴
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
