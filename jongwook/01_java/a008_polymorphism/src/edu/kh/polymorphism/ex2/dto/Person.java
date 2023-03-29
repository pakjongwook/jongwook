package edu.kh.polymorphism.ex2.dto;

public class Person extends Animal {
			//  추상클래스 상속 시
	        // abstract 메서드도 상속이 되는데
			// 미완성 상태 이므로 구현 (오보라이딩) 하라고 에러 발생
	
	
	private String name;
	private int age;
	
	// 기본생성자 
	public Person() {}
	
	// 매개변수
	public Person(String type, String eatType, String name, int age) {
		super(type, eatType); // 부모의 매개 변수 생성자 호출
		
		this.name = name;
		this.age = age;
	}
	
	// alt + [shift] +s = r

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		// super : 부모 참조 변수
		return super.toString() + " / " + name + " / " + age;
	}		
	// alt + shift + s -> s
	
	//상속 받은 추상메서드 강제구현(오버라이딩)
	@Override   // 검사 역할
	public void breath() {
		System.out.println("코와 입으로 숨을 쉰다.");
		
	}
	
	
	

}
