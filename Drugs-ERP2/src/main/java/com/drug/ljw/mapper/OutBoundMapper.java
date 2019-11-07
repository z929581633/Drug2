package com.drug.ljw.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.ljw.entity.OutBound;
@Repository
public interface OutBoundMapper {
	//查询所有出库信息
	public List<OutBound> getAllOutBound();
	//删除某一个出库信息
	public int delOutBound(int outId);
	//修改出库的信息
	public int changeOutBound(OutBound outBound);
	//添加一个出库的信息
	public int addOutBound(OutBound outBound);
}
