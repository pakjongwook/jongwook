package edu.kh.polymorphism.ex2.service;

import java.util.Scanner;

import edu.kh.polymorphism.ex2.dto.*; // dto 패키지의 모든 클래스 import 
// * (별, 애스터리스크): 모든, ALL 

public class TestService {

	public void ex1() {
		
		// 1. 추상 클래스는 진짜로 객체로 못만들까?
		// Animal a = new Animal();
//		Cannot instantiate the type Animal : 객체화 할 수 없는 타입
//		-> 추상 클래스이기 때문에 
		
		// 2. Animal을 상속 받은 자식 객체 생성
		Person p1 = new Person("포유류", "잡식", "홍길동", 25);
		p1.breath();
		
//		3. 추상 클래스는 객체 생성 x / 부모 타입 참조 변수o
//		(다형성의 업캐스팅)
		Animal a1 = new Person("포유류", "채식", "김종국",30);
		a1.breath(); 
		//  정적 바인딩으로 구현 /실행은 동적 바인딩에 의해 Person에 구현된 breath()가 호출됨
		
		// 객체배열 + 추상 클래스
		Animal[] arr = new Animal[3];   
		// 추상클래스는 객체 만들수 없는데 Animal 객체 참조 변수의 묶음을 생성
		//(Animal 객체는 만들 수 없다.!)
		
		arr[0] = new Fish();    // arr = animal 참조변수
		arr[1] = new Person();
		arr[2] = new Fish();
		
		
		System.out.println("===============");
		// 향상된 for문
		// 오른쪽 배열
		for(Animal a : arr) { // 정적바인딩 (부모) 값이 나와야 하는 데 출력 값은 동적바인딩 (자식)객체 결과값이 나온다 
			a.breath();  
		}
		
		
	}
	
	public void ex2() {
		
		// 인터페이스
		
		// 1. 인터페이스는 상수형 필드(public static final)만 작성 가능 확인
		// - 인터페이스에 작성했지만 클래스에 작성하는 static 필드와 사용법 동일
		//- ***** 인터페이스는 무조건 상소형 필드만 작성 가능하기 때문에
		// 상수를 나타내는 public static final을 생략해도
		//작성된걸로 인식된다.
		// 인터페이스 필드는 == 묵시적(암묵적)으로 public static final 이다. 
		System.out.println(KH.KH_ADDRESS);
		System.out.println(KH.A);
		
		
		// 2. 인터페이스로 객체 생성X  부모 타입 참조 변수O
//		KH k = new KH(); // 객체 생성X
		
		 // 객체 배열 + 다형성 + 동적바인딩
		KH[] arr = new KH[2]; // KH 참조 변수의 묶음 생성
		
		arr[0] = new HongGilDong();
		arr[1] = new KimSamSun();
		
		for(KH K : arr) {
			K.lesson();
		}
		
		
	}
	
	public void ex3() {
		//  계산기 구현
		
		Calculator cal = new PJWCalculator();
//		Calculator cal = new GGTCalculator();
//		Calculator cal = new NewCalculator();
		
		
		int a =7;
		int b =4;
		System.out.println("a = 7, b =4");
		System.out.println("합 : "+cal.plus(a, b));
		System.out.println("차 : "+cal.minus(a, b));
		System.out.println("곱 : "+cal.multiple(a, b));
		System.out.println("몫 : "+cal.divide(a, b));

		System.out.println("나누기 결과(실수) : "+cal.divide(a, b));
		
		System.out.println("===============");
		
		int r =12;
		System.out.println("반지름 = "+r);
		System.out.println("원의 넓이 : "+cal.areaofCircle(r));
		
		System.out.println("=========================");
		
		
		int num = 2;
		int x = 9;
		System.out.println(num + "의" + x + "제곱");
		System.out.println("결과 : " + cal.square(num, x));
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
