package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.user.model.service.UserService;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public int selectMemberId(@RequestParam("memberId") String memberId 
			, Model model) {
			
		int result = 0;
		
		
		
		result = UserService.selectMemberId(result);
		
		
		return result;
	}
	
}