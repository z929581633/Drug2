package com.drug.tc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 描述:采购申请实体类
 * @author taochen
 *
 */
@Component
public class PurchasingRequisition {
	private Integer prId ;// 采购申请id
	private String prName;// 采购申请人
	private String prShopName;// 采购申请店名
	private Date prTime;// 采购申请时间
	private String prAddress ;// 地址
	private Integer poId ;// 订单id 外键0
	private double orderTotal ;// 订单总金额
	private String prAuditState;// 审核状态
	private String prApplyState;//申请状态
	private String perpare1;
	private String perpare2;
	private String perpare3;
	
	public PurchasingRequisition(){}



	public PurchasingRequisition(Integer prId, String prName, String prShopName, Date prTime, String prAddress,
			Integer poId, double orderTotal, String prAuditState, String prApplyState) {
		super();
		this.prId = prId;
		this.prName = prName;
		this.prShopName = prShopName;
		this.prTime = prTime;
		this.prAddress = prAddress;
		this.poId = poId;
		this.orderTotal = orderTotal;
		this.prAuditState = prAuditState;
		this.prApplyState = prApplyState;
	}



	public String getPrApplyState() {
		return prApplyState;
	}



	public void setPrApplyState(String prApplyState) {
		this.prApplyState = prApplyState;
	}



	public Integer getPrId() {
		return prId;
	}

	public void setPrId(Integer prId) {
		this.prId = prId;
	}

	public String getPrName() {
		return prName;
	}

	public void setPrName(String prName) {
		this.prName = prName;
	}

	public String getPrShopName() {
		return prShopName;
	}

	public void setPrShopName(String prShopName) {
		this.prShopName = prShopName;
	}

	public Date getPrTime() {
		return prTime;
	}

	public void setPrTime(Date prTime) {
		this.prTime = prTime;
	}

	public String getPrAddress() {
		return prAddress;
	}

	public void setPrAddress(String prAddress) {
		this.prAddress = prAddress;
	}



	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getPrAuditState() {
		return prAuditState;
	}

	public void setPrAuditState(String prAuditState) {
		this.prAuditState = prAuditState;
	}

	public String getPerpare1() {
		return perpare1;
	}

	public void setPerpare1(String perpare1) {
		this.perpare1 = perpare1;
	}

	public String getPerpare2() {
		return perpare2;
	}

	public void setPerpare2(String perpare2) {
		this.perpare2 = perpare2;
	}

	public String getPerpare3() {
		return perpare3;
	}

	public void setPerpare3(String perpare3) {
		this.perpare3 = perpare3;
	}
	
	
}
