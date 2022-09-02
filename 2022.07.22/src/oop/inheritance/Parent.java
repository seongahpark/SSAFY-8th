package oop.inheritance;

public class Parent extends GrandParent{
	// String name = "아버지";
	public Parent(String name) {
		// setter
		//super.setName(name);
		//super(name);
		System.out.println(super.name);
	}
	
	public Parent() {}
}
