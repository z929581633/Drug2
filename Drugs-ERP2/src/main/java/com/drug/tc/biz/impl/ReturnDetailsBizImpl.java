package com.drug.tc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.tc.biz.ReturnDetailsBiz;
import com.drug.tc.entity.ReturnDetails;
import com.drug.tc.mapper.ReturnDetailsMapper;
@Service
public class ReturnDetailsBizImpl implements ReturnDetailsBiz{
	
	@Autowired
	ReturnDetailsMapper returnDetailsMapper;
	@Override
	public List<ReturnDetails> selectAllReturnDetails(Integer id) {
		return returnDetailsMapper.selectAllReturnDetails(id);
	}

	@Override
	public int addReturnDetails(ReturnDetails returnDetails) {
		return returnDetailsMapper.addReturnDetails(returnDetails);
	}

	@Override
	public int updateReturnDetails(ReturnDetails returnDetails) {
		return returnDetailsMapper.updateReturnDetails(returnDetails);
	}

	@Override
	public int deleteReturnDetails(int id) {
		return returnDetailsMapper.deleteReturnDetails(id);
	}

}
