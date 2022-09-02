package basic.finall;

public class MyClass { // extends FinalClass -> 오류
	
	// #2 final method : override 허락 X
	void m1() { }
	final void m2() {}
	
	void m3() {
		// #3 final local variable : 상수화. 더이상 값을 바꾸지 못한다
		int n1 = 10;
		final int n2 = 20;
		n1 = 20;
		// n2 = 10; 
		
		String str = "Hello";
		str = "World";
		
		final String str2 = "SSAFY";
		// str2 = "부울경";
		
		// #4 array
		final int[] intArray = {1, 3, 5};
		// intArray = {2, 4, 6}; -> 이거는 final 오류가 아님. 자체가 array Constant이기 때문이라 발생하는 오류
		
		final int[] intArray2 = new int[3];
		// intArray2 = new int[4];
		intArray2[1] = 10;
		intArray2[1] = 20;
		
	}
}

final class FinalClass{ // 더이상 상속을 허락하지 않는다
	
}

class SubClass extends MyClass{
	void m1() {}
	// void m2() {}
}
