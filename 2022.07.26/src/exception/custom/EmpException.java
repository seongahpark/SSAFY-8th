package exception.custom;

public class EmpException extends Exception{ // 조건 1 : Exception을 상속
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 예외 처리 하고는 관계 없는 녀석
	
	// 사원의 휴가 처리 업무 중
	// ERR_01 : 전달된 사원 정보가 없다
	// ERR_02 : 휴가 일수가 5일을 초과한다
	// ERR_03 : 사번이 올바르지 않다
	String exCode;
	
	public EmpException() {}
	public EmpException(String message) {
		super(message); // 조건 2: Exception 객체 생성을 위해 supeR()를 호출하면서 메세지를 전달한다
	}
	
	public EmpException(String exCode, String message) {
		super(message); 
		this.exCode = exCode;
	}
}
