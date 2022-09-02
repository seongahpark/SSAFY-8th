package thread.sync.block;

public class ConsumerThread extends Thread{
	Gas gas;
	
	public ConsumerThread(Gas gas) {
		this.gas = gas;
	}
	
	@Override
	public void run() {
		synchronized(gas) {
			gas.consume();		
		}
	}
}
