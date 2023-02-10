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
		} else if (input == 0) {
			result = "짝수입니다";
		} else if(input ) {
		result = "홀수입니다";
		}
		System.out.println(result);
	}
	
	public void practice2() {
		
	}
	
	public void practice3() {
		
	}
	
	public void practice4() {
		
	}
	
	public void practice5() {
		
	}
	
	
	
}
