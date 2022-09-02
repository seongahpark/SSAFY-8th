package design.singleton;

public class Logger {
	
	// #3 자신과 동일한 타입의 멤버 변수를 static 으로 선언
	private static Logger logger = new Logger();
	
//	static {
//		logger = new Logger();
//	}
	
	// #1 생성자를 private 으로
	private Logger() {} // 생성자를 private으로 만들어서 하나만 만들어지도록 함
	
	// #2 외부에 객체를 한 개만 제공하는 method 구현
	public static Logger getInstance() {
//		if(logger == null) logger = new Logger(); // private 생성자 호출
		return logger;
	}
	
	public void log(String message) {
		System.out.println("[LOG] " + message);
	}
}
