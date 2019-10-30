package com.drug.yx.entity;

public class DrugsList {
	private Integer drugId;
	private String drugName;
	private String drugType;
	private String drugDesc;
	private double drugOutRoomPrice;
	private Integer drugInRoomNumber;
	public Integer getDrugId() {
		return drugId;
	}
	public void setDrugId(Integer drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugType() {
		return drugType;
	}
	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
	public String getDrugDesc() {
		return drugDesc;
	}
	public void setDrugDesc(String drugDesc) {
		this.drugDesc = drugDesc;
	}
	public double getDrugOutRoomPrice() {
		return drugOutRoomPrice;
	}
	public void setDrugOutRoomPrice(double drugOutRoomPrice) {
		this.drugOutRoomPrice = drugOutRoomPrice;
	}
	public Integer getDrugInRoomNumber() {
		return drugInRoomNumber;
	}
	public void setDrugInRoomNumber(Integer drugInRoomNumber) {
		this.drugInRoomNumber = drugInRoomNumber;
	}
	public DrugsList(){
		
	}
	
	public DrugsList(Integer drugId, String drugName, String drugType, String drugDesc, double drugOutRoomPrice,
			Integer drugInRoomNumber) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.drugType = drugType;
		this.drugDesc = drugDesc;
		this.drugOutRoomPrice = drugOutRoomPrice;
		this.drugInRoomNumber = drugInRoomNumber;
	}
	
	
	
	
}
