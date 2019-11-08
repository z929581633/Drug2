package com.drug.tc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.tc.biz.PurchaseOrdersDetailsBiz;
import com.drug.tc.entity.PurchaseOrdersDetails;
import com.drug.tc.mapper.PurchaseOrdersDetailsMapper;
@Service
public class PurchaseOrdersDetailsBizImpl implements PurchaseOrdersDetailsBiz{
	@Autowired
	PurchaseOrdersDetailsMapper podm;
	@Override
	public List<PurchaseOrdersDetails> selectAllPurchaseOrdersDetails(Integer poId) {
		return podm.selectAllPurchaseOrdersDetails(poId);
	}

	@Override
	public int addPurchaseOrdersDetails(PurchaseOrdersDetails purchaseOrdersDetails) {
		return podm.addPurchaseOrdersDetails(purchaseOrdersDetails);
	}

	@Override
	public int updatePurchaseOrdersDetails(PurchaseOrdersDetails purchaseOrdersDetails) {
		return podm.updatePurchaseOrdersDetails(purchaseOrdersDetails);
	}

	@Override
	public int deletePurchaseOrdersDetails(int id) {
		return podm.deletePurchaseOrdersDetails(id);
	}

	@Override
	public List<PurchaseOrdersDetails> getProduct() {
		return podm.getProduct();
	}

}
