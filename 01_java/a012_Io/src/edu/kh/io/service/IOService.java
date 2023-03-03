package edu.kh.io.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOService {

	// 스트림(Stream) : 데이터가 이동하는 통로
	//					(기본적으로 한 쪽 방향으로만 흐름)
	
	// 바이트 기반 스트림
	// - 1byte 단위로 데이터를 입/출력 하는 스트림
	// -> 1byte 문자로 이루어진 text (영어,특수문자)
	//    이미지 , 영상, 파일 등 문자가 아닌 데이터/파일
	
	// 문자 기반 스트림
	// - 문자 단위로 데이터를 입/출력하는 스트림
	// -> 문자로 이루어진 text , 채팅, 코드
	
	private String content = "Hello~~~~~~~~~~ World~~~~~~~~~~\n"
							+ "0987654321\n"
							+ "희망이 또 오겠죠.\n"
							+ "!@#$%^&*<>?:";    // 기본적으로는 덮어쓰기을 함.
			
	
	public void byteOutPut() { // 한글이 깨지고 나옴
		// 바이트 기반 출력
		
		FileOutputStream fos = null; // 아무것도 참조 안한다.
		// 스트림 참조 변수 선언을 try 전에 한 이유
		// -> finally에서도 해당 참조 변수를 사용할 수 있게하려고
		
		
		try {
		fos = new FileOutputStream("byte/byteTest.txt"); //  이 경로에 설정, byte 폴더 가없다? => FileNotException try catch 구문을 만든다.
		// 상대경로 기준 == 프로젝트 폴더 내부
		
		// c:\tools\eclipse\ [절대 경로 : 절대적인 기준점을 기준으로 경로 작성]
		// byte/byteTest.txt [상대 경로 : 현재위치를 기준으로 경로 작성]
		
//		fos = new FileOutputStream("경로");
		// -> 프로그램 -> 지정된 경로로 파일을 내보냄(출력)
		// 만약, 경로 제일 마지막에 작성한 파일이 존재하지 않는다면
		// 출력 구문 수행 시 자동으로 생성된다.
		
		// FileNotFoundException 발생 가능성이 있음
		
		// content에 작성된 문자를 하나씩 쪼개기
		for(int i=0; i<content.length(); i++) {
			char ch = content.charAt(i); // 문자열에서 하나씩 쪼개는 것. 
			
			 fos.write(ch); // 프로그램이 txt에 쓴다 (==출력)
		}
		
		System.out.println("출력 완료");
		
		} catch(FileNotFoundException e) { // 파일이 없는 경우
			e.printStackTrace();
			
			
		} catch (IOException e) { // 문제가 있는 경우
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally { // 예외가 발생 하던 말던 무조건 수행 MY Way
			
			try{
				if(fos != null) fos.close(); // fos의 참조하는 객체가 있다? X == > null
				// NullPointerException 방지 
				
				
				// close() : 스트림 내부 내용을 모두 밀어낸 후 닫음(메모리 반환)
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void charOutPut() { // 문자 기반출력  폴더 만들시 a012 IO 에서 folder로 char 생성
		
		FileWriter fw = null;  // 한글이 안깨지고 나옴
		
		try {
			fw = new FileWriter("char/charTest.txt", true);  
//			fw = new FileWriter("경로",이어쓰기 옵션); // 한번 더 쓰여진다./ Ex) 파일을 내보낼때 파일 끊기는 경우에만
													   // byte도 똑같이 사용가능
			
			fw.write(content);
			// 문자열 content를 지정된 경로로 출력
			
			System.out.println("문자 기반 스트림 출력 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		
		} finally {
			
			try {
			if(fw != null)	fw.close();
							// 스트림에 남은 내용을 모두 밀어내고 닫기
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	public void byteInput() {
		// 바이트 기반 입력 스트림 
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("char/charTest.txt");
			
//			fis = new FileInputStream("경로");
//			FileNotFoundException 발생 가능성이 있음
			
			int value = 0; // 파일에서 읽어온 바이트 하나를 저장할 변수 1바이트 1바이트 ,한글 월 두번 쪼개서 ... 
			
			while(true) { // 파일의 내용이 얼마나 있는지 모르기 때문에 
						 //  일단 무한히 반복
				
				value = fis.read(); // Add catch 구문 선택
						// 다음 1byte를 읽어와 int형으로 반환 
						// 또는 더 이상 읽어올 데이터가 없으면 -1 반환 
				
				if(value == -1) break;
				// 파일을 다 읽어온 경우 반복을 멈춤 
				
				System.out.print( (char)value );
				// int -> char 형변환해서 문자 형태로 출력 
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			// 스트림 닫기(메모리 반환)
			
			try {
			if(fis != null)	fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void charInput() {
		// 문자 기반 입력 스트림
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("char/charTest.txt");
			
//			fr = new FileReader("경로");
			
			int value = 0; // 파일에서 [문자]를 하나씩 읽어와 저장
			
			while(true) {
				
				value = fr.read(); // 문자를 읽어와 int 형으로 반환 
								   // 만약, 읽어올 문자가 없으면 -1 반환
				
				if(value == -1) break;
				
				System.out.print((char)value);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		} finally {
			
			try {
			if(fr != null)	fr.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
}


