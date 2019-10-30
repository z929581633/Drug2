package com.drug.yx.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.yx.biz.SailListBiz;
import com.drug.yx.entity.DrugsList;


@Controller
public class SallController {
	@Autowired
	private SailListBiz sailListBiz;
	
	@RequestMapping("/getAllSailList.do")
	@ResponseBody
	public Map<String, Object> getAllSailList(int page){
		Map<String ,Object> map=new HashMap<String ,Object>();
		List<DrugsList> list=new ArrayList<DrugsList>();
		List<DrugsList> list0=new ArrayList<DrugsList>();
		list=sailListBiz.getAllDrugs();
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			if(i==list.size()){
				break;
			}
			int drugId=list.get(i).getDrugId();
			String drugName=list.get(i).getDrugName();
			String drugType=list.get(i).getDrugType();
			String drugDesc=list.get(i).getDrugDesc();
			double drugOutRoomPrice=list.get(i).getDrugOutRoomPrice();
			Integer drugInRoomNumber=list.get(i).getDrugInRoomNumber();
			DrugsList dList=new DrugsList(drugId,drugName,drugType,drugDesc,drugOutRoomPrice,drugInRoomNumber);
			list0.add(dList);
		}
		map.put("code", 0);
		map.put("data", list0);
		map.put("count", list.size());
		return map;
	}
	
	@RequestMapping("/findShopNo.do")
	@ResponseBody
	public Map<String, Object> searchShopNo(String search,String buyListNo,HttpSession session) {
		DrugsList drugsList=sailListBiz.searchShopNo(search);
		List<DrugsList> list=new ArrayList<DrugsList>();
		Map<String, Object> map=new HashMap<String, Object>();
		if(drugsList.getDrugId()==null||search==null){
			return null;
		}else{
			
		}
		if("2000".equals(buyListNo)){
			session.getAttribute("thisBuyList");
			map.put("code", 0);
			map.put("data", list);
			map.put("count", list.size());
		}
			
			
		
		return map;
	}
	
	
}
