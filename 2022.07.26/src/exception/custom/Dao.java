package exception.custom;

// DB 연결 담당
public class Dao {
	public int addEmpVocation(EmpDto dto, int days) throws EmpException {
		// DB 관련 작업 수행 전 validation check
		if(dto.getEmpNo().indexOf("emp") != 0) { // 사번이 emp로 시작하지 않는다
			// ex) emp111
			// 문제 발생
			throw new EmpException("ERR_03", "사원의 사번이 올바르지 않습니다");
		}
		System.out.println("휴가등록 완료");
		return 1;
	}
}
