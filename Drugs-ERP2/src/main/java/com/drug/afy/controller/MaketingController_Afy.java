package com.drug.afy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.afy.biz.MaketingBiz_Afy;
import com.drug.afy.entity.sailListMessage_Afy;
/**
 * @描述：销售订单表控制层
 * @author 敖飞扬
 * @time   2019年11月1日
 */
@Controller
public class MaketingController_Afy {
	@Autowired
	private MaketingBiz_Afy maketingbizImpl;
	/**
	 * @描述：从数据库查询销售数量信息（id查询，名称查询 ，所有查询）
	 * @author 敖飞扬
	 * @time   2019年11月1日
	 * @param  id
	 * @param   name
	 * @return  map集合
	 */
	@RequestMapping("/getAllMaketing.do")
	@ResponseBody
	public Map<String, Object> getAllMaketingdetails(Integer id,String  name){
		//调取获得参数
		Map<String ,Object> map=new HashMap<String ,Object>();
		List<sailListMessage_Afy> list = null;
		//判断是否id为空与 name是否为空
		if (id == null && name==null) {
			//获得信息
			list = maketingbizImpl.getAllMaketingdetails();
			
		} else if (id != null && (name==null || name.isEmpty())) {
			//name为空获得信息
			list = maketingbizImpl.getMaketingdetailsById(id);
			
		}else if (id == null && name!=null) {
			//id为空获得信息
			list = maketingbizImpl.getMaketingdetailsByName(name);
		}
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", list.size()); 
		map.put("data", list);
		return map;
		
	}
	/**
	 * @描述：从数据库查询销售数量信息
	 * @author 敖飞扬
	 * @time   2019年11月1日
	 * @param  id
	 * @return  map集合
	 */
	@RequestMapping("/getMaketing.do")
	@ResponseBody
	public Map<String, Object> getMaketingdetails(Integer id){
		//调取获得参数
		Map<String ,Object> map=new HashMap<String ,Object>();
		List<sailListMessage_Afy> list = maketingbizImpl.getAllMaketingdetails();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", list.size()); 
		map.put("data", list);
		return map;
		
	}
	/**
	 * @描述：从数据库查询销售信息
	 * @author 敖飞扬
	 * @time   2019年11月1日
	 * @return  map集合
	 */
	@RequestMapping("/getAllsailList.do")
	@ResponseBody
	public Map<String, Object> getAllsailList(){
		//调取获得参数
		Map<String ,Object> map=new HashMap<String ,Object>();
		List<Map<String ,Object> > list = maketingbizImpl.getAllsailList();
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", list.size()); 
		map.put("data", list);
		return map;
	}
}
