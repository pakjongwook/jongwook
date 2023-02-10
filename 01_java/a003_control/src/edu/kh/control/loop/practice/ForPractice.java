package edu.kh.control.loop.practice;

import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		for(int i =1; i<=input; i++) {
			System.out.print(i + " ");
			if(input < 1){
				System.out.print("1이상의 숫자를 입력해주세요: ");
			} else {
				System.out.println();
			}
				
		}
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		for(int i=4; input >= 11; i-- ){
			System.out.print(i + " ");
		}
		
		
		
		
		
	}
		
		
	 
		
}
	
	
	


