package com.drug.afy.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.afy.entity.sailListMessage_Afy;
/**
 * @描述：销售biz层
 * @author 敖飞扬
 * @time   2019年11月1日
 * @return  map
 */
@Repository
public interface MaketingBiz_Afy {
		/**
		 * 查询所有
		 * */
		List<sailListMessage_Afy>getAllMaketingdetails();
		/**
		 * 根据id查询sailListMessage_Afy所有
		 * */
		List<sailListMessage_Afy>getMaketingdetailsById(Integer id);
	   
		/**
		 * 查询行数
		 * */
		Integer countAllMaketingdetails();
		/**
		 * 查询sailList所有
		 * */
	    List<Map<String, Object> > getAllsailList();
	    /**
		 *根据名称 查询sailList所有
		 * */
		List<sailListMessage_Afy> getMaketingdetailsByName(String name);
}
