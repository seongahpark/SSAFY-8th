package thread.sync.block;

public class ProducerThread extends Thread{
	Gas gas;
	
	public ProducerThread(Gas gas) {
		this.gas = gas;
	}
	
	@Override
	public void run() {
		//gas.produce();
		synchronized(gas) {
			gas.produce();
		}
	}
}
