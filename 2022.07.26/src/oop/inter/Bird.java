package oop.inter;

public class Bird extends Animal implements Fly{

	@Override
	public void howToFly() {
		// TODO Auto-generated method stub
		System.out.println("By Wing!!");
	}

	@Override
	public void howFastFly() {
		// TODO Auto-generated method stub
		System.out.println("50km/h");
	}

}
