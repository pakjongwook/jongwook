package edu.kh.project.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Comment;

@Repository // DB 관련 + bean 등록 (IOC)저장소
public class CommentDAO {
	
	@Autowired // DI , root-context.xml
	private SqlSessionTemplate sqlsession;

	/** 댓글 목록 조회
	 * @param boardNo
	 * @return cList
	 */
	public List<Comment> select(int boardNo) {
									// boardMapper.xml 작성된 select 이용
		return sqlsession.selectList("boardMapper.selectCommentList",boardNo);
	}

	/** 댓글 삽입
	 * @param comment
	 * @return result
	 */
	public int insert(Comment comment) {
		return sqlsession.insert("commentMapper.insert",comment);
	}
	
	
}
