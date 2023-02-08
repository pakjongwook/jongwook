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
		
		int sum1 = input1 + input2 + input3;
		System.out.println("합계 : " + sum1);
		
		int averge = (double)sum1 /3; 
		System.out.println("평균 : " +average);
		String result = (input1 >= 40 && input2 >= 40) && input3 >= 40;
		
	
		
		
		
		
		
	}

}
