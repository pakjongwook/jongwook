package edu.kh.project.member.model.service;

import static edu.kh.project.common.JDBCTemplate.getConnection;
import static edu.kh.project.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.project.member.dto.Member;
import edu.kh.project.member.model.dao.MemberDAO;


public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	/** 로그인 서비스
	 * @param inputEmail
	 * @param inputPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String inputEmail, String inputPw)  throws Exception{
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn,inputEmail,inputPw);
		
		close(conn);
		
		return loginMember;
	}
	


}
