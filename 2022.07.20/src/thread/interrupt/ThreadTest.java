package thread.interrupt;

public class ThreadTest {

	public static void main(String[] args) throws Exception {
		ConsumerThread c1 = new ConsumerThread(1);
		Thread c2 = new Thread(new ConsumerRunnable(2));
		
		c1.start();
		c2.start(); // sleep 있는 친구
		
		Thread.sleep(2000); 
		c2.interrupt(); // sleep 한걸 깨움
	}

}
