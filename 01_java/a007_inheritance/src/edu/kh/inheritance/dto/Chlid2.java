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
	
	public String toString() {
		return house;
	}
	
	
	

}
