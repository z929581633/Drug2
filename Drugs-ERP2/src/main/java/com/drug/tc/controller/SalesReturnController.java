package com.drug.tc.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.tc.biz.SalesReturnBiz;
import com.drug.tc.entity.SalesReturn;

@Controller
public class SalesReturnController {
	@Autowired
	SalesReturnBiz salesReturnBiz;
	/**
	 * 
	 * @return Map<String,Object>集合
	 */
	@RequestMapping("/selectAllSalesReturn")
	public @ResponseBody Map<String,Object> selectAllSalesReturn(Integer returnId){
		System.out.println("~~~~~~"+returnId);
		List<SalesReturn> list = salesReturnBiz.selectAllSalesReturn(returnId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("poId", 1);
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	/**
	 * 
	 * @param salesReturn \对象
	 * @param request 请求
	 * @return String 字符串
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/addSalesReturn.do")
	public @ResponseBody int addSalesReturn(SalesReturn salesReturn,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int row = salesReturnBiz.addSalesReturn(salesReturn);
		System.out.println("新增!");
		return row;
	}
	
	/**
	 * 描述:修改
	 * @param salesReturn \对象
	 * @return int 影响行数
	 */
	@RequestMapping("/updateSalesReturn.do")
	public  @ResponseBody int updateSalesReturn(SalesReturn salesReturn){
		System.out.println("修改~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int row = salesReturnBiz.updateSalesReturn(salesReturn);
		return row;
	}
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	@RequestMapping("/deleteSalesReturn.do")
	public @ResponseBody int deleteSalesReturn(Integer returnId){
		int row = salesReturnBiz.deleteSalesReturn(returnId);
		System.out.println("删除:"+row);
		return row;
	}
}
