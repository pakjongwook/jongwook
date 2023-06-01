package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/") // 요청 주소 메핑 get,post 방식 따로 구분 안함
	public String mainForward(Model model) {
		
		model.addAttribute("message", "스프링 부트 테스트 중입니다");
		
		// Spring MVC : /webapp/WBE-INF/views/common/main.jsp
		// Spring Boot(+thymeleaf 템플릿 엔진)
		// src/main/resources/templates/common/main.html
		
		return "common/main";
		
	}
}
