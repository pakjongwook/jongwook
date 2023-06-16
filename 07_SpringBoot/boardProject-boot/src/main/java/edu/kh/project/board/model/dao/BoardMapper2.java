package edu.kh.project.board.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.BoardImage;

@Mapper  // interface로 바꾸기 자동으로 sql이 등록됨
public interface BoardMapper2 {
	
	// return 한줄만 등록되어있는거는 다 지워도 됨
	
	/** 게시글 삽입
	 * @param board
	 * @return boardNo
	 */
	public int boardInsert(Board board);

	/** 이미지 리스트(여러 개) 삽입
	 * @param uploadList
	 * @return result
	 */
	public int insertImageList(List<BoardImage> uploadList); // 추상메서드로 만들기
	/** 게시판 수정
	 * @param board
	 * @return rowCount
	 */
	public int boardUpdate(Board board);

	/** 이미지 삭제
	 * @param deleteMap
	 * @return rowCount
	 */
	public int imageDelete(Map<String, Object> deleteMap);
	/** 이미지 수정
	 * @param img
	 * @return rowCount
	 */
	public int ImageUpdate(BoardImage img);

	/** 이미지 삽입(1개)
	 * @param img
	 * @return rowCount
	 */
	public int imageInsert(BoardImage img);

	/** 게시글 삭제
	 * @param map
	 * @return result
	 */
	public int boardDelete(Map<String, Object> map);

}
