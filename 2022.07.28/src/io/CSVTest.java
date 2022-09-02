package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CSVTest {

	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<>();
		empList.add(new Emp("111", "홍길동", 4000));
		empList.add(new Emp("222", "이길동", 2000));
		empList.add(new Emp("333", "삼길동", 5000));
		empList.add(new Emp("444", "사길동", 6000));
		empList.add(new Emp("555", "오길동", 8000));

		// csv 파일 생성
		String filePath = "/Users/seongah";
		// String filePath = "c:" + File.separator + "SSAFY";
		String fileName = "empList.csv";
		
		// 폴더가 없으면 생성하라
		File file = new File(filePath); // 경로, 폴더
		if(!file.exists()) {
			file.mkdir();
		}
		
		// encoding : MS949로 변경해주어야 한다. -> 엑셀에서 깨지지 않음
		
		try( // AutoCloseable Interface로 사용이 다되면 자동으로 닫히게 된다 
				//try-resource 블록 꼭 알아두기! 
				FileOutputStream fos = new FileOutputStream(filePath + File.separator + fileName);
				OutputStreamWriter osw = new OutputStreamWriter(fos); // fileoutput stream을 Ms949
				//OutputStreamWriter osw = new OutputStreamWriter(fos, "MS949"); //맥에서는 인코딩 필요없
				BufferedWriter br = new BufferedWriter(osw);
				){
			for(Emp emp : empList) {
				// 구분자는 default는 , 이지만 대신 ^ 를 쓴다
				br.write(emp.getEmpId() + "^" + emp.getEmpNm() + "^" + emp.getSalary());
				br.newLine(); // 한 줄 개행
			}
			br.flush(); // 버퍼를 완전히 비워준다
			System.out.println("파일이 생성되었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	
}

class Emp{
	private String empId;
	private String empNm;
	private int salary;
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Emp(String empId, String empNm, int salary) {
		super();
		this.empId = empId;
		this.empNm = empNm;
		this.salary = salary;
	}
	
	public Emp() {}
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empNm=" + empNm + ", salary=" + salary + "]";
	}
	
	
	
}
