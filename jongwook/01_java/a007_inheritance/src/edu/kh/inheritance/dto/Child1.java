package edu.kh.inheritance.dto;
						// 확장하다 (Parent 코드를 상속 받아 child1 확장)
public class  Child1 extends Parent {

	
	private String car;
	
	// 기본생성자
	public Child1() {
		super(); //super() 
		
		
		System.out.println("child1() 기본 생성자");
		
		
	}
	// 매개 변수 생성자
	public Child1(String car) {
//		super(); // super() 생성자
				 //-> 자식 객체 생성 시 부모 객체를 먼저 생성하게 함
				 // ** 미작성 시 컴파일러가 자동 추가
		
		// 부모로부터 상속 받은 setter 이용해서 부모필드를 초기화
//		setMoney(100_000_000);
//		setLastName("조");
		
		super(200_000_000,"국");
		// 부모의 필드를 초기화 하는 방법이 부모 매개변수 생성자에 존재 코드 중복 제거, 길이 감소
		// -> 이를 호출해서 사용(코드길이 감소, 재사용성의 증가)
		
		
		this.car = car;
		System.out.println("Child1(String) 매개변수 생성자");
		
		
	}
	
	
	// 
	public String getCar() {
		return car;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
	
	public String toString() {
		
//		Parent p1 = new Parent();
//		p1.getMoney();
		
		// 자신의(같은 클래스) 메서드 호출 시 이름만 부르면 된다.!!
		// + 상속 특징(부모 필드 / 메서드를 상속 받아 자식 것 처럼 사용)
//		System.out.println(getCar());
//		System.out.println(getMoney());
//		System.out.println(getLastName());

		
		// 부모의 필드 값을 간접 접근 방법으로 얻어와 하나의 문자열로 만들어 반환 
//		return car + " / " +getMoney() + " / " + getLastName();
		
		
//		return car + " / " + toString();  
		
		return car + "/" + super.toString();  // 해결방법 
						// money + "/" + lastName							
		                                     // stackoverflow : 메모리영역 stack(쌓이다) [메서드가 쌓이는 곳]	
	}										// 선입 후출 구조 	1.main()이 실행 
//	                                                            2.displaymenu() int input = 0; 호출
//	                                                            3. return 젤위에 있는 애(display)가 밖으로  -> main -> return -> 종료
//	                                                            4. 문제점 : stack -> toString -> tostring(메서드)=> 자식께(우선) -> toString .. 넘침 
                                      
                                 
//	                                                              문제점 : StackOverflowError 발생                 
//	                                                              원인 : child1의 toString() 호출 시 
//	                                                              같은 toString()은 계속 반복해서 호출(== 재귀호출)
//																해결방법: 부모의 toString() 호출을 명시 -> super.참조변수 이용
	

}
