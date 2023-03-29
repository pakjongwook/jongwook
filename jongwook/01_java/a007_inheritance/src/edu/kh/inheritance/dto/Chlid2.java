package edu.kh.inheritance.dto;

public class Chlid2 extends Parent{

	private String house;
	
	public Chlid2() {
		System.out.println("Child2() 기본 생성자");
		
	}
	
	public Chlid2(String house) {
		this.house = house;
		
	}
	public String getHouse() {
		return house;
	}
	
	public void setHouse(String house) {
		this.house = house;
	}
	
// 부모의 getMoney() 의 존재
//	public int getMoney() {
//		return money;
//	}
	

	// 자식이 상속 받은 toString()을 다시 작성(재정의)
	
	
// 오버라이딩 성립 조건
//	1.메소드 이름 동일 , 매개변수의 개수,타입,순서 동일                   부: (default)자 : (default), protected , public
//	2.접근 제어자를 부모와 같거나 넓은 범위로 변경 가능                   부 : public  자 : public  무조건 
//	3.리턴 타입 동일					        2.  부 :어린이는 제외									
//	4.private 메소드 오버라이딩 불가				자 : 11세 이하는 제외 		
//	5.접근제한자 빼고 나머지 메서드 선언부 동일
//	6.예외처리는 부모와 같거나 좁은 범위로 예외처리 변경 가능

	
	
	
	
	
	// @Override :  컴파일러에게 해당 메서드는 재정의 되었다는 것을 
	//              알려주는 컴퓨터용 주석
	//              -> 오버라이딩 형식이 맞는지 검사 진행
	@Override
	public int getMoney() { // 반환형 부모꺼와 같아야함 void -> int  
		System.out.println("자식이 오버라이딩한 getMoney()"); // 부모의 final 입력시 오버라이딩 불가
		return super.getMoney() + 500;
		// 부모의 getMoney() 반환값에 500원 추가
		
	}
	
	
	

}
