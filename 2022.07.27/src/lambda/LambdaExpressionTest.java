package lambda;

public class LambdaExpressionTest {

	public static void main(String[] args) {
//		UseFuncIF.exec1(() -> {
//			System.out.println("Hello");
//		} ); // 파라미터로 FuncIF1을 구현한 객체가 오면 된다
//		// 파라미터가 없는 경우는 괄호로 해주면 된다
//		// 리턴이 없을 경우에는 { } 블록 안에다 하고싶은 일을 넣어주면 된다
//		
//		// UseFuncIF.exec1(() -> { return "Hello"; } );  리턴하지 못하는 함수, ERROR
//		 UseFuncIF.exec1(() -> { } ); // 문제 없음
		 
//		{
//			UseFuncIF.exec2(() -> { return 10; } );
//			UseFuncIF.exec2(() -> 10 ); // 리턴 있는 친구들은 중괄호가 굳이 필요가 없다
//			// UseFuncIF.exec2(() -> return 10 ); 이렇게는 안됨. return 키워드 쓰려면 중괄호 있어야 됨
//			UseFuncIF.exec2(() -> {
//				int n1 = 10, n2 = 20;
//				return n1 + n2;
//			});
//			
//			UseFuncIF.exec2(() -> sm1());
//		}
//		
//		{
//			UseFuncIF.exec3((n) -> "Hello");
//			UseFuncIF.exec3( n -> "입력값에 10을 더하면 : " + (n + 10));
//			UseFuncIF.exec3( n -> {
//				if(n%2 == 0) return "짝수입니다";
//				else return "홀수입니다";
//			});
//		}
		
//		{
//			UseFuncIF.exec4((n1, n2) -> n1+n2);
//			UseFuncIF.exec4((n1, n2) -> Math.min(n1, n2));
//			UseFuncIF.exec4(10, 20, (n1, n2) -> Math.max(n1, n2));
//			// func 부분에 람다식을 넣는거라고 생각
//		}
		
		{
			// 두 객체의 y, x 좌표 중 y 가 큰 객체를 리턴한다
			UseFuncIF.exec5(new MyClass(7, 2), new MyClass(3, 9), (mc1, mc2) -> {
				return mc1.y > mc2.y ? mc1 : mc2;
			});
			UseFuncIF.exec5(new MyClass(7, 2), new MyClass(3, 9), (mc1, mc2) -> {
				return mc1.y + mc1.x > mc2.y + mc2.x ? mc1 : mc2;
			});
		}
	}

	// 누군가가 아래의 Interface를 구현한 객체를 필요로 한다
	// 인터페이스는 사용자와 제공자 사이를 연결해주는 !약속!
	static interface FuncIF1 { void m(); } // 파라미터 X, return type X
	static interface FuncIF2 { int m(); } // 파라미터 X, return int
	static interface FuncIF3 { String m (int n); } // 파라미터 o, return String
	static interface FuncIF4 { int m (int n1, int n2); } // 파라미터  2개, return int
	static interface FuncIF5 { MyClass m(MyClass mc1, MyClass mc2); };
	
	static int sm1() {return 1; }
	
	// 누군가가 바로 나다 (사용자)
	static class UseFuncIF{
		public static void exec1(FuncIF1 funcIFImpl) {
			funcIFImpl.m();
		}
		
		public static void exec2(FuncIF2 funcIFImpl) {
			System.out.println(funcIFImpl.m());
		}
		
		public static void exec3(FuncIF3 funcIFImpl) {
			System.out.println(funcIFImpl.m(6));
		}
		
		public static void exec4(FuncIF4 funcIFImpl) {
			System.out.println(funcIFImpl.m(7, 2));
		}
		
		public static void exec4(int n1, int n2, FuncIF4 funcIFImpl) {
			System.out.println(funcIFImpl.m(n1, n2));
		}
		
		public static void exec5(MyClass mc1, MyClass mc2, FuncIF5 funcIFImpl) {
			System.out.println(funcIFImpl.m(mc1, mc2));
		}
	}
	
	static class MyClass{
		int y;
		int x;
		
		public MyClass(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "MyClass [y=" + y + ", x=" + x + "]";
		}
	}
	
}
