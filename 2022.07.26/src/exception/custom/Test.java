package exception.custom;

public class Test {

	public static void main(String[] args) {
		Controller controller = new Controller();
		EmpDto dto = getEmpDto();
		
		try {
			controller.addEmpVocation(dto, 5);
		} catch (EmpException e) {
			switch (e.exCode) {
			// 아래의 코드는 동일한 처리 <= switch-case 필요 X
			// 다만, 구조적인 형태를 취하기 위해서 구분
			case "ERR_01":
			case "ERR_02":
			case "ERR_03":
			default:
				System.out.println(e.exCode + " : " + e.getMessage());
			}
		}
	}

	static EmpDto getEmpDto() {
		//return null; // EmpDto 자체가 null
		//return new EmpDto(); // EmpDto의 empNo null
		return new EmpDto("emp111");
	}
}
