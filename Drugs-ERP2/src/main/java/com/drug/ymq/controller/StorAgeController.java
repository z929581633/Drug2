package com.drug.ymq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.ymq.bizImpl.StroAgeBizImpl;
import com.drug.ymq.entity.StorAge;


@RestController
public class StorAgeController {
	@Autowired	
	private StroAgeBizImpl stroAgeBizImpl;
	@RequestMapping("/getAllStorAge.do")
	public Map<String, Object> getAllStorAge(int page){
		//创建集合
		Map<String ,Object> map=new HashMap<String, Object>();
		List<StorAge> list1= new ArrayList<StorAge>();
		List<StorAge> list2= new ArrayList<StorAge>();
		list1 = stroAgeBizImpl.getAllStorAge();
		for(int i=((page-1)*10);i<=((page*10)-1);i++) {
			if (i==list1.size()) {
				break;
			}
			Integer stoId =list1.get(i).getStoId();
			String typeGoods= list1.get(i).getTypeGoods();
			String goodsNumber= list1.get(i).getGoodsNumber();
			String goodsTime= list1.get(i).getGoodsTime();
			String status= list1.get(i).getStatus();
			String stoTime= list1.get(i).getGoodsTime();
			String reviewer= list1.get(i).getReviewer();
			String note= list1.get(i).getNote();
			list2.add(new StorAge(stoId, typeGoods, goodsNumber, goodsTime, status, stoTime, reviewer, note));
			
		}
		map.put("code", 0);
		map.put("count", list1.size());
		map.put("data", list2);
		map.put("Msg", 3);
		return map;
	}
	@RequestMapping("/changeStorAge.do")
	public int changeStorAge(StorAge storAge) {
		int back=stroAgeBizImpl.changeStorAge(storAge);
		return back;
		
	}
	
	
	@RequestMapping("/delStorAge.do")
	public int delStorAge(String stoId) {
		int id=Integer.parseInt(stoId);
		int row=stroAgeBizImpl.delStorAge(id);
		return row;
	}
	@RequestMapping("/addStorAge.do")
	public int addStorAge(String typeGoods,String goodsNumber,String goodsTime) {
		StorAge storAge = new StorAge(typeGoods,goodsNumber,goodsTime);
		int row= stroAgeBizImpl.addStorAge(storAge);
		return row;
		
	}
}
