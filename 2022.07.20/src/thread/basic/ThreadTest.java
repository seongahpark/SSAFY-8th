package thread.basic;

public class ThreadTest {

	public static void main(String[] args) {
		ConsumerThread c1 = new ConsumerThread(1);
		Thread c2 = new Thread(new ConsumerRunnable(2));
		
		c1.start();
		c2.start();

		System.out.println("main" +  " start");
		for(int i=0; i<1000; i++) {
			System.out.println("main : " + i);
		}
		System.out.println("main" + " end");		
	}

}
