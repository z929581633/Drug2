package com.drug.ljw.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.ljw.entity.OutBound;

@Repository
public interface OutBoundBiz {

	public List<OutBound> getAllOutBound();

	public int delOutBound(int outId);

	public int changeOutBound(OutBound outBound);
	//添加一个出库的信息
	public int addOutBound(OutBound outBound);
}
