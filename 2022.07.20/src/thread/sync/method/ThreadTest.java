package thread.sync.method;

import java.util.Vector;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gas gas = new Gas();
		gas.setAmount(100);
		
		for(int i=0; i<1000; i++) {
			ConsumerThread ct = new ConsumerThread(gas);
			ProducerThread pt = new ProducerThread(gas);
			ct.start();
			pt.start();
		}
	}

	Vector<String> v = new Vector<>();
}
