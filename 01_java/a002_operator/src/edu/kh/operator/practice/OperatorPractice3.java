package edu.kh.operator.practice;

import java.util.Scanner;

public class OperatorPractice3 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실행화면] ");
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		String result1 = num1 > 0 ? "양수입니다": "음수입니다 ";
		System.out.println(result1);
		
		System.out.print("정수 입력: ");
		int num2 = sc.nextInt();
		String result2 = num2 < 0 ? "음수입니다" : "양수입니다";
		System.out.println(result2);
		
		System.out.print("정수 입력 : ");
		int num3 = sc.nextInt();
		String result3 = num3 == 0 ? "0입니다" : "양수입니다";
		System.out.println(result3);
		
	}

}
