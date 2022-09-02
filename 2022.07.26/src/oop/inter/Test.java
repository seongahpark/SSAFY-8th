package oop.inter;

public class Test {

	public static void main(String[] args) {
		// 본질적인 상속 관계의 Type Polymorphism
		{
			// TODO Auto-generated method stub
			Animal bird = new Bird();
			//bird.eat(); // 본질적인 is-a 관계의 메소드
		}
		
		// 기능 중심의 Interface의 Type Polymorphism
		{
			Fly bird =  new Bird();
			//bird.howFastFly();
			
			Fly airplane = new Airplane();
			//airplane.howFastFly();
		}
		
		// 추상화 한 단계 더 
		// 실제로 fly를 구현한 클래스를 알지 않는다. 또는 알지 않아도 된다
		// 단지 Fly를 구현한 클래스의 객체만 필요하다
		// Test.java 이해 당사자(사용자)와 getInstance()를 제공하는 이해 당사자(제공자)
		// 중간에서 일종의 공유되는 약속, 규약을 의미한다
		// 내부적으로 무슨 일을 하든 Fly에 있는 메소드만 잘 있으면 됐어
		{
			// 어떤 클래스의 객체를 사용할 것인지 선택을 가능하게 제공
			Fly fly = FlyFactory.getInstance("bird");
			fly.howFastFly();
			fly.howToFly();
		}
	}
}
