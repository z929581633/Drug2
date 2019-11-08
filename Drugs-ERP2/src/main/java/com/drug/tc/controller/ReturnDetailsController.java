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

import com.drug.tc.biz.ReturnDetailsBiz;
import com.drug.tc.entity.ReturnDetails;

@Controller
public class ReturnDetailsController {
	@Autowired
	ReturnDetailsBiz returnDetailsBiz;
	
	/**
	 * 
	 * @return Map<String,Object>集合
	 */
	@RequestMapping("/selectAllReturnDetails")
	public @ResponseBody Map<String,Object> selectAllReturnDetails(Integer returnId){
		System.out.println("~~~~~~"+returnId);
		List<ReturnDetails> list = returnDetailsBiz.selectAllReturnDetails(returnId);
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
	 * @param salesReturn \对象
	 * @param request 请求
	 * @return String 字符串
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/addReturnDetails.do")
	public @ResponseBody int addReturnDetails(ReturnDetails returnDetails,HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		int row = returnDetailsBiz.addReturnDetails(returnDetails);
		System.out.println("新增!");
		return row;
	}
	
	/**
	 * 描述:修改
	 * @param salesReturn \对象
	 * @return int 影响行数
	 */
	@RequestMapping("/updateReturnDetails.do")
	public  @ResponseBody int updateReturnDetails(ReturnDetails returnDetails){
		System.out.println("修改~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int row = returnDetailsBiz.updateReturnDetails(returnDetails);
		return row;
	}
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	@RequestMapping("/deleteReturnDetails.do")
	public @ResponseBody int deleteReturnDetails(Integer detailsId){
		int row = returnDetailsBiz.deleteReturnDetails(detailsId);
		System.out.println("删除:"+row);
		return row;
	}
	
}
