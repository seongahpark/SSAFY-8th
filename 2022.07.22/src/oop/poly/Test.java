package oop.poly;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		C c = new C();
		D d = new D();
		
//		m(a); // A - a
//		m(b); // // A - a
//		m(c); // C - c
//		m(d); // C - c
		
//		C bd = new D(); // 파라미터 전달 시 타입은 왼쪽을 기준으로 
//		m(bd);
		
		// instanceof : 실제로 만들어진 객체의 타입 (오른쪽). 하지만 이것도 다형성이 존재
		m2(a);
		m2(b);
		m2(c);
		m2(d);
		

	}
	
//	static void m(A a) {
//		System.out.println("A a!!");
//		a.a();
//	}
//	
//	static void m(C c) {
//		System.out.println("C c!!!");
//		c.a();
//	}
	
	// a, b, c, d를 구분하고 싶다
	static void m2(A a) {
		// 모두 A 객체라고 뜬다. 왜? 다형성. 상속받기 때문에 즉, A에서 다 걸린다.
		// 즉 if문의 순서가 잘못됐음
//		if(a instanceof A) {
//			System.out.println("A 객체");
//		}else if(a instanceof B) {
//			System.out.println("B 객체");
//		}else if(a instanceof C) {
//			System.out.println("C 객체");
//		}else if(a instanceof D) {
//			System.out.println("D 객체");
//		}
		
		if(a instanceof D) {
			System.out.println("D 객체");
		}else if(a instanceof C) {
			// 호출할 수 있는 것은 A만 호출이 가능하다
			a.a();
			// C 타입을 호출하고싶다면? 형변환 해주어야 됨
			C temp = (C) a;
			temp.b();
			System.out.println("C 객체");
		}else if(a instanceof B) {
			System.out.println("B 객체");
		}else if(a instanceof A) {
			System.out.println("A 객체");
		}
	}
	

}
