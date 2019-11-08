package com.drug.afy.entity;
/**
 * @描述：销售订单表实体类  
 * @author 敖飞扬
 * @time   2019年11月1日
 */
public class sailList_Afy {
	public int	salId ;
	public int empId ;				
	public String salType ;		
	public String salTime ;
	public double salAllPrice ;
	public double salPayprice ;
	public double salGetMoney ;
	public double salChangePrice ;
	public String salVIPNo ;
	public String salOtherOne ;
	public String salOtherTwo ;
	public int getSalId() {
		return salId;
	}
	public void setSalId(int salId) {
		this.salId = salId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
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
	public double getSalAllPrice() {
		return salAllPrice;
	}
	public void setSalAllPrice(double salAllPrice) {
		this.salAllPrice = salAllPrice;
	}
	public double getSalPayprice() {
		return salPayprice;
	}
	public void setSalPayprice(double salPayprice) {
		this.salPayprice = salPayprice;
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
	public sailList_Afy(int salId, int empId, String salType, String salTime, double salAllPrice, double salPayprice,
			double salGetMoney, double salChangePrice, String salVIPNo, String salOtherOne, String salOtherTwo) {
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
	public sailList_Afy() {
		super();
	}
	
}
