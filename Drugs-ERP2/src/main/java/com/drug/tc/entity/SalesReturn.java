package com.drug.tc.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 描述:采购退货管理实体类
 * @author taochen
 *
 */
@Component
public class SalesReturn {
	private Integer returnId;// 退换ID 主键自动增长
	private String orderNumber;// 订单编号
	private String returnSupplier	;// 供应商名称
	private double returnMoney	;// 订单金额
	private double returnCause	;// 退货金额
	private String returnTime	;//退货时间
	private String returnPerpare1;
	private String returnPerpare2;
	private String returnPerpare3;
	
	public SalesReturn(){}

	public SalesReturn(Integer returnId, String orderNumber, String returnSupplier, double returnMoney,
			double returnCause, String returnTime) {
		super();
		this.returnId = returnId;
		this.orderNumber = orderNumber;
		this.returnSupplier = returnSupplier;
		this.returnMoney = returnMoney;
		this.returnCause = returnCause;
		this.returnTime = returnTime;
	}

	public Integer getReturnId() {
		return returnId;
	}

	public void setReturnId(Integer returnId) {
		this.returnId = returnId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getReturnSupplier() {
		return returnSupplier;
	}

	public void setReturnSupplier(String returnSupplier) {
		this.returnSupplier = returnSupplier;
	}

	public double getReturnMoney() {
		return returnMoney;
	}

	public void setReturnMoney(double returnMoney) {
		this.returnMoney = returnMoney;
	}

	public double getReturnCause() {
		return returnCause;
	}

	public void setReturnCause(double returnCause) {
		this.returnCause = returnCause;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getReturnPerpare1() {
		return returnPerpare1;
	}

	public void setReturnPerpare1(String returnPerpare1) {
		this.returnPerpare1 = returnPerpare1;
	}

	public String getReturnPerpare2() {
		return returnPerpare2;
	}

	public void setReturnPerpare2(String returnPerpare2) {
		this.returnPerpare2 = returnPerpare2;
	}

	public String getReturnPerpare3() {
		return returnPerpare3;
	}

	public void setReturnPerpare3(String returnPerpare3) {
		this.returnPerpare3 = returnPerpare3;
	}
	
	
}
