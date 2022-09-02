package com.ssafy;

public class Student {
	private String name;
	private int age;
	private String campus;
	private String track;
	private int c_class;

	public Student() {
		
	}
	
	private Student(String name) {
		this.name = name;
	}
	
	public Student(String name, int age, String campus, String track) {
		this(name);
		this.age = age;
		this.campus = campus;
		this.track = track;
	}
	
	public int getC_class() {
		return c_class;
	}

	public void setC_class(int c_class) {
		this.c_class = c_class;
	}
	
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
	public String getCampus() {
		return campus;
	}
	public void setCampus(String campus) {
		this.campus = campus;
	}
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	
	public void printInfo() {
		System.out.println(this.name + "님의 정보");
		System.out.println("나이  : " + this.age);
		System.out.println("캠퍼스 : " + this.campus);
		System.out.println("트랙 : " + this.track);
		System.out.println("반 : " + this.c_class);
	}
}
