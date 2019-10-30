package com.drug.yx.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.yx.biz.SailListBiz;
import com.drug.yx.entity.DrugsList;
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

}
