package com.ssafy.ws08.step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//singleton
public class BookManagerImpl implements IBookManager{
//	private static int MAX_SIZE = 100; // 모든 인스턴스로부터 공유받는 녀석
//	private Book[] books = new Book[MAX_SIZE];
//	private int size;
	private List<Book> books = null;

	@Override
	public int getSize() {
		return books.size();
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
	private BookManagerImpl() {
		loadData();
	} // 생성자
	public static IBookManager getInstance() {
		return instance;
	}	
	
	private void loadData() {
		// book.dat 파일로 저장됨 
		File f = new File("book.dat");
		// 파일이 존재하면 -> 객체 직렬화를 이용해 파일 -> ArrayList<Book>
		if(f.exists()) {
			try(
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));	
					){
				this.books = (ArrayList<Book>)ois.readObject();
				System.out.println("파일로부터 자료를 입력받았습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			// 파일이 존재하지 않는다면 ArrayList<Book>을 새로 만들어야 함
			this.books = new ArrayList<Book>();
		}
	}
	
	@Override
	public void saveData() {
		try(
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));	
					){
				oos.writeObject(this.books);
				System.out.println("자료를 파일로 저장했습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}		
	}

	
	@Override
	public void add(Book book) {
//		if(size < MAX_SIZE) {
//			books[size++] = book;
//		}else {
//			System.out.println("Full");
//		}
		books.add(book);
	}

	@Override
	public void remove(String isbn) {
		// 배열을 순회하면서 isbn이 같은 Book을 제거
//		for(int i=0; i<size; i++) {
//			if(books[i].getIsbn().equals(isbn)) {
//				// 순서가 유지되어야 한다면 하나씩 다 땡겨와야되지만
//				// 순서가 유지되지 않아도 된다하면 맨 마지막거를 가져온다
//				books[i] = books[size-1];
//				books[size-1] = null;
//				size--;
//				break;
//			}
//		}
		
		int size = books.size();
		for(int i=0; i<size; i++) {
			if(books.get(i).getIsbn().equals(isbn)) {
				books.remove(i);
				break;
			}
		}

	}

	@Override
	public Book[] getList() {
//		return Arrays.copyOfRange(books, 0, size);
		Book[] result = new Book[books.size()];
		return books.toArray(result); // 현재 이 컬렉션에 들어가있는 녀석들을 target Array로 복사
	}

	@Override
	public Book searchByIsbn(String isbn) {
//		for(int i=0; i<size; i++) {
//			if(books[i].getIsbn().equals(isbn)) return books[i];
//		}
//		return null;
		for(Book book : books) {
			if(book.getIsbn().equals(isbn)) return book;
		}
		return null;
	}

	@Override
	public Book[] searchByTitle(String title) {
		// #1 순회하면서 몇 개인지 확인 결과를 count 변수에 담는다 -> count를 이용하여 배열 생성
		// #2 순회하면서 배열에 담는다
		// 문자열의 부분 일치 -> contains 메소드로 확인
//		int count = 0;
//		
//		for(int i=0; i<size; i++) {
//			if(books[i].getTitle().contains(title)) count++;
//		}
//		
//		Book[] result = new Book[count];
//		int idx = 0;
//		for(int i=0; i<size; i++) {
//			if(books[i].getTitle().contains(title)) result[idx++] = books[i];
//		}
//		
//		return result;
		
		ArrayList<Book> temp = new ArrayList<>();
		for(Book book : books) {
			if(book.getTitle().contains(title)) {
				temp.add(book);
			}
		}
		
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}

	@Override
	public Magazine[] getMegazines() {
//		int count = 0;
//		
//		for(int i=0; i<size; i++) {
//			if(books[i] instanceof Magazine) count++;
//		}
//		
//		Magazine[] result = new Magazine[count]; // Magazine이 하위 클래스
//		int idx = 0;
//		
//		for(int i=0; i<size; i++) {
//			if(books[i] instanceof Magazine) result[idx++] = (Magazine)books[i]; // 형변환을 해줘야 한다
//		}
//		
//		return result;	
		ArrayList<Magazine> temp = new ArrayList<>();
		for(Book book : books) {
			if(book instanceof Magazine) temp.add((Magazine)book); // 캐스팅을 해주어야 한다
		}
		
		Magazine[] result = new Magazine[temp.size()];
		return temp.toArray(result);
	}

	@Override
	public Book[] getBooks() {
//		int count = 0;
//		
//		for(int i=0; i<size; i++) {
//			if(!(books[i] instanceof Magazine)) count++; // 매거진이 아니면
//		}
//		
//		Book[] result = new Book[count]; // Magazine이 하위 클래스
//		int idx = 0;
//		
//		for(int i=0; i<size; i++) {
//			if(!(books[i] instanceof Magazine)) result[idx++] = books[i]; // 형변환을 해줘야 한다
//		}
//		
//		return result;	
		ArrayList<Book> temp = new ArrayList<>();
		for(Book book : books) {
			if(!(book instanceof Magazine)) temp.add(book);
		}
		
		Book[] result = new Book[temp.size()];
		return temp.toArray(result);
	}

	@Override
	public int getTotalPrice() {
//		int total = 0;
//		for(int i=0; i<size; i++) {
//			total += books[i].getPrice();
//		}
//		
//		return total;
		
		int total = 0;
		for(Book book : books) {
			total += book.getPrice();
		}
		return total;
	}

	@Override
	public double getPriceAvg() {
		return (double)this.getTotalPrice() / books.size();
	}
	
	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException{
		Book book = searchByIsbn(isbn);
		if(book == null) throw new ISBNNotFoundException(isbn);
		int res = book.getQuantity() - quantity;
		if(res < 0) throw new QuantityException();
		
		book.setQuantity(res);
	}
	
	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		Book book = searchByIsbn(isbn);
		if(book == null) throw new ISBNNotFoundException(isbn);
		book.setQuantity(book.getQuantity() + quantity);
	}
	

}
