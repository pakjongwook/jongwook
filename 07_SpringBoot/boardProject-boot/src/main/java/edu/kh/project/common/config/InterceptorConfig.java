package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration // 구성 / 설정
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Bean // 개발자가 수동으로 관리해주는 어노테이션
	public BoardTypeInterceptor boardTypeInterCeptor() {
		
		return new BoardTypeInterceptor();
	}
	/** 또 다른 interceptor 등록
	@Bean // 개발자가 수동으로 관리해주는 어노테이션
	public BoardTypeInterceptor boardTypeInterCeptor() {
		
		return new BoardTypeInterceptor();
	}
	*/
	
	@Override // alt + shift + S -> Orverride 에서 네번째
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Bean으로 등록된 BoardTypeInterceptor를 얻어와 인터셉터로 등록(인터셉터 여러 개 작성 시 Bean등록하고 registory 작성 )
		registry.addInterceptor( boardTypeInterCeptor() )
		.addPathPatterns("/**") // 가로챌 경로 지정(여러개 작성 시 ,로 구분)
		.excludePathPatterns("/css/**","/image/**","/js/**"); // 가로채지 않을 경로
		
		
	}
}
