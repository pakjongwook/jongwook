package edu.kh.operator.practice;

import java.util.Scanner;


public class OperatorPractice4 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 : ");
		int input1 = sc.nextInt();
		
		System.out.print("영어 : ");
		int input2 = sc.nextInt();
		
		System.out.print("수학 : ");
		int input3 = sc.nextInt();
		
		// 합계
		int sum1 = input1 + input2 + input3;
		
		// 평균
		double average = sum1 / 3; // int / double -> 자동형변환 int -> double (double)sum1 / (double)3.0 , (double)sum1 / 3
		String result = (input1 >= 40 && input2 >= 40 && input3 >= 40 && average >= 60)
				? "합격" : "불합격";
		
		System.out.println("합계 :" + sum1);
		System.out.println("평균 :" + average);
		System.out.println(result);	
		
		
		
		
		
	}

}
