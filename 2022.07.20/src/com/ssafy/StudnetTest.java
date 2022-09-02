package com.ssafy;

public class StudnetTest {

	public static void main(String[] args) {
		Student st1 = new Student();
		st1.setName("박성아");
		st1.setAge(25);
		st1.setCampus("부울경");
		st1.setTrack("JAVA");
		st1.setC_class(3);

		Student st2 = new Student("한주연", 27, "구미", "JAVA");
		
		st1.printInfo();
		st2.printInfo();
	}

}
