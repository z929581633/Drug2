package com.drug.ymq.bizImpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.ymq.biz.StroAgeBiz;
import com.drug.ymq.entity.StorAge;
import com.drug.ymq.mapper.StorAgeMapper;
@Service
public class StroAgeBizImpl implements StroAgeBiz{
	@Autowired
	private StorAgeMapper storAgeMapper;
	
	/**
	 * 查询所有入库的信息
	 */
	@Override
	public List<StorAge> getAllStorAge() {
		List<StorAge> list= new ArrayList<StorAge>();
		list = storAgeMapper.getAllStorAge();
		return list;
	}
	
	/**
	   * 删除一个入库订单信息
	 */
	@Override
	public int delStorAge(int stoId) {
		int back = storAgeMapper.delStorAge(stoId);
		return back;
	}
	
	/**
	   *  修改一个入库的信息
	 */
	@Override
	public int changeStorAge(StorAge storAge) {
		int back= storAgeMapper.changeStorAge(storAge);
		return back;
	}
	
	/**
	   *  增加新的入库的信息
	 */
	@Override
	public int addStorAge(StorAge storAge) {
		return storAgeMapper.addStorAge(storAge);
	}

}

