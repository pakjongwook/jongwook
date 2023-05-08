package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dao.BoardDAO;
import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;

@Service
public class BoardServiceImpl implements BoardService{ // BoardService의 상속받은 자식

		@Autowired
		private BoardDAO dao;

		// 게시판 종류 목록 조회
		@Override
		public List<Map<String, Object>> selectBoardTypeList() {
			
			return dao.selectBoardTypeList();
		}

		/**
		 * 게시글 목록 조회
		 */
		@Override
		public Map<String, Object> selectBoardList(int boardCode, int cp) {
			
			// 1. 특정 게시판의 삭제되지 않은 게시글 수 조회
			int listCount = dao.getListCount(boardCode);  // boardCode 어떤 게시판인지 전달하기 때문
			
			// 2. 1번 조회 결과 + cp를 이용해서 Pagination 객체 생성
			// -> 내부 필드가 모두 계산되어 초기화됨
			Pagination pagination = new Pagination(listCount, cp);
			
			// 3. 특정 게시판에서
			// 현재 페이지에 해당하는 부분에 대한 게시글 목록 조회
			// (어떤 게시판(boardCode)에서 
			//	몇페이지(pagination.currentPage)에 대한 
			//	게시글 몇 개(pagination.limit) 조회)
			List<Board> boardList = dao.selectBoardList(pagination, boardCode);
			
			// 4. pagination, boardList를 Map에 담아서 반환
			// value 로 어떤게 들어올지를 모르기 때문에 --> Object 모든 객체의 최상위 부모 참조변수 = 자식 객채의 다형성 업캐스팅
			Map<String, Object> map = new HashMap<>(); // time 추론--> 생략가능 앞 Map 이랑 같음
			map.put("pagination", pagination);
			map.put("boardList", boardList);
			
			return map;
		}
	
}
