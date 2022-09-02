package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest1 {

	public static void main(String[] args) throws IOException {
		// 내가 하려고 하는 일 <= hello.txt 파일을 읽고 싶다.
		// FileInputStream fis = new FileInputStream("hello.txt"); // throws filenoutfoundexception

		// #1 try-catch (finally)
//		try {
//			FileInputStream fis = new FileInputStream("hello.txt");
//		}catch(FileNotFoundException e) {
//			System.out.println("Exception : " + e.getMessage());
//			e.printStackTrace(); // 발생된 에러에 대한 로그를 쭉 출력해준다
//		}
//		FileInputStream fis = null;
//		try {
//			//Class.forName("java.lang.Object2");
//			fis = new FileInputStream("hello.txt");
//			System.out.println("Inside Try Block"); // 위의 코드에서 문제가 생기면 이 코드는 실행되지 않는다
//			fis.getClass();
//		}catch(FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("Inside Catch Block");
//			throw new IOException("AAA"); // 직접 핸들링 + 위임
//			//return;
//		}finally { // try-catch와 함께 사용시 예외가 발생하든않든 무조건 실행되는 블록
//			System.out.println("Always!!!"); // 항상 실행 JVM 보장
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		System.out.println("After try-catch");
		
		// 사용하고자 하는 코드에서 throws XXXException이 존재하면 해당 예외에 대한 책임이 부과된다
		// 1. 직접 Handling 한다
		// 2. 위로 위임한다
		// try-catch 는 1번
		// IO와 관련된 코드를 사용할 때는 자원반납(close()) try-finally 부분의 불편함이 존재한다
		
		
		// #2 위임
//		FileInputStream fis = new FileInputStream("hello.txt");
//		System.out.println("After try-catch");
		// IO 와 관련된 코드를 사용할 때는 자원 반납(close() ) try-finally 부분의 불편함이 존재한다
	
		// #3 throw
		
		
		// #4 try-with-resource <= AutoCloseable IF
		
		try(FileInputStream fis = new FileInputStream("hello.txt");) { // 이 블록을 TRY WITH RESOURCE 블록이라고 함
			System.out.println("Inside Try Block"); // 위의 코드에서 문제가 생기면 이 코드는 실행되지 않는다
			fis.getClass();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Inside Catch Block");
			throw new IOException("AAA"); // 직접 핸들링 + 위임
		}	
	}

}
