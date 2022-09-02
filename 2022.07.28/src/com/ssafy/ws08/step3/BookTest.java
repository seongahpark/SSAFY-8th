package com.ssafy.ws08.step3;

public class BookTest {

	public static void main(String[] args) throws ISBNNotFoundException, QuantityException {
		// TODO Auto-generated method stub
		IBookManager bookManager = BookManagerImpl.getInstance();
		if(bookManager.getSize() == 0) {
			System.out.println("현재 등록된 도서가 없습니다");
		}else {
			System.out.println(" ** 현재 등록된 도서 목록 ** ");
			for(Book book : bookManager.getList()) {
				System.out.println(book);
			}
		}
		bookManager.add(new Book("1111", "Java", "홍길동", "홍출판", 50000, "Java 관련", 10));
		bookManager.add(new Book("2222", "OOP", "오길동", "오출판", 633333, "OOP 관련", 20));
		bookManager.add(new Book("3333", "Ssafy", "사길동", "사출판", 70000, "SSAFY 관련", 100));
		bookManager.add(new Magazine("4444", "ssss", "이길동", "사출판판", 20000, "ssafy", 2022, 05, 30));
//		System.out.println("*** 도서목록 ***");
//		for (Book book : bookManager.getList()) {
//			System.out.println(book);
//		}
	
		//bookManager.saveData();
		
	}
}


