package basic.staticc;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main"); // 메인이 먼저 출력된다
		System.out.println(MyClass.COUNT); // 이 녀석이 필요하니까 메모리에 로드 시킨다
		MyClass mc = new MyClass();
		System.out.println(mc.num);
		System.out.println(mc.COUNT); // 가능은 하나 좋은 방법은 아니다. 워닝이 뜸
	
		MyClass.m2();
		mc.m1();
		mc.m2(); // 가능은 하나 좋은 방법은 아니다
		
		System.out.println(MyClass.COUNT);
		// System.out.println(MyClass.num); -> static이 아니기 때문에 객체를 만들어야 한다
	}

}
