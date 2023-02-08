package edu.kh.variable;

public class PrintEx {

	public static void main (String[] args) {
		
		// 출력 메서드
		
		// System.out.print();
		// -> () 안의 내용을 출력 ( 끝나고 줄바꿈 X)
		
		// system.out.println();
		// -> () 안의 내용을 출력 ( 끝나고 줄바꿈 o)
		
	   System.out.println(1);
	   System.out.println(2);
	   System.out.println(3);
	   
	  
       //System.out.printf(" 패턴이 포함된 문자열 ", 변수 또는 값);
	   // -> " 패턴이 포함된 문자열 출력시 "
	   // 패턴 자리에 뒤에 작성된 변수 또는 값을 순서대로 대입
	   
	   String name = "홍길동";
	   int age = 5;
	   char gender = '남';
	   double height = 124.5;
	
	   // 홍길동님은 나이 5세 키 124.5cm의 남성입니다.
	   
	   System.out.println(name + "님은 나이" + age + "세 키" + height + "cm의"+ gender
			   + "성입니다");
	   
	   // printf()
	   // %s : 문자열 string
	   // %d : 10진 정수         %5d 왼쪽띄어쓰기 %-5d 오른쪽 띄어쓰기   
	   // %f : 실수 ( 기본 소수점 6자리 )
	   // -> %.1f 소수점아래 1자리까지 표시
	   // -> %.2f 소수점아래 2자리까지 표시
	   // -> %.3f 소수점아래 3자리까지 표시
	   // %c : 문자형 char
	   // %b : 논리형
	   System.out.printf(" %s님은 나이 %d세, 키 %.1fcm의 %c성입니다. ", 
			   name, age, height, gender);
	   
	   // printf()는 출력 후 줄이 바뀌지 않는다 !! 
	   // 해결방법 1) system.out.println(); 작성
	   // System.out.println();
	   
	   // 해결 방법 2) 탈출 (escape) 문자 \n 작성
	   
	   System.out.println("\nhello \t\tworld \u0050");
	   // \u0050 16진수


	   
		
		
	}
	
	
	
	
}
