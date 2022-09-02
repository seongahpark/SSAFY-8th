package lambda;

public class Test {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		
		// #1. 인터페이스를 구현한 클래스를 사용 - MyFuncIFImpl
		{
			MyFuncIF func = new MyFuncIFImpl();
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
		
		// #2. 인터페이스를 구현한 익명 클래스를 사용 - MyFuncIFImpl 사용 X
		// 첫 번째 코드의 간소화 (생략) : MyFuncIFImpl
		// 좀 더 다이나믹한 코딩이 가능하다
		{
			MyFuncIF func = new MyFuncIF() {

				@Override
				public int proc1(int n1, int n2) {
					return n1 + n2;
				}
				
			};
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
		
		// Functional Interface가 아닌 경우 여러 개의 추상 메소드를 구현 할 수 있다
		{
			MyFuncIF2 func = new MyFuncIF2() {

				@Override
				public int proc1(int n1, int n2) {
					return n1 + n2;
				}

				@Override
				public int proc2(int n1, int n2) {
					return n1 - n2;
				}
				
			};
			int result = func.proc2(n1, n2); // proc1, proc2 모두 호출 가능 -> 선택적이다 -> 결정적이지 않다
			System.out.println(result);
		}
		
		// #3 Lambda first
		// Functional Interface를 구현한 객체는 오직 한 가지만 호출할 수 있다 = 결정적이다
		// Lambda는 전제조건이 Functional Interface를 구현한 객체로만 사용될 수 있다
		{
			MyFuncIF func = (i, j) -> i + j;
			// MyFuncIF func = (i, j) -> { return i + j; };
			int result = func.proc1(n1, n2);
			System.out.println(result);
		}
		
		// #4 lambda second
		{
//			MyFuncIF func = (i, j) -> i + j;
//			MyFunc.m(func);
			MyFunc.m((i, j) -> i + j);
			MyFunc.m((i, j) -> i - j);
		}

	}
	
	static class MyFunc{
		static void m(MyFuncIF func) { // m() 메소드는 파라미터로 Functional Interface를 구현한 객체를 받는다
			// ...
			System.out.println(func.proc1(5, 3));
		}
	}

}
