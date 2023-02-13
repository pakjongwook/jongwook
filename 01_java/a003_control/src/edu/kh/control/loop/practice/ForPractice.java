package edu.kh.control.loop.practice;

import java.nio.file.spi.FileSystemProvider;
import java.sql.SQLNonTransientConnectionException;
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
		int input = sc.nextInt();
		
		System.out.printf("========%단 ======\n",input);
		for(int i =1; i<=9; i++) {
		  System.out.printf("%d * %d = %d\n",input,i,input*i);
	  }
	}
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 : ");
		int input = sc.nextInt();
		
		if(input >9) {	
			}
		}
	
	
		
	public void practice12() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row =1; row <= input ; row ++) {
			for(int col =1; col<=input; col++) {
				if(row ==1 || row ==input || col ==1 || col == input) {
					System.out.print("*");
				}else {
				System.out.print(" "); }
			}
			System.out.println();
		}
		
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int row =input; row>=1; row --) {
			for(int col=row; col >=1; col--) {
				System.out.print("*");
				}
			System.out.println();
		}
	}
	
	public void practice11() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for (int row=1; row<=input; row++) {
		/*	// 빈칸 먼저 출력 for 문 2개
			for(int col=input-row; col >=1; col--) {
				System.out.print(" ");
			}
			// 1 2 3 4
			for(int col=1; col<=row * 2 -1 ; col++) {
				System.out.print("*");
			} */
			// for문 1개, if-else 1개
			
			for(int col=1; col<=input+row-1; col++) {
				
				if(input-row >= col) {
					
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				
				System.out.println();
				}
			
			}	
		}		
			
			
			
		
	
	
		
}
	
	


