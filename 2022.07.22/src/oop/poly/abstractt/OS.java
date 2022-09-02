package oop.poly.abstractt;

public class OS { // 운영체제
	void print() {
		System.out.println("Print...");
	}
	
	void print(Printer p) {
		p.print();
	}
}
