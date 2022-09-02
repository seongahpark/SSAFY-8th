package com.ssafy.ws08.step3;

public interface IBookManager {
	void add(Book book);
	void remove(String isbn);
	Book[] getList();
	Book searchByIsbn(String isbn);
	Book[] searchByTitle(String title);
	Magazine[] getMegazines();
	Book[] getBooks();
	int getTotalPrice();
	double getPriceAvg();
	int getSize();
	
	void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException;
	void buy(String isbn, int quantity) throws ISBNNotFoundException;
	
	void saveData();
}
