package thread.interrupt;

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
					Thread.sleep(5000); // 5초 멈춰라
				} catch (InterruptedException e) { // 자는 동안 예외가 발생하면 이쪽으로 넘어온다
					// TODO Auto-generated catch block
					System.out.println("Interrupted!!!!!!!!!");
					e.printStackTrace();
				} 
			}
		}
		System.out.println("#" + num + " end");
	}

}
