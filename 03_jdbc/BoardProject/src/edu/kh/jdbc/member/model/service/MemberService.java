package edu.kh.jdbc.member.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.List;

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
	
	

}
