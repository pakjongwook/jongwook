package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;
import java.util.Random;

import edu.kh.jdbc.member.model.dao.MemberDAO;
import edu.kh.jdbc.member.model.dto.Member;

public class MemberService {
	// dao 계속 호출
	
	private MemberDAO dao = new MemberDAO();

	/** 회원 목록 조회 서비스
	 * @return
	 * @throws Exception
	 */
	public List<Member> selectMemberList() throws Exception {
		
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectMemberList(conn);
		// dao 먼저 쓰고 한 행씩 List에 있는 Member 불러온다.
		close(conn);
		
		return memberList;
	}

	/** 회원 정보 수정 서비스
	 * @param memberName
	 * @param memberGender
	 * @param memberNO
	 * 
	 * @throws Exception
	 */
	public int updateMember(String memberName, String memberGender, int memberNO) throws Exception {
		
		Connection conn = getConnection();
		
		// dao 호출 후 결과 반환 받기
		int result = dao.updateMember(conn, memberName,memberGender,memberNO);
		
		// 트랜잭션 처리
		if(result >0) commit(conn);
		else          rollback(conn);
		
		close(conn);
		
		return result; // 반환형 : void가 있으면 result(int) 형을 받을 수 없음 따라서 반환형을 int형으로 변경
		
	}

	/** 비밀번호 변경 서비스
	 * @param memberPw
	 * @param newPw
	 * @param memberNO
	 * @return result
	 * @throws Exception
	 */
	public int updatePassword(String memberPw, String newPw, int memberNO) throws Exception {
		
		Connection conn = getConnection();
		
		// dao 호출 후 결과 반환 받기
		int result = dao.updatePassword(conn,memberPw,newPw,memberNO); // 현재비번, 새비번, memberNO
		
		// 트랜잭션 처리
		if(result >0) commit(conn);
		else          rollback(conn);
		
		close(conn);
		return result; 
	}
	
	
	/** 숫자 6자리 보안코드 생성 서비스
	 * @return code
	 */
	public String createSecurityCode() {
		
		StringBuffer code = new StringBuffer();
		
		// String : 불변성 String a = "a"; a += "b"; 변경 불가능
		// StringBuffer : 가변성  // "ab"변경 가능
		
		Random ran = new Random(); // 난수 생성 객체
		
		
		for(int i =0; i<6; i++) {
			int x = ran.nextInt(10); // 0이상 10미만 정수
			code.append(x); // StringBugger 마지막에 추가(뒤에 이어 붙임)
			
		}
		
		return code.toString(); // 저장된 내용을 문자열로 반환
		
	}

	/**
	 * @param memberPw
	 * @param memberNO
	 * @return
	 * @throws Exception
	 */
	public int unRegisterMember(String memberPw, int memberNO) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.unRegisterMember(memberPw,memberNO);
		
		
		
		close(conn);		
		return result;
	}

	
	

}
