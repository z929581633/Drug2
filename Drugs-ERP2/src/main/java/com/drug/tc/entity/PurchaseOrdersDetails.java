package com.drug.tc.entity;


/**
 * 描述:采购订单详情实体类
 * @author taochen
 *
 */
public class PurchaseOrdersDetails {
	private Integer detailsId; // 采购订单详情id
	private Integer detailsNumber; //药品数量
	private String detailsName;//药品名称
	private double detailsPrice;// 药品单价
	private Integer poId ;//采购订单id 外键
	private double detailsTotal;//总价
	private String perpare1;
	private String perpare2;
	private String perpare3;
	
	public PurchaseOrdersDetails(){}

	public PurchaseOrdersDetails(int detailsId, int detailsNumber, String detailsName, double detailsPrice, int poId,
			double detailsTotal) {
		super();
		this.detailsId = detailsId;
		this.detailsNumber = detailsNumber;
		this.detailsName = detailsName;
		this.detailsPrice = detailsPrice;
		this.poId = poId;
		this.detailsTotal = detailsTotal;
	}

	public PurchaseOrdersDetails(Integer detailsId, Integer detailsNumber, String detailsName, double detailsPrice,
			Integer poId, double detailsTotal, String perpare1, String perpare2, String perpare3) {
		super();
		this.detailsId = detailsId;
		this.detailsNumber = detailsNumber;
		this.detailsName = detailsName;
		this.detailsPrice = detailsPrice;
		this.poId = poId;
		this.detailsTotal = detailsTotal;
		this.perpare1 = perpare1;
		this.perpare2 = perpare2;
		this.perpare3 = perpare3;
	}

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public int getDetailsNumber() {
		return detailsNumber;
	}

	public void setDetailsNumber(int detailsNumber) {
		this.detailsNumber = detailsNumber;
	}

	public String getDetailsName() {
		return detailsName;
	}

	public void setDetailsName(String detailsName) {
		this.detailsName = detailsName;
	}

	public double getDetailsPrice() {
		return detailsPrice;
	}

	public void setDetailsPrice(double detailsPrice) {
		this.detailsPrice = detailsPrice;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public double getDetailsTotal() {
		return detailsTotal;
	}

	public void setDetailsTotal(double detailsTotal) {
		this.detailsTotal = detailsTotal;
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
