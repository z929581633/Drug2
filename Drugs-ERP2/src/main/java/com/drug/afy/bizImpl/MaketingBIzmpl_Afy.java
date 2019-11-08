package com.drug.afy.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.afy.biz.MaketingBiz_Afy;
import com.drug.afy.entity.sailListMessage_Afy;
import com.drug.afy.mapper.MaketingMapper_Afy;
/**
 * @描述：销售biz映射层
 * @author 敖飞扬
 * @time   2019年11月1日
 * @return  map集合
 */
@Service
public class MaketingBIzmpl_Afy implements MaketingBiz_Afy{
	@Autowired
	private MaketingMapper_Afy maketingMapper;
	
	/**
	 * @描述 调取查询所有方法
	 * @return sailListMessage_Afy List集合
	 * */
	@Override
	public List<sailListMessage_Afy>getAllMaketingdetails(){
		List<sailListMessage_Afy> list = maketingMapper.getAllMaketingdetails();
		return list;
	}


	/**
	 * 
	 * @描述： 调取查询行数
	 * @return Maketingdetails行数
	 * */
	@Override
	public Integer countAllMaketingdetails() {
		return null;
	}



	/**
	 * 
	 * @  调取id 查询方法
	 * @return  sailListMessage_Afy List集合
	 * @param   slmId
	 * */
	@Override
	public List<sailListMessage_Afy> getMaketingdetailsById(Integer id) {
		List<sailListMessage_Afy> list = maketingMapper.getMaketingdetailsById(id);
		return list;
	}


	/**
	 * 
	 * @描述： 调取查询sailList所有方法
	 * @return  sailList List集合
	 * */

	@Override
	public List<Map<String, Object> > getAllsailList() {
		 List<Map<String, Object> > list = maketingMapper.getAllsailList();
		return list;
	}


	/**
	 * 
	 *@描述： 根据名称调取查询所有方法
	 * @param  slmDrugName
	 * @return  sailListMessage_Afy list集合
	 * */

	@Override
	public List<sailListMessage_Afy> getMaketingdetailsByName(String name) {
		List<sailListMessage_Afy> list = maketingMapper.getMaketingdetailsByName(name);
		return list;
	}
	
}
