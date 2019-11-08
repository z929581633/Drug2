package com.drug.yx.entity;

public class NewBuyList {
	private Integer salId;
	private Integer empId;
	private String salTime;
	private double salAllPrice;
	private double salPayPrice;
	private double salGetMoney;
	private double salChangePrice;
	private Integer salVIPNo;
	
	public Integer getSalId() {
		return salId;
	}
	public void setSalId(Integer salId) {
		this.salId = salId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getSalTime() {
		return salTime;
	}
	public void setSalTime(String salTime) {
		this.salTime = salTime;
	}
	public double getSalAllPrice() {
		return salAllPrice;
	}
	public void setSalAllPrice(double salAllPrice) {
		this.salAllPrice = salAllPrice;
	}
	public double getSalPayPrice() {
		return salPayPrice;
	}
	public void setSalPayPrice(double salPayPrice) {
		this.salPayPrice = salPayPrice;
	}
	public double getSalGetMoney() {
		return salGetMoney;
	}
	public void setSalGetMoney(double salGetMoney) {
		this.salGetMoney = salGetMoney;
	}
	public double getSalChangePrice() {
		return salChangePrice;
	}
	public void setSalChangePrice(double salChangePrice) {
		this.salChangePrice = salChangePrice;
	}
	public Integer getSalVIPNo() {
		return salVIPNo;
	}
	public void setSalVIPNo(Integer salVIPNo) {
		this.salVIPNo = salVIPNo;
	}
	public NewBuyList(){
		
	}
	public NewBuyList(Integer empId, String salTime, double salAllPrice, double salPayPrice, double salGetMoney,
			double salChangePrice, Integer salVIPNo) {
		super();
		this.empId = empId;
		this.salTime = salTime;
		this.salAllPrice = salAllPrice;
		this.salPayPrice = salPayPrice;
		this.salGetMoney = salGetMoney;
		this.salChangePrice = salChangePrice;
		this.salVIPNo = salVIPNo;
	}
	
	
	
	
}
