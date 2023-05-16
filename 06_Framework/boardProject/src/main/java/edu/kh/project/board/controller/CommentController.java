package edu.kh.project.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.service.CommentService;

// @Controller + Responsebody 

@RestController // 요청 / 응답 처리(단, 모든 요청 응답은 비동기)
				// -> REST API 구축하기 위한 Controller
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@GetMapping(value ="/comment",produces ="application/json; charset=UTF-8") 
//	@ResponseBody // 모두 비동기 처리 -> 이 controller 모두 비동기 
	public List<Comment> select(/**@RequestParam("boardNo")*/ int boardNo) {
		
		return service.select(boardNo); // HttpMessageConvert List -> JSON 변환
	}
	
	// 댓글 삽입
	@PostMapping("/comment")
	public int insert(@RequestBody Comment comment) {
		// 요청 데이터(JSON)를 HttpMessageConvert가 해석해서 Java 객체(comment)에 대입
		
		return service.insert(comment);
	}
	
	// 댓글 삭제
		@DeleteMapping("/comment")
		public int delete(@RequestBody int commentNo) {
				// ajax 요청 시 body에 담겨있는 하나 밖에 없는 데이터는
				// 매개변수 int commentNo 담기게 된다
			return service.delete(commentNo);
		}


		// 댓글 수정
		@PutMapping("/comment")
		public int update(@RequestBody Comment comment) {
			return service.update(comment);
		}

			

	 
}
