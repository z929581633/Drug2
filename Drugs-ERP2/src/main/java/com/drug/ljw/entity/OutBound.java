package com.drug.ljw.entity;

public class OutBound {
	private Integer outId;
	private String typeGoods;
	private String goodsNumber;
	private String goodsTime;
	private String status;
	private String outTime;
	private String reviewer;
	private String note;
	public Integer getOutId() {
		return outId;
	}
	public void setOutId(Integer outId) {
		this.outId = outId;
	}
	public String getTypeGoods() {
		return typeGoods;
	}
	public void setTypeGoods(String typeGoods) {
		this.typeGoods = typeGoods;
	}
	public String getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(String goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getGoodsTime() {
		return goodsTime;
	}
	public void setGoodsTime(String goodsTime) {
		this.goodsTime = goodsTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public OutBound(Integer outId, String typeGoods, String goodsNumber, String goodsTime, String status,
			String outTime, String reviewer, String note) {
		super();
		this.outId = outId;
		this.typeGoods = typeGoods;
		this.goodsNumber = goodsNumber;
		this.goodsTime = goodsTime;
		this.status = status;
		this.outTime = outTime;
		this.reviewer = reviewer;
		this.note = note;
	}
	public OutBound() {
		super();
	}
	public OutBound(String typeGoods, String goodsNumber, String goodsTime, String status) {
		super();
		this.typeGoods = typeGoods;
		this.goodsNumber = goodsNumber;
		this.goodsTime = goodsTime;
		this.status = status;
	}
	
	
	
	
}
