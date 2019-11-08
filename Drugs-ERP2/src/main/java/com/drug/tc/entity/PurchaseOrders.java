package com.drug.tc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;


/**
 * 描述:采购订单实体类
 * @author taochen
 *
 */
public class PurchaseOrders {
	private Integer poId;// 采购订单id
	private String poName;// 采购人
	private String poTime;//采购时间
	private String poPaymentStatus;// 支付状态
	private String poAuditState;// 审核状态
	private String poSupplier;//供货商
	private String perpare1	;
	private String perpare2	;
	private String perpare3	;
	
	public PurchaseOrders(){}

	public PurchaseOrders(Integer poId, String poName, String poTime, String poPaymentStatus, String poAuditState,
			String poSupplier) {
		super();
		this.poId = poId;
		this.poName = poName;
		this.poTime = poTime;
		this.poPaymentStatus = poPaymentStatus;
		this.poAuditState = poAuditState;
		this.poSupplier = poSupplier;
	}

	public PurchaseOrders(Integer poId, String poName, String poTime, String poPaymentStatus, String poAuditState,
			String poSupplier, String perpare1, String perpare2, String perpare3) {
		super();
		this.poId = poId;
		this.poName = poName;
		this.poTime = poTime;
		this.poPaymentStatus = poPaymentStatus;
		this.poAuditState = poAuditState;
		this.poSupplier = poSupplier;
		this.perpare1 = perpare1;
		this.perpare2 = perpare2;
		this.perpare3 = perpare3;
	}

	public Integer getPoId() {
		return poId;
	}

	public void setPoId(Integer poId) {
		this.poId = poId;
	}

	public String getPoName() {
		return poName;
	}

	public void setPoName(String poName) {
		this.poName = poName;
	}

	public String getPoTime() {
		return poTime;
	}

	public void setPoTime(String poTime) {
		this.poTime = poTime;
	}

	public String getPoPaymentStatus() {
		return poPaymentStatus;
	}

	public void setPoPaymentStatus(String poPaymentStatus) {
		this.poPaymentStatus = poPaymentStatus;
	}

	public String getPoAuditState() {
		return poAuditState;
	}

	public void setPoAuditState(String poAuditState) {
		this.poAuditState = poAuditState;
	}

	public String getPoSupplier() {
		return poSupplier;
	}

	public void setPoSupplier(String poSupplier) {
		this.poSupplier = poSupplier;
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
