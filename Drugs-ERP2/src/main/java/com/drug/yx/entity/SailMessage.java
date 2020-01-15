package com.drug.yx.entity;

public class SailMessage {
	private Integer slmId;
	private Integer salId;
	private String slmDrugId;
	private String slmDrugName;
	private float slmDrugPrice;
	private Integer slmDrugNumber;
	private float slmDrugTotlePrice;
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
	public String getSlmDrugId() {
		return slmDrugId;
	}
	public void setSlmDrugId(String slmDrugId) {
		this.slmDrugId = slmDrugId;
	}
	public String getSlmDrugName() {
		return slmDrugName;
	}
	public void setSlmDrugName(String slmDrugName) {
		this.slmDrugName = slmDrugName;
	}
	public float getSlmDrugPrice() {
		return slmDrugPrice;
	}
	public void setSlmDrugPrice(float slmDrugPrice) {
		this.slmDrugPrice = slmDrugPrice;
	}
	public Integer getSlmDrugNumber() {
		return slmDrugNumber;
	}
	public void setSlmDrugNumber(Integer slmDrugNumber) {
		this.slmDrugNumber = slmDrugNumber;
	}
	public float getSlmDrugTotlePrice() {
		return slmDrugTotlePrice;
	}
	public void setSlmDrugTotlePrice(float slmDrugTotlePrice) {
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
	
	public SailMessage(){
		
	}
	
	public SailMessage(Integer slmId, Integer salId, String slmDrugId, String slmDrugName, float slmDrugPrice,
			Integer slmDrugNumber, float slmDrugTotlePrice, String slmOtherOne, String slmOtherTwo) {
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
