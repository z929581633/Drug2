package com.drug.yx.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.yx.entity.DrugsList;

@Repository
public interface SailListMapper {
	
	//查询所有商品表
	public List<DrugsList> getAllDrugs();
	
	//查询某一件商品
	public DrugsList searchShopNo(String search);
	
}
