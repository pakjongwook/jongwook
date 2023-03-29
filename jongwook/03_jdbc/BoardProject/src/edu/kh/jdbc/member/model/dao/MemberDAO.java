package edu.kh.jdbc.member.model.dao;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jdbc.member.model.dto.Member;

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


	/** 회원 목록 조회 SQL 수행
	 * @param conn
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectMemberList(Connection conn) throws Exception{
		
		// 결과 저장용 변수 선언 / 객체 생성
		List<Member> memberList = new ArrayList<>(); // member 누가 있는지 
									// 객체 배열 : 객체을 참조하는 참조변수을 저장 ,DAO에서도 새롭게 ArrayList을 선언해줘야 한다. 
		
		try {
			String sql = prop.getProperty("selectMemberList"); // Member-sql.xml 파일에 selectMemberList(내가 쓴) 작성
			// 외부파일에서 읽어온 데이터를 prop . get(얻는다.) 
			
			// c(Connection[Service]) s(Statement) r(ResultSet)
			stmt = conn.createStatement(); // createStatement => 통로  stmt(statement) --> placeholder 가 없다.
			
			rs = stmt.executeQuery(sql); // SELECT 구문을 실행할 때 사용 , 
										 // executeUpdate : SELECT을 제외한 다른 구문을 실행할 때( INSERT / DELETE / UPDATE )
										 // ResultSet : 행
			
			while(rs.next()) { // 행의 여러개일수도 있기 때문에 while
				
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NM");
				String memberGender = rs.getString("성별"); // ResultSet DB에서 결과 값(별칭) 
				
				// 컬럼 값을 Member 객체에 저장
				Member member = new Member();
				member.setMemberId(memberId); 
				member.setMemberName(memberName); 
				member.setMemberGender(memberGender);
				
				// Member 객체를 List 에 추가
				memberList.add(member); // 구문이 진행될수록 새로운 정보을 넣는다.
				
			}
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return memberList;
	}


	/** 회원 정보 수정 SQL 수행
	 * @param conn
	 * @param memberName
	 * @param memberGender
	 * @param memberNO
	 * @return
	 * @throws Exception
	 */
	public int updateMember(Connection conn, String memberName, String memberGender, int memberNO)throws Exception{
		
		// 1. 결과 저장용 변수 선언
		int result = 0; 
		
		try {
			// 2. SQL 작성, 수행
			String sql = prop.getProperty("updateMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberName);
			pstmt.setString(2, memberGender);
			pstmt.setInt(3, memberNO);
			
			result = pstmt.executeUpdate();  // 결과 값의 행의 수정되기 때문에 ... 1행, 2행,3행...
			
			
		}finally {
			// 3. JDBC 객체 자원 반환
			close(pstmt);
		}
		
		// 4. 결과 반환 
		return result;
	}


	/** 비밀번호 변경 SQL 수행
	 * @param conn
	 * @param memberPw
	 * @param newPw
	 * @param memberNO
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(Connection conn, String memberPw, String newPw, int memberNO) throws Exception {
		int result = 0; // 결과 저장할 변수선언 // 비밀번화가 변경되었는지 안되어 있는지 확인 -> int확인(MemberView 확인)
		
		try {
			String sql = prop.getProperty("updatePw");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setInt(2, memberNO);
			pstmt.setString(3, memberPw); // member-sql where 구문 순서 확인
			
			result = pstmt.executeUpdate(); 
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}


	/**
	 * @param conn 
	 * @param memberPw
	 * @param memberNO
	 * @return
	 * @throws Exception
	 */
	public int unRegisterMember(Connection conn, String memberPw, int memberNO) throws Exception{
		int result = 0;
		
	try {	
		String sql = prop.getProperty("unRegisterMember");
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, memberPw);
		pstmt.setInt(2, memberNO);
		
		result = pstmt.executeUpdate();
		
		}finally {
			close(pstmt);
			
		}
		return result;
	}


	
}