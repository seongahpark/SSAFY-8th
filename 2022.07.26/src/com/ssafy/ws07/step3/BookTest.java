package com.ssafy.ws07.step3;

public class BookTest {

	public static void main(String[] args) throws ISBNNotFoundException, QuantityException {
		// TODO Auto-generated method stub
		IBookManager bookManager = BookManagerImpl.getInstance();
		System.out.println(bookManager.getSize());
		
		bookManager.add(new Book("1111", "Java", "홍길동", "홍출판", 50000, "Java 관련", 10));
		bookManager.add(new Book("2222", "OOP", "오길동", "오출판", 633333, "OOP 관련", 20));
		bookManager.add(new Book("3333", "Ssafy", "사길동", "사출판", 70000, "SSAFY 관련", 100));
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
		
		System.out.println("*** 도서구매 ***");
		
		try {
			bookManager.buy("1111", 20);
		}catch (ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("*** 도서판매 ***");
		
		try {
			bookManager.sell("2222", 40);
		}catch (QuantityException | ISBNNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(bookManager.getPriceAvg());
	}
	

}

