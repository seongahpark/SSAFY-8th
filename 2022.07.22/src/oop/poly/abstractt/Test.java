package oop.poly.abstractt;

public class Test {

	public static void main(String[] args) {
		OS os = new OS();
		os.print();

		os.print(new Printer());
		os.print(new SamsungPrinter());
		os.print(new LGPrinter());
	}

}
