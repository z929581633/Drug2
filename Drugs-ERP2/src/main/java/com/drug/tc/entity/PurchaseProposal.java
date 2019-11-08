package com.drug.tc.entity;

import org.springframework.stereotype.Component;

/**
 * 采购报价单实体类
 * @author taochen
 *
 */
@Component
public class PurchaseProposal {
	private Integer proposalId ;// 采购报价单id
	private Integer poId ;//订单id
	private double orderTotal;//订单合计    
	private String pPaymentStatus	;// 支付状态
	private String pAuditState	;// 审核状态
	private String perpare1;
	private String perpare2;
	private String perpare3;
	
	public PurchaseProposal(){}

	public PurchaseProposal(Integer proposalId, Integer poId, double orderTotal, String pPaymentStatus,
			String pAuditState) {
		super();
		this.proposalId = proposalId;
		this.poId = poId;
		this.orderTotal = orderTotal;
		this.pPaymentStatus = pPaymentStatus;
		this.pAuditState = pAuditState;
	}

	public Integer getProposalId() {
		return proposalId;
	}

	public void setProposalId(Integer proposalId) {
		this.proposalId = proposalId;
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

	public String getpPaymentStatus() {
		return pPaymentStatus;
	}

	public void setpPaymentStatus(String pPaymentStatus) {
		this.pPaymentStatus = pPaymentStatus;
	}

	public String getpAuditState() {
		return pAuditState;
	}

	public void setpAuditState(String pAuditState) {
		this.pAuditState = pAuditState;
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
