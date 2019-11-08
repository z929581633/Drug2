package com.drug.tc.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.drug.tc.entity.SalesReturn;
@Repository
public interface SalesReturnBiz {
	/**
	 * 描述:查询所有
	 * @return List<SalesReturn> 集合
	 */
	public List<SalesReturn> selectAllSalesReturn(Integer id);
	
	/**
	 * 描述：新增
	 * @param SalesReturn 订单对象
	 * @return	int 影响行数
	 */
	public int addSalesReturn(SalesReturn salesReturn);
	
	/**
	 * 描述:修改
	 * @param SalesReturn 订单对象
	 * @return	int 影响行数
	 */
	public int updateSalesReturn(SalesReturn salesReturn);
	
	/**
	 * 描述:删除
	 * @param id 订单id
	 * @return int 影响行数
	 */
	public int deleteSalesReturn(int id);
}
