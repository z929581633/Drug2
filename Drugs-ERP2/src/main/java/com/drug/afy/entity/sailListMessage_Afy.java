package com.drug.afy.entity;
/**
 * @描述：销售订单详情表实体类  
 * @author 敖飞扬
 * @time   2019年11月1日
 */
public class sailListMessage_Afy {
	public int slmId ;
	public int salId ;
	public String  slmDrugId ;
	public String  slmDrugName ;
	public double slmDrugPrice ;
	public int slmDrugNumber;
	public double slmDrugTotlePrice ;
	public String slmOtherOne ;
	public String slmOtherTwo ;
	public int getSlmId() {
		return slmId;
	}
	public void setSlmId(int slmId) {
		this.slmId = slmId;
	}
	public int getSalId() {
		return salId;
	}
	public void setSalId(int salId) {
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
	public double getSlmDrugPrice() {
		return slmDrugPrice;
	}
	public void setSlmDrugPrice(double slmDrugPrice) {
		this.slmDrugPrice = slmDrugPrice;
	}
	public int getSlmDrugNumber() {
		return slmDrugNumber;
	}
	public void setSlmDrugNumber(int slmDrugNumber) {
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
	public sailListMessage_Afy(int slmId, int salId, String slmDrugId, String slmDrugName, double slmDrugPrice,
			int slmDrugNumber, double slmDrugTotlePrice, String slmOtherOne, String slmOtherTwo) {
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
	public sailListMessage_Afy() {
		super();
	}
}
