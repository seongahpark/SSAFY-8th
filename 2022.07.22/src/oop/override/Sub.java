package oop.override;

import java.io.FileNotFoundException;

public class Sub extends Super{
	
	@Override
	int m1() {
		System.out.println("Sub - m1()");
		return 1;
	}
	
	@Override
	C m2() {
		System.out.println("Sub - m2()");
		return new D(); // D도 C의 하위클래스이기 때문에 가능
	}
	
	public void m3() {
		System.out.println("Sub - m3()");
	}
	
	@Override
	void m4() throws FileNotFoundException{
		System.out.println("Sub - m4()");
	}
	
	// 아래 두 메소드는 파라미터의 순서가 다르므로 시그니쳐가 다른 별개의 메소드
	void m5(String s, int i) {}
	void m5(int i, String s) {}
	
	@Override
	void m6(int i, String ...args) { // String 파라미터가 여러개 와도 된다
		System.out.println(args[0]); // 첫 번째 String 파라미터가 나옴
		// System.out.println(args[4]); // 범위를 넘어서면 ArrayIndexOutOfBoundsException 에러
		
	}
	
//	void m7(String ...args, int i) { // String ...args는 반드시 가장 마지막 파라미터로 와야 함
//		
//	}
}
