package java5.generic.wildcard;

public class WildCard {
	public static void main(String[] args) {
		// 변수 선언과 할당
		// wildCard ? 를 통해
		// String, Object 등 모든 GenericType 객체가 가능하다
		GenericType<?> gt1 = new GenericType<>();
		GenericType<?> gt2 = new GenericType<String>();
		
		GenericType<? extends B> gt3 = new GenericType<C>(); // A 로는 받지 못한다
		// GenericType<? extends B> gt4 = new GenericType<A>(); // ERROR
		
		GenericType<? super B> gt5 = new GenericType<A>();
		// GenericType<? super B> gt6 = new GenericType<C>(); // ERROR
		
		// 메소드 호출
		m1(new GenericType<Object>());
		m1(new GenericType<C>());
		// M1은 뭐든지 받을 수 있는 형태
		
		m2(new GenericType<C>());
		// m2(new GenericType<A>()); // ERROR		
		
		m3(new GenericType<A>());
		// m3(new GenericType<C>()); // ERROR
		
	}
	
	static class GenericType<T>{
		T t;
	}
	
	static class A {}
	static class B extends A {}
	static class C extends B {}
	
	static void m1(GenericType<?> p) {}
	static void m2(GenericType<? extends B> p) {}
	static void m3(GenericType<? super B> p) {}
}
