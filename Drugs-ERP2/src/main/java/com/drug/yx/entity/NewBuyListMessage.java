package com.drug.yx.entity;

public class NewBuyListMessage {
	private Integer slmId;
	private Integer salId;
	private Integer slmDrugId;
	private String slmDrugName;
	private double slmDrugPrice;
	private Integer slmDrugNumber;
	private double slmDrugTotlePrice;
	private String slmOtherOne;
	private String slmOtherTwo;
	public Integer getSlmId() {
		return slmId;
	}
	public void setSlmId(Integer slmId) {
		this.slmId = slmId;
	}
	public Integer getSalId() {
		return salId;
	}
	public void setSalId(Integer salId) {
		this.salId = salId;
	}
	public Integer getSlmDrugId() {
		return slmDrugId;
	}
	public void setSlmDrugId(Integer slmDrugId) {
		this.slmDrugId = slmDrugId;
	}
	public String getSlmDrugName() {
		return slmDrugName;
	}
	public void setSlmDrugName(String slmDrugName) {
		this.slmDrugName = slmDrugName;
	}
	public double getSlmDrugPrice() {
		return slmDrugPrice;
	}
	public void setSlmDrugPrice(double slmDrugPrice) {
		this.slmDrugPrice = slmDrugPrice;
	}
	public Integer getSlmDrugNumber() {
		return slmDrugNumber;
	}
	public void setSlmDrugNumber(Integer slmDrugNumber) {
		this.slmDrugNumber = slmDrugNumber;
	}
	public double getSlmDrugTotlePrice() {
		return slmDrugTotlePrice;
	}
	public void setSlmDrugTotlePrice(double slmDrugTotlePrice) {
		this.slmDrugTotlePrice = slmDrugTotlePrice;
	}
	public String getSlmOtherOne() {
		return slmOtherOne;
	}
	public void setSlmOtherOne(String slmOtherOne) {
		this.slmOtherOne = slmOtherOne;
	}
	public String getSlmOtherTwo() {
		return slmOtherTwo;
	}
	public void setSlmOtherTwo(String slmOtherTwo) {
		this.slmOtherTwo = slmOtherTwo;
	}
	
	public NewBuyListMessage(){
		
	}
	
	public NewBuyListMessage(Integer slmId, Integer salId, Integer slmDrugId, String slmDrugName, double slmDrugPrice,
			Integer slmDrugNumber, double slmDrugTotlePrice, String slmOtherOne, String slmOtherTwo) {
		super();
		this.slmId = slmId;
		this.salId = salId;
		this.slmDrugId = slmDrugId;
		this.slmDrugName = slmDrugName;
		this.slmDrugPrice = slmDrugPrice;
		this.slmDrugNumber = slmDrugNumber;
		this.slmDrugTotlePrice = slmDrugTotlePrice;
		this.slmOtherOne = slmOtherOne;
		this.slmOtherTwo = slmOtherTwo;
	}
	
	
	
	
}
