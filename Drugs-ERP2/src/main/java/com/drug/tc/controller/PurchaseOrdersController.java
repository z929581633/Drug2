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

import com.drug.tc.biz.PurchaseOrdersBiz;
import com.drug.tc.entity.PurchaseOrders;

@Controller
public class PurchaseOrdersController {
	@Autowired
	private PurchaseOrdersBiz purchaseOrdersBiz;
	
	/**
	 * 
	 * @return Map<String,Object>集合
	 */
	@RequestMapping("/selectAllPurchaseOrders")
	public @ResponseBody Map<String,Object> selectAllPurchaseOrders(){
		List<PurchaseOrders> list = purchaseOrdersBiz.selectAllPurchaseOrders();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("count", list.size());
		map.put("data", list);
		return map;
	}
	
	/**
	 * 
	 * @param purchaseOrders 采购订单对象
	 * @param request 请求
	 * @return String 字符串
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/addPurchaseOrders.do")
	public @ResponseBody int addPurchaseOrders(PurchaseOrders purchaseOrders,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int row = purchaseOrdersBiz.addPurchaseOrders(purchaseOrders);
		System.out.println("新增:"+purchaseOrders.getPoName()+purchaseOrders.getPoPaymentStatus());
		return row;
	}
	
	/**
	 * 描述:修改
	 * @param purchaseOrders 采购订单对象
	 * @return int 影响行数
	 */
	@RequestMapping("/updatePurchaseOrders.do")
	public  @ResponseBody int updatePurchaseOrders(PurchaseOrders purchaseOrders){
		System.out.println("修改~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int row = purchaseOrdersBiz.updatePurchaseOrders(purchaseOrders);
		System.out.println("修改:"+row+"\t"+purchaseOrders.getPoId());
		return row;
	}
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	@RequestMapping("/deletePurchaseOrders.do")
	public @ResponseBody int deletePurchaseOrders(Integer poId){
		System.out.println(poId);
		int row = purchaseOrdersBiz.deletePurchaseOrders(poId);
		System.out.println("删除:"+row);
		return row;
	}
}
