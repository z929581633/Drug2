package com.drug.tc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.tc.entity.ReturnDetails;

@Repository
public interface ReturnDetailsMapper {
	/**
	 * 描述:查询所有
	 * @return List<ReturnDetails> 集合
	 */
	public List<ReturnDetails> selectAllReturnDetails(Integer id);
	
	/**
	 * 描述：新增
	 * @param SalesReturn 订单对象
	 * @return	int 影响行数
	 */
	public int addReturnDetails(ReturnDetails returnDetails);
	
	/**
	 * 描述:修改
	 * @param SalesReturn 订单对象
	 * @return	int 影响行数
	 */
	public int updateReturnDetails(ReturnDetails returnDetails);
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	public int deleteReturnDetails(int id);
}
