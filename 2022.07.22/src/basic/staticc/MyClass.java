package basic.staticc;

public class MyClass {
	
	static int COUNT = 10;
	int num = 20;
	
	// static initializer
	static {
		System.out.println("static initializer 1!!");
		COUNT++;
	}
	
	void m1() {
		System.out.println("non static m1()");
		COUNT++;
		num++; // 가능
	}
	
	// static initializer
	static {
		System.out.println("static initializer 2!!");
		COUNT++;
	}	
	
	static void m2() {
		System.out.println("static m2()");
		COUNT++;
		// num++; // 객체가 존재해야만 사용할 수 있는 변수에 대한 접근은 되지 않는다
	}
}
