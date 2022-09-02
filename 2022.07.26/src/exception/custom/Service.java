package exception.custom;

public class Service {
	public int addEmpVocation(EmpDto dto, int days) throws EmpException {
		// 비즈니스 로직 (인사 규정에 맞는지 확인)
		// 휴가일수가 5일을 초과하면 X
		if(days > 5) {
			// 문제 발생
			throw new EmpException("ERR_02", "휴가 일수가 5일을 초과합니다");
		}
		
		Dao dao = new Dao();
		return dao.addEmpVocation(dto, days);
	}
}
