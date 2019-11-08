package com.drug.ymq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.ymq.bizImpl.StroAgeBizImpl;
import com.drug.ymq.entity.StorAge;


@RestController
public class StorAgeController {
	@Autowired	
	private StroAgeBizImpl stroAgeBizImpl;
	
	/**
	 * 
	   * 功能：查出入库信息
	 * @param page
	 * @return
	 * @dateTime 2019年11月8日上午8:41:55
	 */
	@RequestMapping("/getAllStorAge.do")
	public Map<String, Object> getAllStorAge(int page){
		//创建集合
		Map<String ,Object> map=new HashMap<String, Object>();
		//从数据库查询的全部仓库入库信息
		List<StorAge> list1= new ArrayList<StorAge>();
		//要返回前台的分页信息
		List<StorAge> list2= new ArrayList<StorAge>();
		//获得全部仓库入库库信息
		list1 = stroAgeBizImpl.getAllStorAge();
		//遍历仓库入库全部信息
		for(int i=((page-1)*10);i<=((page*10)-1);i++) {
			//判断  如果为真  则结束终止遍历
			if (i==list1.size()) {
				break;
			}
			//得到入库编号
			Integer stoId =list1.get(i).getStoId();
			//得到货物类型
			String typeGoods= list1.get(i).getTypeGoods();
			//得到货物数量
			String goodsNumber= list1.get(i).getGoodsNumber();
			//得到订单生成时间
			String goodsTime= list1.get(i).getGoodsTime();
			//得到审核状态
			String status= list1.get(i).getStatus();
			//得到入库时间
			String stoTime= list1.get(i).getGoodsTime();
			//得到审核人
			String reviewer= list1.get(i).getReviewer();
			//得到备注
			String note= list1.get(i).getNote();
			//讲遍历出来的仓库入库信息添加入返回前台信息的集合中
			list2.add(new StorAge(stoId, typeGoods, goodsNumber, goodsTime, status, stoTime, reviewer, note));
			
		}
		map.put("code", 0);
		//把入库的信息都遍历出来
		map.put("count", list1.size());
		//把遍历出来的信息返回到前台信息去
		map.put("data", list2);
		map.put("Msg", 3);
		
		return map;
	}
	/**
	 * 
	   * 功能：修改一个入库订单信息
	 * @param storAge
	 * @return
	 * @dateTime 2019年11月8日上午8:42:53
	 */
	@RequestMapping("/changeStorAge.do")
	public int changeStorAge(StorAge storAge) {
		//修改入库信息
		int back=stroAgeBizImpl.changeStorAge(storAge);
		return back;
		
	}
	
	/**
	 * 
	   * 功能：删除一个入库订单信息
	 * @param stoId
	 * @return
	 * @dateTime 2019年11月8日上午8:43:36
	 */
	@RequestMapping("/delStorAge.do")
	public int delStorAge(String stoId) {
		//得到入库订单信息
		int id=Integer.parseInt(stoId);
		//把新的的订单信息返回
		int row=stroAgeBizImpl.delStorAge(id);
		return row;
	}
	
	/**
	 * 
	   * 功能：新增一个入库订单信息
	 * @param typeGoods
	 * @param goodsNumber
	 * @param goodsTime
	 * @return
	 * @dateTime 2019年11月8日上午8:43:58
	 */
	@RequestMapping("/addStorAge.do")
	public int addStorAge(String typeGoods,String goodsNumber,String goodsTime) {
		StorAge storAge = new StorAge(typeGoods,goodsNumber,goodsTime);
		int row= stroAgeBizImpl.addStorAge(storAge);
		System.out.println(storAge);
		return row;
		
	}
}
