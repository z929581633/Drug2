package com.drug.tc.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.tc.entity.PurchaseOrders;

@Repository
public interface PurchaseOrdersBiz {
	/**
	 * 描述:查询所有
	 * @return List<PurchaseOrders> 集合
	 */
	public List<PurchaseOrders> selectAllPurchaseOrders();
	
	/**
	 * 描述：新增
	 * @param purchaseOrders 订单对象
	 * @return	int 影响行数
	 */
	public int addPurchaseOrders(PurchaseOrders purchaseOrders);
	
	/**
	 * 描述:修改
	 * @param purchaseOrders 订单对象
	 * @return	int 影响行数
	 */
	public int updatePurchaseOrders(PurchaseOrders purchaseOrders);
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	public int deletePurchaseOrders(int id);

}
