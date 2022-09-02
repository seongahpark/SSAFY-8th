package io.xml;

import java.time.LocalDate; // java 8

public class Emp {
	private String empId;
	private String empNm;
	private int salary;
	private LocalDate enterDt; // java type 패키지에 있다
	
	public Emp() {}
	public Emp(String empId, String empNm, int salary, LocalDate enterDt) {
		super();
		this.empId = empId;
		this.empNm = empNm;
		this.salary = salary;
		this.enterDt = enterDt;
	}
	
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
	public LocalDate getEnterDt() {
		return enterDt;
	}
	public void setEnterDt(LocalDate enterDt) {
		this.enterDt = enterDt;
	}
	
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empNm=" + empNm + ", salary=" + salary + ", enterDt=" + enterDt + "]";
	}
	
	
}
