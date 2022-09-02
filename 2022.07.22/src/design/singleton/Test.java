package design.singleton;

public class Test {

	public static void main(String[] args) {
//		Logger logger = new Logger();
//		Logger logger2 = new Logger();
		Logger logger = Logger.getInstance();
		logger.log("Hello");
		
		Logger logger2 = Logger.getInstance();
		if(logger == logger2) {
			System.out.println("Same");
		}else {
			System.out.println("Not Same");
		}
	}

}
