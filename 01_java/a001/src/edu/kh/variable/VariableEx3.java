package edu.kh.variable;

public class VariableEx3 {

	public static void main(String[] args) {
		
		// 변수 : 메모리에 값을 저장할 수 있는 공간
		//        저장된 값을 변할 수 있다.
		
		// 상수 : 메모리에 값을 저장할 수 있는 공간
		//         한번 저장된 값은 변할 수 없다.
		
		// 상수 예약어 : final
		
		// 변수 값 변경 확인
	    int num1 = 100;
		num1 = 200;
		
		// 상수 값 변경 확인
		final int num2 = 99;
		// num2 = 999;
		//The final local variable num2 cannot be assigned. It must be blank and not using a compound assignment
		// -> 한 번 값이 저장된 상수 num2에 다른 값을 저장하지 못함
		
		// 상수 명명 규칙 및 활용법
		// - 명명규칙 : 모두 대문자 표기, 단어 구분시 _사용
		
		final int CONSTANT_NUMBER = 100;
		
		
		// - 활용법
		
		final double PI = 3.14;
		
		double result = PI * 10 * 10;
		
		System.out.println(result);
		
		
		
		final int UP = 5;
		final int DOWN = -5;
		final int INIT = 0; // 초기화(first)
		
		System.out.println("-----------------------");
		
		int result2 = INIT;
		System.out.println(result2); // 0
		
		// 대입 연사자(=) 기호를 기준으로 
		// 오른쪽부터 해석
		result2 = result2 + UP;
		System.out.println(result2);
		
		result2 = result2 + DOWN + DOWN;
		System.out.println(result2);
		
		// ** 변수 명명 규칙 **
		
		// 1. 대소문자 구분되고 길이 제한이 없다
		int apple;
		// int apple; //Duplicate local variable apple 변수명 중복
		int applE;
		
		 int freeTradeAgreement;
		 int showMeTHeMoney;
		 int abcdefghijklmnopqrstuvwxyz;
		
		// 2. 예약어 사용 금지
		 // int int;
		 // double char;
		 // boolean final;

		// 3. 숫자로 시작 금지
		 // long 100number; // 에러
		 long number100;
		 
		 // 4.  _$ 만 특수문자 사용 가능
		 float $num$ber;
		 float _num_ber;
		 // float +num=ber; 에러     -> _상수 단어구분
		 
		 // 5. 카멜 표기법
		 // - 변수명 첫 글자는 소문자
		 // - 연결된 단어의 첫 글자는 대문자
		 
		 int studentAge;
		 char helloWorld; // char Helloworld , char hello World X
		 // 참고) 변수명에 언어 제한이 없음
		 int 정수1번;
		 double 실수1번입니다;
		 
		
		
		
		
		
		
		
		
		

	}
	
}
