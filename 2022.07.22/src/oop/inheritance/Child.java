package oop.inheritance;

public class Child extends Parent {
	public Child() {
		// 컴파일러가 자동으로 부모의 기본 생성자를 호출하는 코드를 넣어줘야 오류가 생기지 않는다
		super();
		
		System.out.println(super.name);
	}
}
