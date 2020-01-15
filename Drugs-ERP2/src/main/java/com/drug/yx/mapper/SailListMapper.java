package com.drug.yx.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.yx.entity.DrugsList;
import com.drug.yx.entity.NewBuyList;
import com.drug.yx.entity.NewBuyListMessage;
import com.drug.yx.entity.SailList;
import com.drug.yx.entity.SailMessage;

@Repository
public interface SailListMapper {
	
	//查询所有商品表
	public List<DrugsList> getAllDrugs();
	
	//查询某一件商品
	public DrugsList searchShopNo(String search);
	
	//或取当前商品的库存量
	public Integer getDrugNumber(Integer buyDrugId);
	
	//修改库存数量
	public Integer changeDrugNumber(Map<String ,Object> map);
	
	//新增商品销售订单
	public Integer newBuyList(NewBuyList newBuyList);
	
	//新增商品销售详情单
	public Integer NewBuyListMessage(NewBuyListMessage newBuyListMessage);
	
	//获取所有销售记录
	public List<SailList> getAllSailList(Map<String ,Object> map);
	
	//查询某条销售订单的详情
	public List<SailMessage> findSailMessage(Integer salId);
}
