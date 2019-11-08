package com.drug.tc.entity;

import org.springframework.stereotype.Component;

/**
 * 描述:退货详情实体类
 * @author taochen
 *
 */
@Component
public class ReturnDetails {
	private Integer detailsIds ;// 退货详情ID 主键
	private String detailsName;// 产品名称
	private Integer detailsQuantity	;// 产品数量
	private double detailsUnitPrice;// 产品单价
	private double detailsTotalPrice;// 产品总价
	private Integer returnId;// 退货ID 外键
	private String detailsPerpare1;
	private String detailsPerpare2;
	private String detailsPerpare3;
	
	public ReturnDetails(){}

	public ReturnDetails(Integer detailsIds, String detailsName, Integer detailsQuantity, double detailsUnitPrice,
			double detailsTotalPrice, Integer returnId) {
		super();
		this.detailsIds = detailsIds;
		this.detailsName = detailsName;
		this.detailsQuantity = detailsQuantity;
		this.detailsUnitPrice = detailsUnitPrice;
		this.detailsTotalPrice = detailsTotalPrice;
		this.returnId = returnId;
	}

	public Integer getDetailsId() {
		return detailsIds;
	}

	public void setDetailsId(Integer detailsIds) {
		this.detailsIds = detailsIds;
	}

	public String getDetailsName() {
		return detailsName;
	}

	public void setDetailsName(String detailsName) {
		this.detailsName = detailsName;
	}

	public Integer getDetailsQuantity() {
		return detailsQuantity;
	}

	public void setDetailsQuantity(Integer detailsQuantity) {
		this.detailsQuantity = detailsQuantity;
	}

	public double getDetailsUnitPrice() {
		return detailsUnitPrice;
	}

	public void setDetailsUnitPrice(double detailsUnitPrice) {
		this.detailsUnitPrice = detailsUnitPrice;
	}

	public double getDetailsTotalPrice() {
		return detailsTotalPrice;
	}

	public void setDetailsTotalPrice(double detailsTotalPrice) {
		this.detailsTotalPrice = detailsTotalPrice;
	}

	public Integer getReturnId() {
		return returnId;
	}

	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}

	public String getDetailsPerpare1() {
		return detailsPerpare1;
	}

	public void setDetailsPerpare1(String detailsPerpare1) {
		this.detailsPerpare1 = detailsPerpare1;
	}

	public String getDetailsPerpare2() {
		return detailsPerpare2;
	}

	public void setDetailsPerpare2(String detailsPerpare2) {
		this.detailsPerpare2 = detailsPerpare2;
	}

	public String getDetailsPerpare3() {
		return detailsPerpare3;
	}

	public void setDetailsPerpare3(String detailsPerpare3) {
		this.detailsPerpare3 = detailsPerpare3;
	}
	
	
}
