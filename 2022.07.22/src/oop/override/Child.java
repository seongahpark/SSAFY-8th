package oop.override;

public class Child extends Parent{
	
	void m2() {
		System.out.println("Child - m2()");
		//super.m2(); // super를 통해서 호출되는 것은 오버라이딩 되지 않는다
		// 즉, 부모의 m2가 호출된다
		super.m1();
	}	
}
