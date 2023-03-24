package edu.kh.jdbc.main.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.jdbc.main.model.dao.MainDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MainService { 

	private MainDAO dao = new MainDAO();

	/** 로그인 서비스
	 * @param memberId
	 * @param memberPw
	 * @return member
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		
		// 1. Connection 생성
		Connection conn = getConnection(); 
		
		// 2. DAO 호출
		Member member = dao.login(conn, memberId, memberPw);
		
		
		// 3. Connection 반환
		close(conn);
		
		// 4. 결과 반환 
		return member;
	}

	/** 아이디 중복 검사 서비스
	 * @param memberId 
	 * @return
	 * @throws Exception
	 */
	public int idDuplicationCheck(String memberId) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.idDuplicationCheck(conn,memberId); // view에서 conn, memberId 호출
														    // dao 가서 메서드 생성
		close(conn);
		
		
		return result; // int result(변수) 선언한 것을 result 반환(return) 
	}

	/** 회원 가입 서비스
	 * @param member
	 * @return
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		Connection conn = getConnection();
		
		// DAO 호출
		int result = dao.signUp(conn,member); // --> INSERT 수행
		
		// 트랜잭션 처리
		if(result >0) commit(conn);  // 연결정보(Connection) 필요
		else		  rollback(conn);
		
		close(conn);
		
		return result;
	}

	

	
}
