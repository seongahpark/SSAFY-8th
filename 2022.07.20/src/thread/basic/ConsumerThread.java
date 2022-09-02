package thread.basic;

public class ConsumerThread extends Thread {
	int num;
	
	public ConsumerThread(int num) {
		this.num = num;
	}
	
	@Override // 부모 클래스에 있는 것을 재정의 할 것이다
	public void run() {
		System.out.println("#" + num + " start");
		for(int i=0; i<1000; i++) {
			System.out.println("#" + num + " : " + i);
		}
		System.out.println("#" + num + " end");
	}
}
