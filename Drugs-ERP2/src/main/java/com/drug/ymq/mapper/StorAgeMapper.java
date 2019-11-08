package com.drug.ymq.mapper;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.drug.ymq.entity.StorAge;



@Repository
public interface StorAgeMapper {
	//查询所有入库的信息
	public List<StorAge> getAllStorAge();
	//删除一个入库订单信息
	public int delStorAge(int stoId);
	//修改一个入库订单信息
	public int changeStorAge(StorAge storAge);
	//新增一个入库订单信息
	public int addStorAge(StorAge storAge);

	
}
