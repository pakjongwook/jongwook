package edu.kh.jdbc.member.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.member.model.service.MemberService;

// alt + shift + J antor (코드을 쓴 사람)
// 날짜도 씀 (최근 업데이트)

/** 회원 전용 화면
 * @author 박종욱(meso8587@naver.com)
 *
 */
public class MemberView {

	private Scanner sc = new Scanner(System.in);
	
	private MemberService service = new MemberService();
	
	
	
	
	/**
	 * 회원 전용 메뉴 
	 */
	public void memberMenu() {
		int input = 0;
		
		do {
			try {
				System.out.println("\n==== 회원 기능 ====\n");
				System.out.println("1. 내 정보 조회");
				System.out.println("2. 회원 목록 조회(아이디, 이름, 성별)");
				System.out.println("3. 내 정보 수정(이름, 성별)");
				System.out.println("4. 비밀번호 변경(현재 비밀번호, 새 비밀빈호, 새 비밀번호 확인)");
				System.out.println("5. 회원 탈퇴(보안코드, 비밀번호, UPDATE)");
				
				System.out.println("9. 메인메뉴로 돌아가기");
				System.out.println("0. 프로그램 종료");
				
				System.out.println("\n메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				
				switch(input) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 9 : 
					System.out.println("\n==== 메인 메뉴로 돌아갑니다.===\n");
					break;
					
				case 0 :
					System.out.println("\n=== 프로그램 종료 ===\n");
					
					// JVM 강제 종료 구문
					// 매개변수는 기본 0, 다른 숫자는 오류를 의미
					System.exit(0); // 0 : 그냥 꺼짐 1: 메모리 부족 꺼짐 , 10 : 무슨 문제 일어났다고 약속한 상태에서 꺼짐
					// Terminates the currently running Java Virtual Machine.
					
				default : System.out.println("\n*** 메뉴 번호만 입력 해주세요 ***\n");
				
				}
				
				
			}catch (InputMismatchException e) {
				System.out.println("\n*** 입력형식이 올바르지 않습니다 ***\n");
				sc.nextLine(); // 입력버퍼에 잘못된 문자열 제거
				input = -1; // while문 종료 방지
				
			}
			
		
		}while(input != 9); // 9가 입력되면 메서드 끝나고 돌아갈수 있게
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
