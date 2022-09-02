package thread.sync.method;

public class ProducerThread extends Thread{
	Gas gas;
	
	public ProducerThread(Gas gas) {
		this.gas = gas;
	}
	
	@Override
	public void run() {
		gas.produce();
	}
}
