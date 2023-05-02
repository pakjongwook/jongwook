package edu.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // DB 연결 의미 + bean(Spring 관리하는 객체) 등록 (IOC)
public class AjaxDAO {
	
	@Autowired // bean 중에서 타입이 같은 객체를 DI(의존성 주입)
	private SqlSessionTemplate sqlSession;

	public String selectNickName(String email) {
		
		return sqlSession.selectOne("ajaxMapper.selectNickname",email);
						// selectOne 하나만 조회하니까
	}

	public String selectMemberTel(String nickname) {
		
		return sqlSession.selectOne("ajaxMapper.selectMemberTel",nickname);
	}

	public int checkEmail(String email) {
		
		return sqlSession.selectOne("ajaxMapper.checkEmail",email);
	}

	/** 닉네임 중복 검사
	 * @param nickname
	 * @return count
	 */
	public int checkNickname(String nickname) {
	
		return sqlSession.selectOne("ajaxMapper.checkNickname",nickname);
	}
	
	
	
}
