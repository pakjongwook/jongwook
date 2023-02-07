package edu.kh.variable;

public class VariableEx2 {
	
	public static void main(String[] args) {
		
		boolean booleanData;
		
		int number1;
		
		double number2;
		
		char ch;
		
		/* 변수에 값 대입하기 */
		// 변수명 = 값;
		// = 기호 : 대입 연산자 (오른쪽 값을 왼쪽 변수에 저장)
		booleanData = true;
		// number1 = 123456789.123;
		// Type mismatch : cannot convert from double to int
		// int형 변수 number1에 실수를 저장할 수 없다.

		number1 = 123456789;

		number2 = 9.87654321;

		// ch = 'AA' ; // char 자료형은 '' 안에 문자 하나만 작성 가능
		ch = 'A';

		System.out.println("[값 대입 결과 확인]");
		System.out.println(booleanData);
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(ch);
		
		// 변수에 대입된 값 변경
		ch = '하';
		
		System.out.println("[ch 값 변경]");
	    System.out.println(ch);
	    
	    
	    /* 리터럴 */
	    // 직접 작성한 값 또는 변수에 대입되는 값
	    
	    // ** 자료형별로 리터럴 표기 방법이 별도 존재 **
	    
	    // int : 10, -50, 0 (기본 정수 표기법)
	    // long : 21474836481L, 0L, -10L (l,L)
	    
	    // double : 3.14, -123.456,0.0
	    // (기본 실수 표기법, 모두 실수 형태로 작성)
	    
	    // float : 3.14F, -123.456f, 0.0f (F,f)
	    
	    // boolean : true, false 만 가능 
	    
	    // char : '가', 'Z' (홀따옴표)
	    //         또는 0 ~ 65535 사이 정수
	    
	    
	    // byte, short : 10, 0, -312 (int와 동일)
	    // 왜 int와 동일할까?
	    // -> byte, short는 옛날 코드와의 호환을 위해 만들어진 자료형
	    // --> 사용 빈도가 낮아서 별도의 리터럴 표기법을 제작 X
	    // ---> 임시로 int 표기법 사용
	    
	    long number3 = 10000000000L; // 100억
	    // L을 붙이지 않으면 int 표기법으로 인식되어
	    // 100억이 int로 해석되어짐
	    // -> int의 범위 약21억을 초과하여 오류 발생
	    
	    float number4 = 1.23f;
	    // 1.23은 double의 표기법으로 인식되어 
	    // float 형 변수에 저장할 수 없어서 오류 발생
	    // -> f를 붙여서 해결
	    
	    byte number5 = 100;
	    short number6 = 200;
	    // byte,short는 int 표기법사용

	    System.out.println("[리터럴 확인");
	    System.out.println(number3);
	    System.out.println(number4);
	    System.out.println(number5);
	    System.out.println(number6);
	    
	    // 출력 시 리터럴 표기법은 생략된다.
	    
	    // - char 자료형은 정확히는 정수를 저장하는 정수형
	    // 다만, 정수를 저장하고 있다가
	    // 화면에 출력 시 문자표에 대응되는 문자가 출력된다. (인코딩)
	    
	    // char 변수 선언과 동시에 초기화
	    char test1 = 'A';
	    char test2 = 65;
	    
	    System.out.println("[char 특징 확인]");
	    System.out.println(test1);
	    System.out.println(test2);
	    
	    
	    
	    
	    
	    
	    
	   
	
	}
	
	
	

}
