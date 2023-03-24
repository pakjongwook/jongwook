package edu.kh.jdbc.main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.common.Session;
import edu.kh.jdbc.main.model.service.MainService;

public class MainView {
	
	// view : 입력, 출력
	
	
	private Scanner sc = new Scanner(System.in);
	private MainService service = new MainService();
	
	
	
	
	/**
	 * 메인 메뉴 출력
	 */
	public void mainMenu() {
		
		int input = 0; // scanner 입력받을 때 사용한 변수
		
		do {
			
			try {
				if(Session.loginMember == null) {
					
					// 로그인 X
					System.out.println("\n====== 회원제 게시판 프로그램 ====\n");
					System.out.println("1. 로그인");
					System.out.println("2. 회원 가입");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n 메뉴 선택 : ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행 문자 제거
					
					switch(input) {
					case 1 : login(); break;
					case 2 : break;
					case 0 : System.out.println("\n=== 프로그램 종료 ===\n"); break;
					default : System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
					}
					
					
				}else {
					// 로그인 O
					System.out.println("\n===== 로그인 메뉴 ====\n");
					System.out.println("1. 회원 기능");
					System.out.println("2. 계시판 기능");
					System.out.println("3. 로그아웃");
					System.out.println("0. 프로그램 종료");
					
					System.out.print("\n 메뉴 선택 : ");
					input = sc.nextInt();
					sc.nextLine(); // 입력 버퍼 개행 문자 제거
					
					switch(input) {
					case 1 : break;
					case 2 : break;
					case 3 : break;
					case 0 : System.out.println("\n=== 프로그램 종료 ===\n"); break;
					default : System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
					
					}
					
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n*** 입력 형식이 올바르지 않습니다***\n");
				sc.nextLine(); // 입력버퍼에 잘못된 물자열 제거
				input = -1; // while문 종료 방지
				
			}
			
			
		}while(input != 0);
		
	}
	
	
	/**
	 * 로그인
	 */
	private void login() {
		System.out.println("\n[로그인]\n");
		
		System.out.print("아이디 : ");
		String memberId = sc.next();
		
		System.out.print("비밀번호 : ");
		String memberPw = sc.next();
		
		try {
			// 로그인 서비스 호출 후 결과 반환 받기 
			// ==> 반환 받은 결과는 Session.loginMember 에 저장
			Session.loginMember = service.login(memberId,memberPw);
			
			
		}catch (Exception e) {
			System.out.println("\n**** 로그인 중 예외 발생 ****\n");
			e.printStackTrace();
			
		}
		
		
	}
	
	
	
	

}
