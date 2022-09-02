package oop.override;

import java.io.IOException;

public class Super {
	
	// #1-1 return type : primitive
	int m1() {
		System.out.println("Super - m1()");
		return 1;
	}
	
	// #1-2 return type : reference
	// B 또는 B의 하위 클래스가 가능하다
	B m2() {
		System.out.println("Super - m2()");
		return new B();
	}
	
	// #2 access modifier
	// 부모 class의 access modifier 보다 같거나 더 개방적이어야 한다
	protected void m3() {
		System.out.println("Super - m3()");
	}
	
	// #3 Exception
	// 부모 class의 throws 예외에 대해 자식 class는 예외를 throws 하지 않아도 되고,
	// 할 경우에는 동일하거나 더 구체적인 예외에 대해서 가능하다
	void m4() throws IOException{
		System.out.println("Super - m4()");
	}
	
	void m6(int i, String ...args) {
		
	}
	
	
}
