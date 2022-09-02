package lambda;

@FunctionalInterface
public interface MyFuncIF {
	int proc1(int n1, int n2);
	// 추상 메소드가 하나여야만 Functional Interface가 가능하다
	
	// default 메소드는 하나 가질 수 있다MyFuncIF.java
	default int proc2(int n1, int n2) {
		return n1 - n2;
	}
}
