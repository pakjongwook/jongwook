package edu.kh.control.loop.practice;

import java.nio.file.spi.FileSystemProvider;
import java.util.Scanner;

// 실습문제용 클래스
public class ForPractice {
	
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		if(input < 1) {
			System.out.println("1이상의 숫자를 입력해주세요. ");
		} else {
			for(int i=1; i<=input; i++) {
				System.out.print(i + " "); 
		}
			}
		
	}
	
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요: ");
		int input = sc.nextInt();
		
		if(input <1) {
			System.out.println("1이상의 숫자를 입력해주세요: ");
		} else {
			for(int i=4;i>=input; i--) {
				System.out.print(i + " ");
			}
		}
		
	}
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 :");
		int input = sc.nextInt();
		int sum = 0;
		
		for(int a = 1; a<=input; a++) {
			if( a == input) {
				System.out.print(a"+");
			} else {
				System.out.print
			}
		}
		
		
	}
	public void practice4() {
	         Scanner sc = new Scanner(System.in);
	         System.out.print("첫 번째 숫자 : ");
	         int a = sc.nextInt();
	         
	         
	         System.out.print("두 번째 숫자 : ");
	         int b = sc.nextInt();
	         
	     if(a < 1 || b < 1) {
	    	 System.out.println("1이상의 숫자를 입력해주세요.");
	     }else {for(int i =a; a <= b;i++) {
	    	 System.out.println(a+b);
	     	}
	     }
	} 
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		System.out.printf("=======%d단=======");
		int input = sc.nextInt();
		int input1 =sc.nextInt();
		
	   if(input <2 || input >9) {
		   System.out.println("잘못입력하셨습니다 ");
	   } else {
		   for(int i = 1; i<=9; i++) {
			   System.out.printf("%d*%d=%d\n ",input,i,input*i);
		   }
	   }
	}
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 : ");
		int input = sc.nextInt();
		
		if(input >9) {
			System.out.println("2~9 사이의 숫자만 입력해주세요. : ");
		} else {
			for() {
				
			}
		}
	}
	
	
		
		
		
}
	
	


