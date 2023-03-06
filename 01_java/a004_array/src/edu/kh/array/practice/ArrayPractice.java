package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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

		System.out.print("양의 정수를 입력하세요 : ");
			a = sc.nextInt();
		if(a < 0 ) {
			Practice3();
			return;
		}
		
//		do {
//			System.out.print("양의 정수를 입력하세요 : ");
//			a = sc.nextInt();
//		}while(a <= 0);
		
		int[] arr = new int[a];
		
		for(int i = 0; i<a; i++) {
			arr[i] = i + 1;
			System.out.print(arr[i] + " ");
		}
		
//		for(int i = 0; i<a; i++) {
//			System.out.print(arr[i] + " ");
//		}
	}
	
	public void Practice4() {
		Scanner sc = new Scanner(System.in);
		int input = 0;
		int[] arry = new int[5];
		
		for(int i =0; i<arry.length; i++) {
			System.out.print("입력 " + i + " : ");
			
			input = sc.nextInt();
			arry[i] = input;
			
		}
		System.out.print("검색할 값 :" );
		input = sc.nextInt();
		
		 boolean flag = false;
		
//		int count = 0;
		for(int i =0; i<arry.length;i++) {
			if(arry[i] == input) {
				System.out.println("인덱스 : " + i);
				flag = true;
			}else {
			//	count++;
			}
		}
		
//		if(count == arry.length){
//			
//			System.out.print("일치하는 값이 존재하지 않습니다"); 
//		}
		
		if(flag == false){
		
			System.out.print("일치하는 값이 존재하지 않습니다"); 
		}
		
	}
	
	
	public void Practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String a = sc.next(); 				// 출력값을 받아옴
		
		char[] arry = new char[a.length()]; // 출력받은 길이만큼 char배열 선언
		
		
		for(int i =0; i<arry.length; i++) { //char배열에 출력받은 문자 한개씩 대입
			arry[i] = a.charAt(i); // charAt(int) int번째 있는 String 문자 출력
			//System.out.print(arry[i]);
		}

			System.out.print("문자 : ");
			char b = sc.next().charAt(0); //  문자열 검색 받기
			
			String index =""; // 몇번쨰 인덱스가 같은지 적어주기위해 선언
			int count =0;	  // 같은 갯수가 몇개인지 위해서 선언
			for(int i =0; i<arry.length; i++) {
				if(b == arry[i]) { 	// b에(문자값)에 입력받은게 i번째 배열 값과 같다면
					index += i + " ";	//index넣어줌
					count++;			// 갯수 넣어줌
				}
				
			}
			
			System.out.println(a + "에 "+ b +"가 존재하는 위치(인덱스): "+index); //출력
			System.out.println(b+ "개수 : "+count);	//출력
			
		
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
	public void Practice7() { //배열출력할떄 일정위치에는 * 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String a =sc.next();
		
		char[] arry = new char[14]; // 주민번호의 숫자만큼 배열선언및대입
		for(int i =0; i<arry.length; i++) { // char 배열에 출력받은 문자 한개씩 대입
			if(i <= 7) {
				arry[i] = a.charAt(i);
			}else {
				arry[i] = '*';
			}
			System.out.print(arry[i]);
			
		}
		
		
	}
	public void Practice8() {
		// 3이상인 홀수 입력 받기
		// 배열 중간까지 1부터 1씩증가 오른차순
		// 중간 이후는 1씩감소하여 내림차순
		// 단, 입력한 정수가 홀수가 아니거나 3미만이면 "다시입력하세요" 출력
		// 다시정수받기.
		
		int a = 0;
		Scanner sc = new Scanner(System.in);
		
		
		do {
			
			System.out.print("정수 : ");
			a = sc.nextInt();
			if(a < 3 || a%2 == 0) {
				System.out.println("다시입력하세요");
			}
		
		}while( a < 3 || a%2 == 0) ;
		
		int[] array = new int[a];
		
		int turn ;
		turn = a /2 + 1;
		int count = 1;
		
		for(int i =0; i < array.length ;i++) {
			if(i + 1 < turn) {
				array[i] = count;
				count++;
			}else {
				array[i] = count;
				count--;
			}
				System.out.print(array[i]);
			if (i != array.length - 1) {
				System.out.print(",");
			}
		}
		
	}
	public void Practice9() {
		int[] a = new int[10];
		for(int i =0; i<a.length; i++) {
			a[i]=(int)(Math.random()*10+1);
			
			System.out.print(a[i]+" ");
		} 
	}
	public void Practice10() {
		
		int[] a = new int[10];
		for(int i = 0; i<a.length; i++) {
			a[i] = (int)(Math.random()*10+1);
			
			System.out.print(a[i] + " ");
			}
		
			System.out.println();
			int max = 1;
			int min = 10;
			
			
		for(int i =0; i<a.length ; i++) {
			if(a[i]>max) {
				
				max = a[i];
				
				}	
			if(a[i]<min) {
				
				min = a[i];
							
			}
		}
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}
	public void Practice11() {
		// 10개의 값을 저장할수있는 정수형 배열을 선언 및 할당
		//1~10 사이의 난수 발행해서
		// 중복값 없이 배열에 출력
		
		int[] arr = new int[10];
		
		for(int i =0; i<arr.length; i++) {
			
			arr[i] = (int)(Math.random() * 10 +1); 
			
			for(int j =0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
			
		}
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");
		}
		
		
		
		
		
	}
	public void Practice12() {
		int[] lotto = new int[6];
		
		for(int i =0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1);
			
			for(int j =0; j<i; j++) {
				if(lotto[i] == lotto[j])
					i--;
					break;
					
			}
		}
		Arrays.sort(lotto); // sort ==> 오름차순 정렬
		for(int i =0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " ");
		}
	}
	public void Practice13() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String a = sc.next();
		
		char[] arr = new char[a.length()];
		
		for(int i =0; i<a.length(); i++) {
			
			arr[i] = a.charAt(i);
			
		}
		int count = 0;
		System.out.print("문자열에 있는 문자 : ");
		for(int i =0; i<arr.length; i++) {
			boolean flag = true;
			
			for(int j =0; j<i; j++) {
				if(arr[i] == arr[j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				if(i==0) {
					System.out.print(arr[i]);
				}else {
					System.out.print(", "+arr[i]);
				}
				count++;
			}
		}
		System.out.println();
		System.out.println("문자 개수 : "+count);
		
		
	}	
	public void Practice14() {
		//사용자가 입력한 배열의 길이만큼의 String 배열 선언 및 할당.
		//배열의 인덱스에 넣을값 역시 사용자가 입력해서 넣어줌
		//단, 사용자에게 배열에 값을 더 넣을지 물어보고.
		// 몇개를 더 입력할 건지, 늘린 곳에 어떤 데이터를 넣을건지 받으세요
		// 사용자가 더 입력하지 않겠다고하면 출력.
		
		//Tip : 얕은복사, 깊은복사 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열의 크기를 입력하세요 : ");
		
		int length = sc.nextInt();
		String[] array = new String[length];
		
		for(int i = 0; i < array.length; i++) {
			System.out.println( i + 1 + "번째 문자열 : ");
			array[i] = sc.next();
		}
		
		
		String a ;
		String[] reArray;
		
		do{
			System.out.println("더 값을 입력하시겠습니까?(Y/N) :");
			a = sc.next();

			if( a.equals("Y")  || a.equals("y")) {
				System.out.println("더 입력하고 싶은 개수 : ");
				
				int b = sc.nextInt();
				reArray =  new String[length+b];
				
				//깊은복사
				for(int i = 0; i < array.length; i++) {
					reArray[i] = array[i];
				}
				
				for(int i = array.length ; i <reArray.length ; i++) {
					System.out.println( i+ 1 + "번째 문자열 : ");
					reArray[i] = sc.next();
					System.out.println(" 번째에 들어간 값 " + reArray[i]);
				}
				
				//얕은복사
				array = new String[length+b];
				array = reArray;
				length = length+b;
			}
			
		}while(a.equals("Y") || a.equals("y"));

		
			for(int i = 0; i < array.length ; i++ ) {
				if(i ==0) {
					System.out.print("[");
				}
				
				System.out.print(", " + array[i]);
				
				if( i == array.length-1) {
					System.out.print("]");
				}
			}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


