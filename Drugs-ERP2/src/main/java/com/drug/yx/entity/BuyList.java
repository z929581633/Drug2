package com.drug.yx.entity;

public class BuyList {
	private Integer buyDrugId;
	private String buyDrugName;
	private String buyDrugType;
	private double buyDrugPrice;
	private Integer buyDrugNumber;
	private double buyDrugTotlePrice;
	public Integer getBuyDrugId() {
		return buyDrugId;
	}
	public void setBuyDrugId(Integer buyDrugId) {
		this.buyDrugId = buyDrugId;
	}
	public String getBuyDrugName() {
		return buyDrugName;
	}
	public void setBuyDrugName(String buyDrugName) {
		this.buyDrugName = buyDrugName;
	}
	public String getBuyDrugType() {
		return buyDrugType;
	}
	public void setBuyDrugType(String buyDrugType) {
		this.buyDrugType = buyDrugType;
	}
	public double getBuyDrugPrice() {
		return buyDrugPrice;
	}
	public void setBuyDrugPrice(double buyDrugPrice) {
		this.buyDrugPrice = buyDrugPrice;
	}
	public Integer getBuyDrugNumber() {
		return buyDrugNumber;
	}
	public void setBuyDrugNumber(Integer buyDrugNumber) {
		this.buyDrugNumber = buyDrugNumber;
	}
	public double getBuyDrugTotlePrice() {
		return buyDrugTotlePrice;
	}
	public void setBuyDrugTotlePrice(double buyDrugTotlePrice) {
		this.buyDrugTotlePrice = buyDrugTotlePrice;
	}
	
	public BuyList(){
		
	}
	public BuyList(Integer buyDrugId, String buyDrugName, String buyDrugType, double buyDrugPrice,
			Integer buyDrugNumber, double buyDrugTotlePrice) {
		super();
		this.buyDrugId = buyDrugId;
		this.buyDrugName = buyDrugName;
		this.buyDrugType = buyDrugType;
		this.buyDrugPrice = buyDrugPrice;
		this.buyDrugNumber = buyDrugNumber;
		this.buyDrugTotlePrice = buyDrugTotlePrice;
	}
	
	
	
	
}
