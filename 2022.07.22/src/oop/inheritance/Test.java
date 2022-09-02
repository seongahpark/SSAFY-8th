package oop.inheritance;

public class Test {

	public static void main(String[] args) {
		GrandParent gp = new GrandParent();
		System.out.println(gp.getName());
		
		// #1 by setter
//		Parent p = new Parent();
//		p.setName("아버지");
//		System.out.println(p.getName());
		
		// #2 by constructor
		Parent p = new Parent("어머니");
		System.out.println(p.getName());

		final int arr[] = new int[3];
		arr[1] = 3;
		System.out.println(arr[1]);
		arr[1] = 4;
		System.out.println(arr[1]);
		
	}

}
