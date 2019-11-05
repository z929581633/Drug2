package com.drug.yx.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.yx.biz.SailListBiz;
import com.drug.yx.entity.DrugsList;
import com.drug.yx.entity.NewBuyList;
import com.drug.yx.entity.NewBuyListMessage;
import com.drug.yx.mapper.SailListMapper;

@Service
public class SailListBizImpl implements SailListBiz{
	
	@Autowired
	private SailListMapper sailListMapper;
	
	@Override
	public List<DrugsList> getAllDrugs() {
		List<DrugsList> list=sailListMapper.getAllDrugs();
		return list;
	}

	@Override
	public DrugsList searchShopNo(String search) {
		DrugsList drugsList=sailListMapper.searchShopNo(search);
		return drugsList;
	}

	@Override
	public Integer getDrugNumber(Integer buyDrugId) {
		int back=sailListMapper.getDrugNumber(buyDrugId);
		return back;
	}
	
	@Override
	public Integer changeDrugNumber(Map<String, Object> map) {
		int back=sailListMapper.changeDrugNumber(map);
		return back;
	}
	
	@Override
	public Integer newBuyList(NewBuyList newBuyList) {
		int back=sailListMapper.newBuyList(newBuyList);
		return back;
	}

	@Override
	public Integer NewBuyListMessage(NewBuyListMessage newBuyListMessage) {
		int back=sailListMapper.NewBuyListMessage(newBuyListMessage);
		return back;
	}

	

	

	
	
	
}
