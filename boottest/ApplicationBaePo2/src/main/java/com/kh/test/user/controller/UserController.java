package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	// form 태그의 method을 안쓰면 기본이 get방식
	@GetMapping("/selectUser")
	public String SelectUserNo(int userNo, Model model) {		
		
		User user = service.selectUserNo(userNo);
		
		if(user != null) {
			
			model.addAttribute("user", user);
			
			// 요청을 위임하게 위한 html 경로작성( 접두사,접미사 제외) String => forward,redirect은 대부분 String("")
			return "searchSuccess";
			
		}else {
		
		return "searchFail";
		
		}
	}
	
}