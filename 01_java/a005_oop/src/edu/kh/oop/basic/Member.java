package edu.kh.oop.basic;


public Member() {}

public class Member {
	private String name;
	private int age;
	private String address;
	private String hobby;
	public Member(String name, int age, String address, String hobby) {
		this.name = name; // this => 현재 객체를 참조하기 위한 용도 , this() : 다른 생성자를 호출하는 용도
		this.age = age;
		this.address = address;
		this.hobby = hobby;
	}
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
