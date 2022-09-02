package oop.inter;

public class Dove extends Bird{
	// Bird가 구현한 Fly의 두 메소드가 맘에 들지 않는다 -> 재정의 Override
	
	@Override
	public void howToFly() {
		System.out.println("기억이 나지 않음.......");
	}
}
