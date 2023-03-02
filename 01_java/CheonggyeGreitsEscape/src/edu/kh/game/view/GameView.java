package edu.kh.game.view;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import edu.kh.game.dto.Player;
import edu.kh.game.service.Service;


public class GameView {
	
	private Scanner sc = new Scanner(System.in);
	private Service service = new Service(); 
	
	
	public void displayMenu() {
		int input = 0;

		
		while(true) {
				System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			    System.out.printf( "┃체력: %s 스테미나 : %s 현재 위치:%d ┃\n"
			    System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━┫");
			    System.out.println("┃가나다라마바사아자차카┃-보유 아이템-┃");
			    System.out.println("┃	                   ┃가나다라마바 ┃");
			    System.out.println("┃	                   ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃  1.탕비실(60%)       ┃             ┃");
			    System.out.println("┃  2.화장실(20%)       ┃             ┃");
			    System.out.println("┃  3.사무실(80%)       ┃             ┃");
			    System.out.println("┃  4.휴게실(40%)       ┃             ┃");
			    System.out.println("┃  5.아래층(50%)       ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┃                      ┃             ┃");
			    System.out.println("┖━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━┛");
				
			  
		
			    
			    input = sc.nextInt();
			    sc.nextLine();
			    
			    System.out.println();
			    
			    switch(input) {
			    case 1 : break;
			    case 2 : break;
			    case 3 : break;
			    case 4 : break;
			    case 5 : break;
			    case 6 : break;
			    case 7 : break;
			    case 8 : break;
			    case 9 : break;
			    case 0 : break;
			    default : System.out.println("[잘못 입력하셨습니다.]");
			    
			    }
			    
			System.out.println();
			
		} while(input != 0);
		
		
		
	





























\
	
	
	
	
	
	
	
	

}
