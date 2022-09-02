package com.ssafy.ws04.step3;

import java.util.Arrays;

public class BookManager {
	private static int MAX_SIZE = 100; // 모든 인스턴스로부터 공유받는 녀석
	private Book[] books = new Book[MAX_SIZE];
	private int size;
	
	public int getSize() {
		return this.size;
	}
	
	public void add(Book book) {
		// 배열에 담는 코드
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("유저 수를 초과하였습니다");
		}
	}
	
	public void remove(String isbn) {
		// 배열을 순회하면서 isbn이 같은 Book을 제거
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				// 순서가 유지되어야 한다면 하나씩 다 땡겨와야되지만
				// 순서가 유지되지 않아도 된다하면 맨 마지막거를 가져온다
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) return books[i];
		}
		return null;
	}
}
