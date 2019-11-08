package com.drug.tc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.tc.biz.SalesReturnBiz;
import com.drug.tc.entity.SalesReturn;
import com.drug.tc.mapper.SalesReturnMapper;

@Service
public class SalesReturnBizImpl implements SalesReturnBiz{
	@Autowired
	SalesReturnMapper salesReturnMapper;
	@Override
	public List<SalesReturn> selectAllSalesReturn(Integer id) {
		return salesReturnMapper.selectAllSalesReturn(id);
	}

	@Override
	public int addSalesReturn(SalesReturn salesReturn) {
		return salesReturnMapper.addSalesReturn(salesReturn);
	}

	@Override
	public int updateSalesReturn(SalesReturn salesReturn) {
		return salesReturnMapper.updateSalesReturn(salesReturn);
	}

	@Override
	public int deleteSalesReturn(int id) {
		salesReturnMapper.deleteSalesReturn2(id);
		return salesReturnMapper.deleteSalesReturn(id);
	}

}
