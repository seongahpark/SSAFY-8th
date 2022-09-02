package java5.generic.method;

public class GenericMethod {
	// 파라미터를 Generic으로 받고싶을 때
	public static <P> void m1(P p) { // static과 void 사이에 Generic이 들어가야 함
		System.out.println(p);
	}
	
	// 리턴 타입을 Generic으로 하고 싶다면?
	// -> Generic은 작성되는 시점에서 결정돼어야 좋다
	// 따라서 리턴 타입을 제네릭으로 하는 것은 권장하지 않는다
	// Generic은 코드 작성 시 타입이 결정되는 이점이 있지만,
	// 리턴 경우는 코드 실행시에 결정되는 특성상 약점이 존재한다
	public static <R> R m2(Class<R> type) { // m2(String.class)
		///...
		// 호출 시점에 아무런 정보가 없으면 이 메소드는 리턴 타입을 결정할 수 없다
		return type.cast(m4());
	}
	
	public static String m3() {
		return "Hello";
	}
	
	public static Integer m4() {
		return 20;
	}
	
	public static<R, P> R m5(P p, Class<R> type) {
		System.out.println(p);
		return type.cast(m4());
	}
	
	public static void main(String[] args) {
		m1(10);
		m1("Hello");
		//System.out.println(m2(String.class));
		System.out.println(m2(Integer.class));
	}
}
