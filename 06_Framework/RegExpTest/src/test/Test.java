package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("게시글 입력 : ");
		
		String boardText = sc.nextLine();
		
		
		// 이미지 태그를 추출하기 위한 정규식.
		Pattern pattern  =  Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		
		Matcher matcher = pattern.matcher(boardText);
		
		
		while(matcher.find()) {
			System.out.println( matcher.group(1) );
		} 
	}
}
