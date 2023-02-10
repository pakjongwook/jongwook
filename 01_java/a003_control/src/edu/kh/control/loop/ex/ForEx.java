package edu.kh.control.loop.ex;

import java.util.Scanner;

public class ForEx {

	/*  for 문
	 * - 끝이 정해져 있는 경우에 사용하는 반복문
	 *  (== 반복 횟수가 지정되어 있는 경우 사용)
	 *  
	 * - 작성법
	 *      int a = 1;   a < 3
	 * for( 초기식[1] ; 조건식[2][5] ; [4]증감식 ){
	 *      [3][6]조건식이 true일 때 반복 수행할 코드
	 * 
	 * 
	 * }
	 * 
	 *  // 1~4번 수행 후 조건식이 false가 나올 때 까지 5~7 반복
	 * 
	 * - 초기식 : for문을 제어하는 용도의 변수를 선언 및 초기화
	 * 
	 * - 조건식 : for문의 반복 여부를 지정하는 식
	 *            조건식이 true인 경우에만 반복 수행을 함.
	 *            
	 *            보통 초기식에 사용된 변수를 이용해서 
	 *            조건식을 작성함.
	 *            
     * - 증감식 : for문이 한 번 반복을 수행할 때 마다 
	 *            마지막에 특정 값을 증가 또는 감소시키는 식
	 *            
	 *            보통 초기식에 사용된 변수를 증가/감소 시켜
	 *            조건식의 결과를 변화하게 만드는 용도
	 * */
	
   // for문 기초 사용법 
	public void ex1() {
		
		// 1~10까지 반복 출력
		// 1,2,3,4,5,6,7,8,9,10
		// 증감식 부터 쓰기
		
		for ( int num = 1; num <= 10 ; num++) {
		    // num은 1~10까지 1씩 증가하는 변수
			System.out.println(num);
		}
		
	}
	public void ex2() {
		
		// 5부터 12까지 1씩 증가하며 출력
		for(int num =5; num <= 12; num++) {
	    System.out.print(num + " ");		
		}
	}
	
	public void ex3() {
		
		// 3 부터 20까지 2씩 증가하면서 출력하기
		for (int i = 3; i<=20; i = i += 2)// i = i +2
		System.out.print(i + " ");
	}
	
	public void ex4() {
		
		// 1부터 100까지의 모든 정수의 합 = 5050
		int sum = 0; // i가 증가 하면서 변한 값들을 누적할 변수
                     // 0으로 초기화 하는 이유 : 어떤 값을 더하든 영향이 없어서		
		for (int i = 1; i <= 100; i++) {
		// sum = sum + i;
			     sum += i;
		}
			System.out.println("합계 : "+ sum);
			
	}
	
	public void ex5(){
		// 두 정수를 입력 받아
		// 두정수 사이의 모든 정수의합 출력하기
		// 단 ,첫번째 입력받는 정수가 무조건 작다고 가정
		
	    // 정수 1 입력 : 2
		// 정수 2 입력 : 5
		// 2부터 5까지 모든 정수의 합 : 14
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
		
		int sum = 0; // 합계 저장용 변수
		
		for (int i = num1 ; i <= num2; i++) {
			sum += i;
			}
		
		System.out.printf("%d부터 %d까지 모든 정수의 합: %d"
				, num1 , num2, sum);
	}
	public void ex6() {
		
		// 다른 자료형으로 for문 사용하기
		
		// 10 부터 20까지 0.5씩 증가하며 출력
	       // int i	
		for(double i = 10 ; i <= 20; i+=0.5) { // 개인연산 double -> int로 나옴
			// 초기식을 int형을 지정하게 되는 경우 무한 루프에 빠지게 된다
			// 왜? i += 0.5 수행 시 10.5가 아닌
			//     10으로 (int형으로) 형변환되어 i에 대입되기 때문에
			//     i가 계속 10을 유지한다
			
			// 해결방법 : 초기식을 double 자료형으로 변경
			System.out.println(i);
		}
		
	}
		
	
	
	
}
