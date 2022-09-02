package oop.inter;

public class FlyFactory {
	static Fly getInstance(String clsf) {
	switch(clsf) {
	case "dove":
		return new Dove();
	case "airplane":
		return new Airplane();
	case "bird":
		return new Bird();	
	default:
		return new Airplane();
	}
	// 메소드 리턴 타입이 인터페이스
}
}
