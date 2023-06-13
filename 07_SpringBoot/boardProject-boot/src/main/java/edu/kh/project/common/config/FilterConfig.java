package edu.kh.project.common.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.kh.project.common.filter.BoardFilter;
import edu.kh.project.common.filter.LoginFilter;

@Configuration
public class FilterConfig {
	   @Bean
	   public FilterRegistrationBean<BoardFilter> boardFilter(){
	      
	      FilterRegistrationBean<BoardFilter> resiRegistrationBean = new FilterRegistrationBean<BoardFilter>();
	      
	      resiRegistrationBean.setFilter(new BoardFilter());
	      
	      String[] url = {"/board/*", "/board2/*"}; // 추가할꺼면 여기서 입력
	      resiRegistrationBean.setUrlPatterns(Arrays.asList(url)); // url 패턴 여러 개 지정
	      resiRegistrationBean.setName("boardFilter"); // 이름
	      resiRegistrationBean.setOrder(2); // 여러 필터가 있을 때 순서
	      return resiRegistrationBean;
	   }
}
