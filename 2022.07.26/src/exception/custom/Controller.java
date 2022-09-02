package exception.custom;

public class Controller {
	public int addEmpVocation(EmpDto dto, int days) throws EmpException {
		// 요청에 대한 기본 검증
		if(dto == null || dto.getEmpNo() == null) { 
			// 문제 발생
			throw new EmpException("ERR_01", "사원정보가 없습니다");
		}

		Service service = new Service();
		return service.addEmpVocation(dto, days);
	}
}
