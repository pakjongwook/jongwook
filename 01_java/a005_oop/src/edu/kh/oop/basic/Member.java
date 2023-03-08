package edu.kh.oop.basic;



public class Member {  
	private String name;   // 같은 클래스내에서 --> getter(외부에서 정보를얻어오는) , setter(외부에서 내부의 정보를설정)
	private int age;
	private String address;
	private String hobby;
	public Member(String name, int age, String address, String hobby) { // 매개변수
		this.name = name; // this => 현재 객체를 참조하기 위한 용도 , this() : 다른 생성자를 호출하는 용도
		this.age = age;
		this.address = address;
		this.hobby = hobby;
	}
	public Member() {} // 기본생성자 생성 : 클래스명과 같아야한다
	
	public String getName() {  
		return name;  // return 
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	
	
	
	
	

}
