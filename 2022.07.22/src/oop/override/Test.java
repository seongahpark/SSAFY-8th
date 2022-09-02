package oop.override;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Sub s = new Sub();
//		s.m6(3, "Hello", "World");
//		s.m6(3, "Hello", "World", "Ssafy");
		
//		Super s = new Super();
//		s.m1();
//		
//		Sub sub = new Sub();
//		sub.m1();
//		
//		Super ss = new Sub();
//		ss.m1(); // 자식이 호출된다
		
		{
			A a = new B();
			// a.a();
			// a.a(3); -> 오류
			// 호출을 할 수 있다/없다는 A를 보고 판단해야 한다
			// 일단 호출이 가능하다면 누가 호출이 되는가? -> B가 호출된다
		}
		
		{
//			B b = new C();
//			b.a();
//			b.a(5);
		}
		
		{
//			A a = new C();
//			a.a();
			//a.c(); -> 호출 여부는 A를 보고 판단! 즉 안됨
		}
		
		{
			B b = new D();
//			b.a(); // 호출여부는 A가 있으니까 가능, 누가 호출이 되는지는 D부터 살펴보아야 됨. 즉 D에는 없으니 C에서 호출
//			b.a(1);
//			b.b();
		}
		
		{
			B b = new D();
//			b.c(); // 에러
//			b.a(); // C 호출
//			b.a(1); // D 호출
//			b.d(); // 에러
		}
		
		{
			Parent p = new Child();
			p.m2();
		}
	}

}
