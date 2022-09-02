package com.ssafy;

public class Phone {

	private String name = "Galaxy S22";
	private char color;
	private int price;
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", color=" + color + ", price=" + price + "]";
	}

	private int getDefaultPrice() {
		return 2000;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRealDebt() {
		return 1000;
	}
	
	public Phone(String name) { // 생성자
		System.out.println("1");
		this.name = name;
	}

	public Phone() {
	} // 기본 생성자
	
	private Phone(String name, char color) {
		this(name);
		this.color = color;
		System.out.println("2");
	}
	public Phone(String name, char color, int price) {
		this(name, color);
		this.price = price;
		System.out.println("3");
	}
	public int getSalePrice() {
		if(this.color == 'A')
			return this.price;
		return this.price + this.getDefaultPrice();
	}
}
