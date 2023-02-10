package edu.kh.control.condition.practice;

import java.util.Scanner;

// 실습문제 작성 클래스
public class ConditionPractice {

	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 :");
		int input = sc.nextInt();
		
		String result;
		if(input <= 0 ) {
		 result = "양수만 입력해주세요";
		} else if (input % 2 ==0) {
			result = "짝수입니다";
		} else  {
		result = "홀수입니다";
		}
		System.out.println(result);
	}
	
	public void practice2() {
	Scanner sc = new Scanner(System.in);
	System.out.println("실행화면 ");
	System.out.println("국어점수 : ");
    int input = sc.nextInt();
	System.out.println("수학점수 : ");
	int input1 = sc.nextInt();
	System.out.println("영어점수 : ");
	int input2= sc.nextInt();
	
	int sum = input + input1 + input2;
	double average = sum / 3;
	String result;
    
	if( input < 40 || input1 < 40 || input2 < 40 || average < 60) {
	result = "불합격입니다";
	} else {  
		System.out.println("국어점수 : " + input);
		System.out.println("수학점수 : " + input1);
		System.out.println("영어점수 : " + input2);
		result = "축하합니다. 합격입니다. ";
	}  System.out.println(result);
}
	
	public void practice3() {
		
	}
	
	public void practice4() {
		
	}
	
	public void practice5() {
		
	}
	
	
	
}
