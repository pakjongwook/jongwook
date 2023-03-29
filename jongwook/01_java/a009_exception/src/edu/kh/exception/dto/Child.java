package edu.kh.exception.dto;

import java.io.EOFException;

public class Child extends Parent { // 클래스 간의 상속에서는 extends

	@Override
	public void test() throws EOFException{ // IOE 삭제 --> 컴파일에러
		// 오버라이딩 시 예외처리는 같거나 좁은(구체적) 범위
		System.out.println("자식 test()");
	}
	
	
}
