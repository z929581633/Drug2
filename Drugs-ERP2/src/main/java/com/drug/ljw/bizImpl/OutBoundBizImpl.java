package com.drug.ljw.bizImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.ljw.biz.OutBoundBiz;
import com.drug.ljw.entity.OutBound;
import com.drug.ljw.mapper.OutBoundMapper;

@Service
public class OutBoundBizImpl implements OutBoundBiz{
	@Autowired
	private OutBoundMapper outBoundMapper;

	@Override
	public List<OutBound> getAllOutBound() {
		List<OutBound> list = new ArrayList<OutBound>();
		list = outBoundMapper.getAllOutBound();
		return list;
	}

	@Override
	public int delOutBound(int outId) {
		int back = outBoundMapper.delOutBound(outId); 
		return back;
	}

	@Override
	public int changeOutBound(OutBound outBound) {
		int back = outBoundMapper.changeOutBound(outBound);
		return back;
	}

	@Override
	public int addOutBound(OutBound outBound) {
		return outBoundMapper.addOutBound(outBound);
	}
	
}
