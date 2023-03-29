package edu.kh.api.dto;

public class Student {

	private int grade;
	private int classRoom;
	private int number;
	private String name;
	
	public Student() {}
	
	// alt + shift + s = o
	public Student(int grade, int classRoom, int number, String name) {
		super();
		this.grade = grade;
		this.classRoom = classRoom;
		this.number = number;
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getClassRoom() {
		return classRoom;
		
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [grade=" + grade + ", classRoom=" + classRoom + ", number=" + number + ", name=" + name + "]";
	}
	
	// Object.equals() 오버라이딩
	// -> 현재 객체와 다른 객체가 동등(필드 값이 같은지) 비교
	// -> 필드를 가지고 있는 자식 클래스
	// 	  알맞은 형태로 재정의(오버라이딩) 필요 
	
	@Override
	public boolean equals(Object obj) {
		
		
		// 같은 객체를 참조할 경우 (얉은 복사)
		if(this == obj) return true;
		
		// null인 경우 비교 자체가 불필요 
		if(obj == null) return false;
		
		
		// 비교를 위해 전달 받은 객체 Student가 맞는가?
		// false인 경우 실행
		if( !(obj instanceof Student) ) return false;
		
		// 필드 비교
		Student other = (Student)obj; // obj 다운 캐스팅
		
//		if(grade != other.grade) // private 같은 클래스
		
		if(this.grade != other.grade) return false;
		if(this.classRoom != other.classRoom) return false;
		if(this.number != other.number) return false;
		
		if( !this.name.equals(other.name) ) return false;
		
		return true; // 모든 필드가 같은 경우
		
	}
	
	// object.hashcode();
	// - 두 객체의 필드 값이 같다면 
	//   hashCode()도 똑같은 정수 값을 반환해야 한다.
	
	// - hash 함수 : 입력 받은 문자/숫자를                a => xyz 변환 계속 3글자(문자)
	//				 특정한 길이의 문자열/숫자로 변환  9999 => 989797969 변환 
	//                 --> 최대한 중복되지 않는 숫자를 만들어냄
	
	// -hashCode() : 객체의 필드 값을 이용해서
	//				 일정한 길이의 숫자를 만드는 함수
	
	//********* 왜 필요???   --> java 실행 시 내부에서 객체 검색하는 속도 증가 + 중복제거
		
	// 어떻게 작성하는가? 
	// 필드 값이 같으면 항상 같은 수가 나올 수 있도록 구현 
	// + equals() 오버라이딩 시 필수적으로 같이 오버라이딩 ******** 
	
	@Override
	public int hashCode() {
		int result = 1; // 0쓰면 곱하면 0이나옴 
		final int PRIME = 31; // 소수 (곱연산 시 속도가 빠름)
		                      // 적당히 큰수 겹치지 않을려고 
		result = result * PRIME + grade;
		
		result = result * PRIME + classRoom;
		
		result = result * PRIME + number;
		
		result = result * PRIME  // String = null 대비하는 코드 작성
				+ ( name == null ? 0 : name.hashCode() ); 
				
		return result;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
