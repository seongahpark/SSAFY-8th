package thread.sleep;

public class ThreadTest {

	public static void main(String[] args) {
		ConsumerThread c1 = new ConsumerThread(1);
		Thread c2 = new Thread(new ConsumerRunnable(2));
		
		c1.start();
		c2.start(); // sleep 있는 친구

//		System.out.println("main" +  " start");
//		for(int i=0; i<1000; i++) {
//			System.out.println("main : " + i);
//		}
//		System.out.println("main" + " end");		
	}

}
