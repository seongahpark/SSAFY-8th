package oop.inter;
// 인터페이스를 implements 하는 순간, 의무 사항이 발생한다
// 반드시 기능을 구현해야 함
public class Airplane extends Transportation implements Fly{

	private int no;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public void howToFly() {
		System.out.println("By Engine!!");
		
	}

	@Override
	public void howFastFly() {
		// TODO Auto-generated method stub
		System.out.println("800km/h");
	}
	
}
