package edu.kh.polymorphism.ex2.dto;

// 각자 계산기 구현하기
public class PJWCalculator implements Calculator,KH {

	@Override
	public int plus(int a, int b) {
	    int result = a + b;
	    return result;
	}

	@Override
	public int minus(int a, int b) {
		int result = a-b;
		return result;
	}

	@Override
	public int multiple(int a, int b) {
		int result = a * b;
		return result;
	}

	@Override
	public int divide(int a, int b) {
		int result = a / b;
		return result;
	}

	@Override
	public double divide2(int a, int b) {
		double result = (double)a / b; 
		return result;
	}

	@Override
	public double areaofCircle(double r) {
//		return Calculator.PI * r *r; // 정확한 표기법
		return PI * r * r; // (상속 받은 PI을  자식이 자기 것 처럼 사용) 
	}

	@Override
	public int square(int a, int x) {
		int result = 1;
		for(int i =1; i<=x; i++) {
			result *= a;
		}
		return result;
	}

	@Override
	public void lesson() {
		
		
	}

	
}
