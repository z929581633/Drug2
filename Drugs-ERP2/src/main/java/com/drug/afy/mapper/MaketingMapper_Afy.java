package com.drug.afy.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.drug.afy.entity.sailListMessage_Afy;

/**
 * @描述：销售订单查询层  
 * @author 敖飞扬
 * @time   2019年11月1日
 */
@Repository
public interface MaketingMapper_Afy {
	//查询销售订单数量信息
	@Select("select * from sailListMessage")
	 List<sailListMessage_Afy>getAllMaketingdetails();
	//根据 id 查询销售订单数量信息
	 @Select("select * from sailListMessage where slmId = #{slmId}")
	 List<sailListMessage_Afy>getMaketingdetailsById(Integer id);
	//根据名称查询销售订单数量信息
	 @Select("select * from sailListMessage where slmDrugName like concat('%',#{slmDrugName},'%')")
	 List<sailListMessage_Afy> getMaketingdetailsByName(String name);
	 //查询销售订单数量信息的行数
	@Select("select count(*) from sailListMessage")
	Integer countAllMaketingdetails();
	
	//查询销售订单收入信息( 月份,交易量。交易金额 )
	@Select("SELECT SUBSTR(salTime,1,7) 月份, COUNT(*) 交易量, SUM(salGetMoney) 交易金额 FROM sailList\r\n" + 
			"GROUP BY SUBSTR(salTime,1,7)\r\n" + 
			"ORDER BY SUBSTR(salTime,1,7)")
	 List<Map<String, Object> > getAllsailList();
}
