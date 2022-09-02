package oop.override;

public class Parent {
	void m1() {
		System.out.println("Parent - m1()");
		// m2(); -> 만약 자식쪽에서 super로 이 메소드를 실행했다면 m2가 자식에서 재정의 되었을 경우 자식의 m2가 실행된다
	}
	
	void m2() {
		System.out.println("Parent - m2()");
	}
}
