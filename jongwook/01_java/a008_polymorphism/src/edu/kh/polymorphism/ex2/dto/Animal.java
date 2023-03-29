package edu.kh.polymorphism.ex2.dto;

// 추상클래스 (abstract class)
// - 추상 메서드가 포함된 클래스
// 단, 추상 메서드가 없어도 추상 클래스가 될 수 있다.! // 추상메서드도 업고 클래스 없다면 : 어떤 동물인지 불명확 false
public abstract class Animal/* extends Object */{ // 모든 클래스 의 최상위 object 
	// 추상화 , 캡슐화               // -> 미작성 시 컴파일러가 자동 추가
	
	// 필드
	private String type; // 종(양서류, 포유류, 파충류...)
	private String eatType; // 식성
	
	//생성자
	public Animal() {
		super(); // 부모 생성자 호출
				// 미작성 시 컴파일러가 자동 추가
		
	} // 기본생성자  
	
	public Animal(String type, String eatType) { // 매개 변수 생성자 : 필드 초기화 용도
		
		this.type = type;
		this.eatType = eatType;
	}
	
	//메서드
	// getter / setter
	
//	public 반환형 get필드명() {
//		return 필드명;
//	}
	
	public String getType() {
		return type;
	}

	
//	public void set필드명(매개변수) {
//		this.필드 = 매개변수;
//	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	public String geteatType() {
		return eatType;
	}
	
	
	public void seteatType(String eatType) {
		this.eatType = eatType;
	}
	
	// String object.toString()
	// - 객체가 가지고 있는 필드를 하나의 문자열로 반환하는 용도에 메서드
	//  (자식이 오버라이딩해서 사용하길 권장)
	// 오버라이딩 x -> 패키지명 + 클래스명@해시코드 문자열 반환 
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	
	
	//추상 메서드(미완성 메서드)
	// 상속 받은 자식 클래스에 반드시 오버라이딩 해야한다!
	// -->  추상 메서드를 포함한 클래스는 반드시 abstract class(추상 클래스) 여야만 한다.
	public abstract void breath(); // 3번줄에 abstract 추가해야지 오류발생x
	

	

}
