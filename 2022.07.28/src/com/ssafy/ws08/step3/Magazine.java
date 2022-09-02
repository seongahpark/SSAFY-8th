package com.ssafy.ws08.step3;

public class Magazine extends Book{
	private int year;
	private int month;
	
	public Magazine() {}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
		super(isbn, title, author, publisher, price, desc, quantity);
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Magazine [year=" + year + ", month=" + month + ", isbn=" + isbn + ", title=" + title + ", author="
				+ author + ", publisher=" + publisher + ", price=" + price + ", desc=" + desc + "]";
	}
	
}
