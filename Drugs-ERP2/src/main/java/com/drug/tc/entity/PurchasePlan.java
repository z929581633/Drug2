package com.drug.tc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;


/**
 * 描述:采购计划实体类
 * @author taochen
 *
 */
public class PurchasePlan {
	private Integer planId;// 采购计划ID主键自动增长
	private String planName;//计划名
	private Date planTime;//创建时间
	private Date planSubmissionTime;//提交计划时间
	private String purchaseState;// 采购状态
	private String planRemark;// 采购备注
	private double planTotalPrices	;// 采购金额
	private String planState;// 审核状态
	private Date planAuditTime;// 审核时间
	private String planAuditOpinion ;// 审核意见
	private Integer supplierId	;// 供应商ID外键
	private String perpare1;
	private String perpare2;
	private String perpare3;
	
	public PurchasePlan(){}

	public PurchasePlan(Integer planId, String planName, Date planTime, Date planSubmissionTime, String purchaseState,
			String planRemark, double planTotalPrices, String planState, Date planAuditTime, String planAuditOpinion,
			Integer supplierId) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planTime = planTime;
		this.planSubmissionTime = planSubmissionTime;
		this.purchaseState = purchaseState;
		this.planRemark = planRemark;
		this.planTotalPrices = planTotalPrices;
		this.planState = planState;
		this.planAuditTime = planAuditTime;
		this.planAuditOpinion = planAuditOpinion;
		this.supplierId = supplierId;
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public Date getPlanSubmissionTime() {
		return planSubmissionTime;
	}

	public void setPlanSubmissionTime(Date planSubmissionTime) {
		this.planSubmissionTime = planSubmissionTime;
	}

	public String getPurchaseState() {
		return purchaseState;
	}

	public void setPurchaseState(String purchaseState) {
		this.purchaseState = purchaseState;
	}

	public String getPlanRemark() {
		return planRemark;
	}

	public void setPlanRemark(String planRemark) {
		this.planRemark = planRemark;
	}

	public double getPlanTotalPrices() {
		return planTotalPrices;
	}

	public void setPlanTotalPrices(double planTotalPrices) {
		this.planTotalPrices = planTotalPrices;
	}

	public String getPlanState() {
		return planState;
	}

	public void setPlanState(String planState) {
		this.planState = planState;
	}

	public Date getPlanAuditTime() {
		return planAuditTime;
	}

	public void setPlanAuditTime(Date planAuditTime) {
		this.planAuditTime = planAuditTime;
	}

	public String getPlanAuditOpinion() {
		return planAuditOpinion;
	}

	public void setPlanAuditOpinion(String planAuditOpinion) {
		this.planAuditOpinion = planAuditOpinion;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
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
