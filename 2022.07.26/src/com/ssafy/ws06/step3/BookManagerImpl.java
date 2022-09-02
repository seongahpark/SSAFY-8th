package com.ssafy.ws06.step3;

import java.util.Arrays;

//singleton
public class BookManagerImpl implements IBookManager{
	private static int MAX_SIZE = 100; // 모든 인스턴스로부터 공유받는 녀석
	private Book[] books = new Book[MAX_SIZE];
	private int size;

	@Override
	public int getSize() {
		return size;
	}
	
	// Singleton 패턴으로 return 해주는 객체 Type : BookManagerImpl
	// 현 시점 (Interface를 적용한) 멤버변수나 메소드가 내부용도, 외부용도 구별이 가능하다
	// BookManagerImpl 객체의 입장 : 굳이 나 전체를 넘길 필요가 있는가
	// BookTest 입장 : 난 BookManagerImpl의 구현한 기능에만 관심이 있지, 나머진 알고싶지 않다
	
//	private static BookManagerImpl instance = new BookManagerImpl();
//	private BookManagerImpl() {} // 생성자
//	public static BookManagerImpl getInstance() {
//		return instance;
//	}
	
	private static IBookManager instance = new BookManagerImpl();
	private BookManagerImpl() {} // 생성자
	public static IBookManager getInstance() {
		return instance;
	}	
	
	@Override
	public void add(Book book) {
		if(size < MAX_SIZE) {
			books[size++] = book;
		}else {
			System.out.println("Full");
		}
	}

	@Override
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

	@Override
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}

	@Override
	public Book searchByIsbn(String isbn) {
		for(int i=0; i<size; i++) {
			if(books[i].getIsbn().equals(isbn)) return books[i];
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		// #1 순회하면서 몇 개인지 확인 결과를 count 변수에 담는다 -> count를 이용하여 배열 생성
		// #2 순회하면서 배열에 담는다
		// 문자열의 부분 일치 -> contains 메소드로 확인
		int count = 0;
		
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) count++;
		}
		
		Book[] result = new Book[count];
		int idx = 0;
		for(int i=0; i<size; i++) {
			if(books[i].getTitle().contains(title)) result[idx++] = books[i];
		}
		
		return result;

	}

	@Override
	public Magazine[] getMegazines() {
		int count = 0;
		
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine) count++;
		}
		
		Magazine[] result = new Magazine[count]; // Magazine이 하위 클래스
		int idx = 0;
		
		for(int i=0; i<size; i++) {
			if(books[i] instanceof Magazine) result[idx++] = (Magazine)books[i]; // 형변환을 해줘야 한다
		}
		
		return result;	

	}

	@Override
	public Book[] getBooks() {
		int count = 0;
		
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) count++; // 매거진이 아니면
		}
		
		Book[] result = new Book[count]; // Magazine이 하위 클래스
		int idx = 0;
		
		for(int i=0; i<size; i++) {
			if(!(books[i] instanceof Magazine)) result[idx++] = books[i]; // 형변환을 해줘야 한다
		}
		
		return result;	

	}

	@Override
	public int getTotalPrice() {
		int total = 0;
		for(int i=0; i<size; i++) {
			total += books[i].getPrice();
		}
		
		return total;

	}

	@Override
	public double getPriceAvg() {
		return (double)this.getTotalPrice() / size;
	}

}
