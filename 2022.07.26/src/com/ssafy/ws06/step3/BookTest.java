package com.ssafy.ws06.step3;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBookManager bookManager = BookManagerImpl.getInstance();
		System.out.println(bookManager.getSize());
		
		bookManager.add(new Book("1111", "Java", "홍길동", "홍출판", 50000, "Java 관련"));
		bookManager.add(new Book("2222", "OOP", "오길동", "오출판", 633333, "OOP 관련"));
		bookManager.add(new Book("3333", "Ssafy", "사길동", "사출판", 70000, "SSAFY 관련"));
		System.out.println(bookManager.getSize());
		
		System.out.println("*** 도서목록 ***");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}
		
		System.out.println("*** 도서조회 ***");
		Book b = bookManager.searchByIsbn("3333");
		System.out.println(b);
		
		System.out.println("*** 도서삭제 ***");
		bookManager.remove("1111");
		System.out.println(bookManager.getSize());
		
		System.out.println("*** 도서목록 ***");
		for (Book book : bookManager.getList()) {
			System.out.println(book);
		}
		
		
		System.out.println(bookManager.getPriceAvg());
	}
	

}

