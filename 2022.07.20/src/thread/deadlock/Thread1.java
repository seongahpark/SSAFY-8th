package thread.deadlock;

public class Thread1 extends Thread {
	Object obj1;
	Object obj2;
	
	public Thread1(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}
	
	@Override
	public void run() {
		synchronized (obj1) {
			System.out.println("Thread1 owns obj1");
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println("Thread1 waits obj2 Lock");
			
			synchronized(obj2) {
				System.out.println("Thread1 owns obj1 & obj2");
			}
		}
	}
}
