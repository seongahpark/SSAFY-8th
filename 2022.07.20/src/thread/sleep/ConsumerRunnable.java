package thread.sleep;

public class ConsumerRunnable implements Runnable{
	int num;
	
	public ConsumerRunnable(int num) {
		this.num = num;
	}
	
	@Override
	public void run() {
		System.out.println("#" + num + " start");
		for(int i=0; i<1000; i++) {
			System.out.println("#" + num + " : " + i);
			if(i == 100) {
				try {
					Thread.sleep(5); // 1초 멈춰라
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		System.out.println("#" + num + " end");
	}

}
