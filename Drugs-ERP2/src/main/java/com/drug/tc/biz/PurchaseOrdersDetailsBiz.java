package com.drug.tc.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.tc.entity.PurchaseOrdersDetails;
@Repository
public interface PurchaseOrdersDetailsBiz {
	/**
	 * 描述:查询所有
	 * @return List<PurchaseOrdersDetails> 集合
	 */
	public List<PurchaseOrdersDetails> selectAllPurchaseOrdersDetails(Integer poId);
	
	/**
	 * 描述：新增
	 * @param PurchaseOrdersDetails 订单对象
	 * @return	int 影响行数
	 */
	public int addPurchaseOrdersDetails(PurchaseOrdersDetails purchaseOrdersDetails);
	
	/**
	 * 描述:修改
	 * @param PurchaseOrdersDetails 订单对象
	 * @return	int 影响行数
	 */
	public int updatePurchaseOrdersDetails(PurchaseOrdersDetails purchaseOrdersDetails);
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	public int deletePurchaseOrdersDetails(int id);
	
	/**
	 * 
	 * @return 采购详情集合
	 */
	public List<PurchaseOrdersDetails> getProduct();
}
