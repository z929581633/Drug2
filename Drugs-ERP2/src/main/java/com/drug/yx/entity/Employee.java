package com.drug.yx.entity;

public class Employee {
	private Integer empId;
	private String empName;
	private String empSex;
	private Integer empAge;
	private String empUser;
	private String empPassword;
	private String empWork;
	private String inWorkTime;
	private String outWorkTime;
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public String getEmpUser() {
		return empUser;
	}
	public void setEmpUser(String empUser) {
		this.empUser = empUser;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpWork() {
		return empWork;
	}
	public void setEmpWork(String empWork) {
		this.empWork = empWork;
	}
	public String getInWorkTime() {
		return inWorkTime;
	}
	public void setInWorkTime(String inWorkTime) {
		this.inWorkTime = inWorkTime;
	}
	public String getOutWorkTime() {
		return outWorkTime;
	}
	public void setOutWorkTime(String outWorkTime) {
		this.outWorkTime = outWorkTime;
	}
	
	public Employee(){
		
	}
	
	public Employee(Integer empId, String empName, String empSex, Integer empAge, String empUser,
			String empPassword, String empWork, String inWorkTime, String outWorkTime) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.empAge = empAge;
		this.empUser = empUser;
		this.empPassword = empPassword;
		this.empWork = empWork;
		this.inWorkTime = inWorkTime;
		this.outWorkTime = outWorkTime;
	}
	
	
	
}
