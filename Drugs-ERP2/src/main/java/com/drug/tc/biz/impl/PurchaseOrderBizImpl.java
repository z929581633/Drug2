package com.drug.tc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.tc.biz.PurchaseOrdersBiz;
import com.drug.tc.entity.PurchaseOrders;
import com.drug.tc.mapper.PurchaseOrdersMapper;

@Service
public class PurchaseOrderBizImpl implements PurchaseOrdersBiz{
	
	@Autowired
	private PurchaseOrdersMapper purchaseOrdersMapper;
	@Override
	public List<PurchaseOrders> selectAllPurchaseOrders() {
		return purchaseOrdersMapper.selectAllPurchaseOrders();
	}
	@Override
	public int addPurchaseOrders(PurchaseOrders purchaseOrders) {
		return purchaseOrdersMapper.addPurchaseOrders(purchaseOrders);
	}
	@Override
	public int updatePurchaseOrders(PurchaseOrders purchaseOrders) {
		return purchaseOrdersMapper.updatePurchaseOrders(purchaseOrders);
	}
	@Override
	public int deletePurchaseOrders(int id) {
		purchaseOrdersMapper.deletePurchaseOrders2(id);
		return purchaseOrdersMapper.deletePurchaseOrders(id);
	}


}
