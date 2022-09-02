package com.ssafy;

public class Sample {

	public static void main(String[] args) {
		int i = 0;
		Sam s1 = new Sam();
		
		setVal(i);
		System.out.println(i);
	
		setVal(s1.val);
		System.out.println(s1.val);
		
		setVal(s1);
		System.out.println(s1.val);
	}
	
	public static void setVal(int x) { x = 5;}
	public static void setVal(Sam s) {s.val = 100;}

}

class Sam {
	public int val = 10;
}