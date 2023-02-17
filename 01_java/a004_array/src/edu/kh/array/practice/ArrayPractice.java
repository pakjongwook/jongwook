package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {	
	
	public void Practice1() {
	
	int sum = 0;	
	int[] arr; // 배열 선언
	arr = new int[9];
	
	
	for(int i = 0; i< arr.length; i++) {
		arr[i] = i+1;
		System.out.print(arr[i]+" ");
		if(i % 2 == 0) {
			sum += arr[i];	
			}
		}
	System.out.println();
	System.out.println("짝수 번째 인덱스 합 :"+ sum);
	}
	
	public void Practice2() {
		
		int sum = 0;
		int[] arry = new int[9];
		
		for(int i = 0; i <arry.length; i++) {
			arry[i] = 9-i;
			System.out.print(arry[i]+" ");
			if(i % 2 ==1) {
				sum += arry[i];
			}
		}
		System.out.println();
		System.out.print("홀수 번째 인덱스 합 : "+ sum);
	}
	
	public void Practice3() {
		Scanner sc = new Scanner(System.in);
		int a;
		
		do {
			System.out.print("양의 정수를 입력하세요 : ");
			a = sc.nextInt();
		}while(a <= 0);
		
		int[] arr = new int[a];
		
		for(int i = 0; i<a; i++)
			arr[i] = i + 1;
		
		
		for(int i = 0; i<a; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public void Practice4() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int[] arry = new int[5];
		
		for(int i =0; i<arry.length; i++) {
			
		}
	}
	
	
	public void Practice5() {
		Scanner sc = new Scanner(System.in);
		
		
	}
	public void Practice6() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		
		int[] scoreArr = new int[input];
		
		for(int i = 0; i<scoreArr.length; i++) {
			System.out.println("배열" + i +  "번째 인덱스에 넣을 값 : ");
			int a = sc.nextInt();
			sum += a;
			System.out.print(scoreArr[i] + " ");
			}
		System.out.print("총합 : "+sum);
		
		
		
		
	}
	public void Practice7() {
		
		
	}
	public void Practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		
		
		
	}
	public void Practice9() {
		int[] a = new int[10];
		for(int i =0; i<a.length; i++) {
			a[i]=(int)(Math.random()*10+1);
			
			System.out.print(a[i]+" ");
		} 
	}
	public void Practice10() {
		int sum = 0;
		int[] a = new int[10];
		for(int i = 0; i<a.length; i++) {
			a[i] = (int)Math.random()*10+1;
			}
		for(int i =0; i<a.length ; i++) {
			if(a[i]>max) {
				
				max = a[i];
				maxIndex = i; 
				}	
			if(a[i]<min) {
				
			
				min = a[i];
				minIndex = i; 
			}
			
		}
		
		
	}
	public void Practice11() {
		
		
	}
	public void Practice12() {
		
		
	}
	public void Practice13() {
		
		
	}	
	public void Practice14() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


