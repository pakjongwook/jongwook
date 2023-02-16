package edu.kh.oop.method.view;

import java.util.Scanner;

// 입/출력용 객체를 만들기 위한 클래스
public class UserView {

	private Scanner sc = new Scanner(System.in);
	
	// UserService 객체 생성
	private UserService service = new UserService();
	
	// 가입한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언
	private User signUpUser = null; 
	
	// 로그인한 사용자 정보를 가지고 있는 객체를 참조할 변수 선언 
	//  프로그램 시작 시 Static 영역에 생성
	// -> 어디서든지 클래스명.필드명 으로 접근 가능
	
	
	public static User loginUser = null;
	
	// 메뉴를 출력하는 메서드
	public void displayMenu() {
		
		int input = 0; // 입력한 메뉴 번호를 저장할 변수
		
		do {
			
			System.out.println("==== 사용자 기능 메뉴=====");
		
			System.out.println("0. 프로그램 종료");
			System.out.println("=====================");
			
			System.out.println("메뉴 선택 >>");
			input = sc.nextInt();
			
			System.out.println();
			
			switch(input) {
			case 1 : break;
			case 2 : break;
			case 3 : break;
			default : 
			
			}
			
			
		}while(input != 0);
		
		
	}
	
	
	
	
	

}
