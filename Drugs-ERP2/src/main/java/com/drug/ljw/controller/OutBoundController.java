package com.drug.ljw.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.ljw.bizImpl.OutBoundBizImpl;
import com.drug.ljw.entity.OutBound;

@RestController
public class OutBoundController {
	@Autowired
	private OutBoundBizImpl outBoundBizImpl;
	@RequestMapping("/getAllOutBound.do")
	public Map<String, Object> getAllOutBound(int page){
		//创建集合
		Map<String ,Object> map=new HashMap<String ,Object>();
		//从数据库查询的全部仓库出库信息
		List<OutBound> list1 = new ArrayList<OutBound>();
		//要返回前台的分页信息
		List<OutBound> list2 = new ArrayList<OutBound>();
		//获得全部仓库出库信息
		list1 = outBoundBizImpl.getAllOutBound();
		//遍历仓库出库全部信息
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			//判断  如果为真  则结束终止遍历
			if(i==list1.size()){
				break;
			}
			//得到出库编号
			Integer outId = list1.get(i).getOutId();
			//得到货物类型
			String typeGoods = list1.get(i).getTypeGoods();
			//得到货物数量
			String goodsNumber = list1.get(i).getGoodsNumber();
			//得到订单生成时间
			String goodsTime = list1.get(i).getGoodsTime();
			//得到审核状态
			String status = list1.get(i).getStatus();
			//得到出库时间
			String outTime = list1.get(i).getOutTime();
			//得到审核人
			String  reviewer = list1.get(i).getReviewer();
			//得到备注
			String note = list1.get(i).getNote();
			//讲遍历出来的仓库出库信息添加入返回前台信息的集合中
			list2.add(new OutBound(outId,typeGoods,goodsNumber,goodsTime,status,outTime, reviewer, note));
		}
		map.put("code", 0);
		map.put("count", list1.size()); 
		map.put("data", list2);
		return map;
	}
	@RequestMapping("/changeOutBound.do")
	public int changeOutBound(OutBound outBound) {
		int back = outBoundBizImpl.changeOutBound(outBound);
		return back;
	}
	@RequestMapping("/delOutBound.do")
	public int delOutBound(String outId){
		int id=Integer.parseInt(outId);
		int row = outBoundBizImpl.delOutBound(id);
		return row;
	}
	@RequestMapping("/addOutBound.do")
	public int addOutBound(String typeGoods,String goodsNumber,String goodsTime){
		OutBound outBound = new OutBound(typeGoods,goodsNumber,goodsTime);
		int row = outBoundBizImpl.addOutBound(outBound);
		return row;
	}
}
