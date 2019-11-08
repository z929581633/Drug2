package com.drug.ymq.entity;

public class StorAge {
	private Integer stoId;				//入库编号
	private String 	typeGoods;			//货物类型 
	private String  goodsNumber;		//货物数量 
	private String  goodsTime;			//订单生成时间 
	private String  status;				//审核状态 
	private String  stoTime;			//入库时间
	private String  reviewer;			//评论
	private String  note;				//注释
	public Integer getStoId() {
		return stoId;
	}
	public void setStoId(Integer stoId) {
		this.stoId = stoId;
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
	public String getStoTime() {
		return stoTime;
	}
	public void setStoTime(String stoTime) {
		this.stoTime = stoTime;
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
	public StorAge(Integer stoId, String typeGoods, String goodsNumber, String goodsTime, String status, String stoTime,
			String reviewer, String note) {
		super();
		this.stoId = stoId;
		this.typeGoods = typeGoods;
		this.goodsNumber = goodsNumber;
		this.goodsTime = goodsTime;
		this.status = status;
		this.stoTime = stoTime;
		this.reviewer = reviewer;
		this.note = note;
	}

	
	public StorAge() {
		 super();
	}
	public StorAge(String typeGoods, String goodsNumber, String goodsTime) {
		super();
		this.typeGoods = typeGoods;
		this.goodsNumber = goodsNumber;
		this.goodsTime = goodsTime;
	}
		
	

}
