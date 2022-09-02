package com.ssafy;

public class PhoneTest {

	public static void main(String[] args) {
		//Phone phone = new Phone("S22", 'B', 5000);
		//System.out.println(phone.getName());
		
		//Phone phone2 = new Phone("S21", 5000);
//		Phone phone = new Phone("Z-Flip"); // 생성자 호출
//		phone.setColor('A');
//		
//		Phone phone2 = new Phone("Note");
//		phone2.setColor('B');
//		
//		System.out.println(phone.getSalePrice());
//		System.out.println(phone2.getSalePrice());
		
//		Phone [] phoneArray = new Phone[5];
//		for(int i=0; i<phoneArray.length; i++) {
//			phoneArray[i] = new Phone();
//			phoneArray[i].setPrice(i * 2000);
//		}
//		
//		for(Phone phone : phoneArray) {
//			System.out.println(phone.getPrice());
//		}
		
//		int i1 = 10;
//		int i2 = 10;
//		
//		String s1 = "Hello";
//		String s2 = "Hello";
//		String s3 = new String("Hello");
//		String s4 = new String("Hello");
//		
//		if(i1 == i2) System.out.println("i1 i2 same");
//		if(s1 == s2) System.out.println("s1 s2 same");
//		if(s3 == s4) System.out.println("s3 s4 same");
//		if(s3.equals(s4)) System.out.println("s3 s4 same");
//		
//		Phone p1 = new Phone("S22", 'A', 10000);
//		Phone p2 = new Phone("S22", 'A', 10000);
//		
//		if(p1 == p2) System.out.println("p1 p2 same");
//		if(p1.equals(p2)) System.out.println("p1 p2 equals");
//		
//		System.out.println(p1);
//		System.out.println(p2);
		
		int i = 10;
		setVal(i);
		System.out.println(i);
		
		Pass p = new Pass();
		p.val = 10;
		setVal(p);
		System.out.println(p.val);
	}

	public static void setVal(int x) { x = 5;}
	public static void setVal(Pass p) {p.val = 5;}
}

class Pass{
	public int val = 3;
}