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
import com.drug.yx.entity.BuyList;
import com.drug.yx.entity.DrugsList;


@Controller
public class SallController {
	@Autowired
	private SailListBiz sailListBiz;
	
	@RequestMapping("/getAllSailList.do")
	@ResponseBody
	public Map<String, Object> getAllSailList(int page){
		//创建返回的map格式
		Map<String ,Object> map=new HashMap<String ,Object>();
		//新建商品列表集合
		List<DrugsList> list=new ArrayList<DrugsList>();
		//新建分页列表格式
		List<DrugsList> list0=new ArrayList<DrugsList>();
		//获得所有的商品列表
		list=sailListBiz.getAllDrugs();
		//开始分页
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			//如果到达上限，则退出循环
			if(i==list.size()){
				break;
			}
			//获得商品id
			int drugId=list.get(i).getDrugId();
			//获得商品名
			String drugName=list.get(i).getDrugName();
			//获得药品类型
			String drugType=list.get(i).getDrugType();
			//获得药品描述
			String drugDesc=list.get(i).getDrugDesc();
			//获得出库售价
			double drugOutRoomPrice=list.get(i).getDrugOutRoomPrice();
			//获得库存
			Integer drugInRoomNumber=list.get(i).getDrugInRoomNumber();
			//将获得的药品数据存入药品对象
			DrugsList dList=new DrugsList(drugId,drugName,drugType,drugDesc,drugOutRoomPrice,drugInRoomNumber);
			//将添加好的药品对象放入集合
			list0.add(dList);
		}
		//设置好响应格式
		map.put("code", 0);
		map.put("data", list0);
		map.put("count", list.size());
		//将结果返回
		return map;
	}
	
	@RequestMapping("/findShopNo.do")
	@ResponseBody
	public Integer searchShopNo(String search,HttpSession session) {
		//System.out.println(search);
		DrugsList drugsList=sailListBiz.searchShopNo(search);
		//判断1.是否查询到商品信息、2.前台是否未输入、3.前台是否输入空值
		if(drugsList==null||search==null||"".equals(search.trim())){
			return 1;
		}
		//新建购物订单
		List<BuyList> list=new ArrayList<BuyList>();
		//从session中拿到购物清单
		List<BuyList> getList=(List<BuyList>)session.getAttribute("buyList");
		//判断清单列表是否存在
		//如果不存在，则创建清单列表
		if(getList==null){
			//
			int buyDrugId=drugsList.getDrugId();
			String buyDrugName=drugsList.getDrugName();
			String buyDrugType=drugsList.getDrugType();
			double buyDrugPrice=drugsList.getDrugOutRoomPrice();
			int buyDrugNumber=1;
			double buyDrugTotlePrice=buyDrugPrice*buyDrugNumber;
			BuyList buyList=new BuyList( buyDrugId,buyDrugName,buyDrugType,buyDrugPrice,buyDrugNumber,buyDrugTotlePrice);
			list.add(buyList);
			session.setAttribute("buyList", list);
		}else{
			//如果存在，先判断此次商品是否已存在
			for(int i=0;i<getList.size();i++){
				//已存在、则更新
				if(drugsList.getDrugId().equals(getList.get(i).getBuyDrugId())){
					//获取查询出来的药品id，放入购物清单中
					int buyDrugId=drugsList.getDrugId();
					//获取查询出来的药品名，放入购物清单中
					String buyDrugName=drugsList.getDrugName();
					//获取查询出来的药品类型，放入购物清单中
					String buyDrugType=drugsList.getDrugType();
					//获取查询出来的药品价格，放入购物清单中
					double buyDrugPrice=drugsList.getDrugOutRoomPrice();
					//获取查询出来的购买数量，放入购物清单中
					int buyDrugNumber=getList.get(i).getBuyDrugNumber()+1;
					//获取查询出来的购买小计，放入购物清单中
					double buyDrugTotlePrice=buyDrugPrice*buyDrugNumber;
					//新建购物清单
					BuyList buyList=new BuyList( buyDrugId,buyDrugName,buyDrugType,buyDrugPrice,buyDrugNumber,buyDrugTotlePrice);
					//将新建好的购物清单更新至购物清单集合
					getList.set(i, buyList);
					//更新session中的购物清单
					session.setAttribute("buyList", getList);
					//返回结果
					return 0;
				}
			}
			//未存在，则新建一个
			//取出商品id
			int buyDrugId=drugsList.getDrugId();
			//取出商品名
			String buyDrugName=drugsList.getDrugName();
			//取出商品类型
			String buyDrugType=drugsList.getDrugType();
			//取出商品价格
			double buyDrugPrice=drugsList.getDrugOutRoomPrice();
			//默认数量
			int buyDrugNumber=1;
			//计算出小计
			double buyDrugTotlePrice=buyDrugPrice*buyDrugNumber;
			//将数据添加至购物清单
			BuyList buyList=new BuyList(buyDrugId,buyDrugName,buyDrugType,buyDrugPrice,buyDrugNumber,buyDrugTotlePrice);
			//将设置好的购物清单放入购物清单集合中
			getList.add(buyList);
			//把集合放入session中
			session.setAttribute("buyList", getList);
		}
		//返回结果
		return 0;
	}
	
	@RequestMapping("/getBuyList.do")
	@ResponseBody
	public Map<String, Object> getBuyList(String buyListFlag,HttpSession session){
		Map<String , Object> map=new HashMap<String , Object>();
		List<BuyList> list=new ArrayList<BuyList>();
		list=(List<BuyList>)session.getAttribute("buyList");
		if(list!=null){
			map.put("code", 0);
			map.put("data", list);
			map.put("count", list.size());
			return map;
		}
		return null;
	}
	
}
