package thread.sync.method;

public class Gas {
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public synchronized void consume() {
		if(this.amount >= 100) {
			try {
				Thread.sleep(10); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 			
			this.amount -= 100;
			System.out.println(this.amount);
		}
	}
	
	public synchronized void produce() {
		if(this.amount < 100) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 				
			this.amount += 100;
			System.out.println(this.amount);
		}
	}
}
