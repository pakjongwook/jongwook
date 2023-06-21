package com.kh.test.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.user.model.service.UserService;
import com.kh.test.user.model.vo.User;

import ch.qos.logback.core.model.Model;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/searchId")
	public String searchId(@RequestParam("userId") String userId 
			, Model model) {
			
		User user = service.searchId(userId);
		
		return null;
	}
	
}