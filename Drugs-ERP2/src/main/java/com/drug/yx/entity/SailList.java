package com.drug.yx.entity;

public class SailList {
	private Integer salId;
	private Integer empId;
	private String salType;
	private String salTime;
	private float salAllPrice;
	private float salPayprice;
	private float salGetMoney;
	private float salChangePrice;
	private String salVIPNo;
	private String salOtherOne;
	private String salOtherTwo;
	
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
	public String getSalType() {
		return salType;
	}
	public void setSalType(String salType) {
		this.salType = salType;
	}
	public String getSalTime() {
		return salTime;
	}
	public void setSalTime(String salTime) {
		this.salTime = salTime;
	}
	public float getSalAllPrice() {
		return salAllPrice;
	}
	public void setSalAllPrice(float salAllPrice) {
		this.salAllPrice = salAllPrice;
	}
	public float getSalPayprice() {
		return salPayprice;
	}
	public void setSalPayprice(float salPayprice) {
		this.salPayprice = salPayprice;
	}
	public float getSalGetMoney() {
		return salGetMoney;
	}
	public void setSalGetMoney(float salGetMoney) {
		this.salGetMoney = salGetMoney;
	}
	public float getSalChangePrice() {
		return salChangePrice;
	}
	public void setSalChangePrice(float salChangePrice) {
		this.salChangePrice = salChangePrice;
	}
	public String getSalVIPNo() {
		return salVIPNo;
	}
	public void setSalVIPNo(String salVIPNo) {
		this.salVIPNo = salVIPNo;
	}
	public String getSalOtherOne() {
		return salOtherOne;
	}
	public void setSalOtherOne(String salOtherOne) {
		this.salOtherOne = salOtherOne;
	}
	public String getSalOtherTwo() {
		return salOtherTwo;
	}
	public void setSalOtherTwo(String salOtherTwo) {
		this.salOtherTwo = salOtherTwo;
	}
	
	public SailList(){
		
	}
	public SailList(Integer salId, Integer empId, String salType, String salTime, float salAllPrice, float salPayprice,
			float salGetMoney, float salChangePrice, String salVIPNo, String salOtherOne, String salOtherTwo) {
		super();
		this.salId = salId;
		this.empId = empId;
		this.salType = salType;
		this.salTime = salTime;
		this.salAllPrice = salAllPrice;
		this.salPayprice = salPayprice;
		this.salGetMoney = salGetMoney;
		this.salChangePrice = salChangePrice;
		this.salVIPNo = salVIPNo;
		this.salOtherOne = salOtherOne;
		this.salOtherTwo = salOtherTwo;
	}
	
	
}
