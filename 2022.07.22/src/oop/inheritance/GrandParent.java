package oop.inheritance;

public class GrandParent {
	String name = "할아버지"; // default access -> 같은 패키지 내에서
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public GrandParent() {}
	public GrandParent(String name) {
		this.name = name;
	}
}
