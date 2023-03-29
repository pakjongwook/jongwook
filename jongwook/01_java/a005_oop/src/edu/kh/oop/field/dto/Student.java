package edu.kh.oop.field.dto;

// DTO (Data Transfer Object) : 데이터를 옮기는 객체 
public class Student {
	
	// 필드 : 객체의 속성
	
	// 필드 종류 1 : 인스턴스 변수
	// 인스턴스가 생성될 때 마다 해당 인스턴스에 포함된 변수
	public String name;
	public int grade;
	
	
	// 필드 종류 2 : 클래스 변수 (static이 붙은 변수)
	public static String schoolName = "KH 초등학교";
	
	public void study() {
		System.out.println("아주 아주 열심히 하는 놈.");
	}
		
}
