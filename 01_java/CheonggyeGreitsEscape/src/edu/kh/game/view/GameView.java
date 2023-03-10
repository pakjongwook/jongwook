package edu.kh.game.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.kh.game.service.Service;
import edu.kh.game.dto.*;

public class GameView {

   private Scanner sc = new Scanner(System.in);
   private Service gameService = new Service();
   private Building floor = new Building();
   public void displayGame() {
      int input = 0;
      String straight = "┃";
    
      
      

      while (viewFloor()<10) {
         
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(); 
            System.out.println();
            System.out.println();
            System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
            System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
            System.out.println("                                     ");
            System.out.printf("           "+floor.getRoom(viewFloor()-1)                       );
            System.out.println("                                     ");
            System.out.printf("    0. 아래 층(%dF)                      \n", viewFloor() - 1);
            System.out.println("                                     ");
            System.out.println("    9. 아이템 사용                       ");
            System.out.println("                                     ");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("메뉴 선택 >> ");
            input = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 개행문자 제거
            System.out.println();

            switch (input) {
            case 0:

               gameService.moveFloor(true);
               break;
            case 9:
//            itemUse();
               break;
            default:
               System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
            
         }
      }
   }

   public void meetingRoom1() {
      int input = 0;
      String straight = "┃";
      if ((int) (Math.random() * 100) <= 60) {
         System.out.printf("가%38s\n", straight);
         System.out.printf("ss%38s\n", straight);
         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
         System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
         System.out.println("                                     ");
         System.out.println("             좀비가 나타났습니다.                ");
         System.out.println("                                     ");
         System.out.println("                                     ");
         System.out.println("    1.공격하기                       ");
         System.out.println("    2.도망가기                                  ");
         System.out.println("                                     ");
         System.out.println("    9. 아이템 사용                       ");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.print("메뉴 선택 >> ");
         input = sc.nextInt();
         sc.nextLine(); // 입력 버퍼 개행문자 제거
         System.out.println();

         switch (input) {
         case 1:
            Attackview();
            break;
         case 2:
           
            displayGame();
            break;
         case 9:
//      itemUse();
            break;
         default:
            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
         }
      } else {
         System.out.printf("가%38s\n", straight);
         System.out.printf("ss%38s\n", straight);
         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
         System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
         System.out.println("                                     ");
         System.out.println("            아무것도 없었다                ");
         System.out.println("                                     ");
         System.out.println("                                     ");
         System.out.println("                           ");
         System.out.println("    1.돌아가기                                  ");
         System.out.println("                                     ");
         System.out.println("    9. 아이템 사용                       ");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.print("메뉴 선택 >> ");
         input = sc.nextInt();
         sc.nextLine(); // 입력 버퍼 개행문자 제거
         System.out.println();

         switch (input) {
         case 1:
            displayGame();
         case 9:
//      itemUse();
            break;
         default:
            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
         }
      }
   }

   public void Attackview() {
      int input = 0;
      String straight = "┃";
      if ((int) (Math.random() * 100) <= 50) {
         System.out.printf("가%38s\n", straight);
         System.out.printf("ss%38s\n", straight);
         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
         System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
         System.out.println("                                     ");
         System.out.println("            공격에 성공하였습니다.                ");
         System.out.println("             좀비가 쓰러집니다.                        ");
         System.out.println("                                     ");
         System.out.println("                           ");
         System.out.println("    1.돌아가기                                  ");
         System.out.println("                                     ");
         System.out.println("    9. 아이템 사용                       ");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.print("메뉴 선택 >> ");
         input = sc.nextInt();
         sc.nextLine(); // 입력 버퍼 개행문자 제거
         System.out.println();

         switch (input) {
         case 1:
            displayGame();
            break;
         case 9:
//      itemUse();
            break;
         default:
            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
         }
      } else {
         System.out.printf("가%38s\n", straight);
         System.out.printf("ss%38s\n", straight);
         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
         System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
         System.out.println("                                     ");
         System.out.println("         좀비에게 피해를 입습니다.                    ");
         System.out.println("          좀비를 해치웠습니다.                ");
         System.out.println("                                     ");
         System.out.println("                           ");
         System.out.println("    1.돌아가기                                  ");
         System.out.println("                                     ");
         System.out.println("    9. 아이템 사용                       ");
         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
         System.out.print("메뉴 선택 >> ");
         input = sc.nextInt();
         sc.nextLine(); // 입력 버퍼 개행문자 제거
         System.out.println();

         switch (input) {
         case 1:
           displayGame();
            break;
         case 9:
//      itemUse();
            break;
         default:
            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
         }
      }
   
   }

   public void failedAway() {
      int input = 0;
      String straight = "┃";
      System.out.printf("가%38s\n", straight);
      System.out.printf("ss%38s\n", straight);
      System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
      System.out.printf("┃HP : %d/5┃STN : %d/5   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
      System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
      System.out.println("                                     ");
      System.out.println("          도망에 실패했습니다.                ");
      System.out.println("          좀비에게 피해를 입습니다.                        ");
      System.out.println("                                     ");
      System.out.println("    1.공격하기                                  ");
      System.out.println("    2.도망가기                                  ");
      System.out.println("                                     ");
      System.out.println("    9. 아이템 사용                       ");
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.print("메뉴 선택 >> ");
      input = sc.nextInt();
      sc.nextLine(); // 입력 버퍼 개행문자 제거
      System.out.println();

      switch (input) {
      case 1:
         Attackview();
         break;
      case 2:
         displayGame();
         break;
      case 9:
//      itemUse();
         break;
      default:
         System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");

      }
   }
   
   public void secondClassRoom1() {  // 2층 구현
	      int input = 0;
	      String straight = "┃";
	     
	         System.out.println();
	         System.out.println();
	         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
	         System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
	         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
	         System.out.println("                                     ");
	         System.out.println("            강의실에 입장했습니다                ");
	         System.out.println("            강사님의 코드 지옥이 쏟아졌습니다.       ");
	         System.out.println("                                     ");
	         System.out.println("    1.강사님과 코드공부(잠자기 포함)                         ");
	         System.out.println("    2.나가기                                  ");
	         System.out.println("                                     ");
	         System.out.println("    9. 아이템 사용                       ");
	         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	         System.out.print("메뉴 선택 >> ");
	         input = sc.nextInt();
	         sc.nextLine(); // 입력 버퍼 개행문자 제거
	         System.out.println();

	         switch (input) {
	         case 1:
	        	 secondClassRoom2();
	            break;
	         case 2:
	            displayGame();
	            break;
	         case 9:
//	         itemUse();
	            break;
	         default:
	            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
	         }
	      
	   }
	   public void secondClassRoom2() {
	      int input = 0;
	      String straight = "┃";
	    //  if ((int) (Math.random() * 100) <= 60) {}  조건문이 틀릴 경우 else 구문 작성 필요  
	     While(input != case 1 || case 2 || case 9) 
	         System.out.println();
	         System.out.println();
	         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
	         System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
	         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
	         System.out.println("                                     ");
	         System.out.println("     백동현강사님이 좀비로 변하셨습니다.                 ");
	         System.out.println("                                    ");
	         System.out.println("                                     ");
	         System.out.println("    1.코드 작성하는 척하면서 공격하기                       ");
	         System.out.println("    2.도망가기                                  ");
	         System.out.println("                                     ");
	         System.out.println("    9. 아이템 사용                       ");
	         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	         System.out.print("메뉴 선택 >> ");
	         input = sc.nextInt();
	         sc.nextLine(); // 입력 버퍼 개행문자 제거
	         System.out.println();

	         switch (input) {
	         case 1:
	            Attackview();
	            break;
	         case 2:
	            displayGame();

	            break;
	         case 9:
//	         itemUse();
	            break;
	         default:
	            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
	         }
	      
	   }
	   public void secondClassRoom() {
		      int input = 0;
		      String straight = "┃";
		      
		      if ((int) (Math.random() * 100) <= 60) {
		         System.out.println();
		         System.out.println();
		         System.out.println("┏━━━━━━━━┳━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━┓");
		         System.out.printf("┃HP : %d/5┃STN : %d/3   ┃현재 위치 : %d F ┃\n", viewHp(), viewStamina(), viewFloor());
		         System.out.println("┃━━━━━━━━┻━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━┫");
		         System.out.println("                                     ");
		         System.out.println("     백동현강사님이 좀비를 물리쳤습니다.                 ");
		         System.out.println("                                    ");
		         System.out.println("                                     ");
		         System.out.println("    1.돌아가기            ");
		         System.out.println("                                    ");
		         System.out.println("                                     ");
		         System.out.println("    9. 아이템 사용                       ");
		         System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		         System.out.print("메뉴 선택 >> ");
		         input = sc.nextInt();
		         sc.nextLine(); // 입력 버퍼 개행문자 제거
		         System.out.println();

		         switch (input) {
		         case 1:
		            displayGame();  
		            break;
		         case 9:
//		         itemUse();
		            break;
		         default:
		            System.out.println("[메뉴에 존재하는 번호만 입력 해주세요]");
		         }
		      }
		   }
	   
	  
   

   private int viewHp() {
      return gameService.viewHp();
   }

   private int viewStamina() {
      return gameService.viewStamina();
   }

   private int viewFloor() {
      return gameService.viewFloor();
   }

   public void moveFloor(boolean move) { // 층 이동
      gameService.moveFloor(move);
   }

   private int hitPlayer(int damage) {

      return gameService.hitPlayer(damage);
   }
   

   public void useItem(int index) { // 사용하면 삭제"null"로 변경
      gameService.useItem(index - 1);
   }

   
   
   
   

}