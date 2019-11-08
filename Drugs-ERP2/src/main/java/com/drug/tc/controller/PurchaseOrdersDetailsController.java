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

import com.drug.tc.biz.PurchaseOrdersDetailsBiz;
import com.drug.tc.entity.PurchaseOrdersDetails;

@Controller
public class PurchaseOrdersDetailsController {
	
	@Autowired
	PurchaseOrdersDetailsBiz podb;
	
	/**
	 * 
	 * @return Map<String,Object>集合
	 */
	@RequestMapping("/selectAllPurchaseOrdersDetails")
	public @ResponseBody Map<String,Object> selectAllPurchaseOrdersDetails(Integer poId){
		System.out.println("~~~~~~"+poId);
		PurchaseOrdersDetails pod = new PurchaseOrdersDetails();
		List<PurchaseOrdersDetails> list = podb.selectAllPurchaseOrdersDetails(poId);
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println("采购订单详情list"+list);
		map.put("poId", 1);
		map.put("code", 0);
		System.out.println("长度:"+list.size());
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	
	/**
	 * 
	 * @param purchaseOrdersDetails 采购订单详情对象
	 * @param request 请求
	 * @return String 字符串
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/addpurchaseOrdersDetails.do")
	public @ResponseBody int addPurchaseOrders(PurchaseOrdersDetails purchaseOrdersDetails,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int row = podb.addPurchaseOrdersDetails(purchaseOrdersDetails);
		System.out.println("新增!");
		return row;
	}
	
	/**
	 * 描述:修改
	 * @param purchaseOrdersDetails 采购订单详情对象
	 * @return int 影响行数
	 */
	@RequestMapping("/updatepurchaseOrdersDetails.do")
	public  @ResponseBody int updatePurchaseOrdersDetails(PurchaseOrdersDetails purchaseOrdersDetails){
		System.out.println("修改~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int row = podb.updatePurchaseOrdersDetails(purchaseOrdersDetails);
		return row;
	}
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	@RequestMapping("/deletepurchaseOrdersDetails.do")
	public @ResponseBody int deletePurchaseOrdersDetails(Integer detailsId){
		System.out.println(detailsId);
		int row = podb.deletePurchaseOrdersDetails(detailsId);
		System.out.println("删除:"+row);
		return row;
	}
}
