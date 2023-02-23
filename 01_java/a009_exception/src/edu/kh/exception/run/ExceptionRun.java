package edu.kh.exception.run;

import java.io.IOException;  // 클래스 : 객체의 기능과 속성을 정의한것

import edu.kh.exception.service.ExceptionService;

public class ExceptionRun {

	public static void main(String[] args) throws IOException {
		
		ExceptionService service = new ExceptionService();
		
		
//		service.ex1();
		service.ex2(); // 예외 catch
	}

}
