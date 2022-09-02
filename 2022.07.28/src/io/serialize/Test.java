package io.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyClass mc = new MyClass();
//		mc.n = 10;
//		mc.str = "Hello";
//		
//		write(mc);
		
		// Read
		MyClass mc2 = read();
		System.out.println(mc2.n);
		System.out.println(mc2.str);
	}

	static void write(MyClass mc) {
		// ObjectOutputStream, ObjectInputStream 도 Autocloseable
		try(
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyClass.dat"));
		){
			oos.writeObject(mc);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static MyClass read() {
		MyClass mc = null;
		try(
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("MyClass.dat"));
				){
			mc = (MyClass)ois.readObject();
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return mc;
	}
}
