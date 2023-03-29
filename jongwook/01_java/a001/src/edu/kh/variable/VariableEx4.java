package edu.kh.variable;

public class VariableEx4 {
	
	public static void main (String[] args ) {
		
		// string (문자열)
		// - 문자열을 저장하는 자료형
		// -기본 자료형x
		// - 참조형 o
		
		// 문자열 리터럴 표기법 : "" (쌍따옴표)
		
		
		String str1 = "helloWorld";
		
		System.out.println(str1);
		
		// 출력하고자 하는 값의 리터럴 표기법을 작성
		System.out.println("안녕");
		
		
		System.out.println("---------------------------------");
		
		String name = "빡군";
		
		int age = 29;
		
		char gender = '남';
		
		System.out.println(age + 1); // 정수 +정수 = 두 수의 합
		
		System.out.println(name +"이다"); // 문자열 + 문자열 = 이어쓰기
		
		System.out.println(name + age); // 문자열 + 정수 = 이어쓰기
		
		System.out.println(name + gender + age); // 문자 + 문자 + 정수 = 이어쓰기
		
		// 빡군은 29세 남성이다.
		System.out.println(name + "은" + age + gender + "성이다" );
		
		// 사칙연산 연산 순위 적용 ( 왼쪽-> 오른쪽 )
		System.out.println(100 + age + name); // 정수 + 정수 + 문자열
		                                      // = 두 정수 합 + 문자열(이어쓰기)
		
	}

}
