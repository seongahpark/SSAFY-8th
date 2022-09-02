package thread.deadlock;

public class Thread2 extends Thread {
	Object obj1;
	Object obj2;
	
	public Thread2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj2) {
			System.out.println("Thread2 owns obj2");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("Thread2 waits obj1 Lock");
			
			synchronized(obj1) {
				System.out.println("Thread2 owns obj1 & obj2");
			}
		}
	}
}
