package com.drug.yx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.yx.biz.SailListBiz;
import com.drug.yx.entity.BuyList;
import com.drug.yx.entity.DrugsList;
import com.drug.yx.entity.NewBuyList;
import com.drug.yx.entity.NewBuyListMessage;
import com.drug.yx.entity.SailList;
import com.drug.yx.entity.SailMessage;

/**
 * 
 * @author 杨旭
 * @dataTime:2019年11月7日下午4:13:30
 * Description:分店销售控制层
 */
@Controller
public class SallController {
	@Autowired
	private SailListBiz sailListBiz;
	
	/**
	 * 
	 * @param page-当前页码
	 * @return-Map<String,Object>
	 * @need:从页面传输过来的当前页面值
	 * Description:根据前台页面传输过来的当前页数据，合理的进行分页
	 */
	@RequestMapping("/getAllSailList.do")
	@ResponseBody
	public Map<String, Object> getAllSailList(int page){
		//创建返回的map格式
		Map<String ,Object> map=new HashMap<String ,Object>();
		//新建药品列表集合
		List<DrugsList> list=new ArrayList<DrugsList>();
		//新建药品分页列表格式
		List<DrugsList> list0=new ArrayList<DrugsList>();
		//获得所有的药品列表
		list=sailListBiz.getAllDrugs();
		//开始分页
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			//如果到达上限，则退出循环
			if(i==list.size()){
				break;
			}
			//获得药品id
			int drugId=list.get(i).getDrugId();
			//获得药品名
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
	
	/**
	 * 
	 * @param search-查询字段
	 * @param session-存储对象
	 * @return-Integer
	 * @need:搜寻药品的条形码
	 * Description:扫码查询出某样商品，判断其是否存在，并根据结果添加至购物清单中
	 */
	@RequestMapping("/findShopNo.do")
	@ResponseBody
	public Integer searchShopNo(String search,HttpSession session) {
		//1.前台是否未输入、2.前台是否输入空值
		if(search==null||"".equals(search.trim())){
			//返回结果1
			return 1;
		}
		//如果输入正确值，则根据该条形码是否能查询出唯一一条商品信息
		DrugsList drugsList=sailListBiz.searchShopNo(search);
		//判断1.是否查询到药品信息
		if(drugsList==null){
			//同样返回结果1
			return 1;
		}
		//新建购物订单
		List<BuyList> list=new ArrayList<BuyList>();
		//从session中拿到购物清单
		List<BuyList> getList=(List<BuyList>)session.getAttribute("buyList");
		//判断清单列表是否存在
		//如果不存在，则创建清单列表
		if(getList==null){
			//获得药品id
			int buyDrugId=drugsList.getDrugId();
			//获得药品名
			String buyDrugName=drugsList.getDrugName();
			//获得药品类型
			String buyDrugType=drugsList.getDrugType();
			//获得药品单价
			double buyDrugPrice=drugsList.getDrugOutRoomPrice();
			//默认数量
			int buyDrugNumber=1;
			//计算出药品小计
			double buyDrugTotlePrice=buyDrugPrice*buyDrugNumber;
			//新建购物清单
			BuyList buyList=new BuyList( buyDrugId,buyDrugName,buyDrugType,buyDrugPrice,buyDrugNumber,buyDrugTotlePrice);
			//将购物清单放入集合
			list.add(buyList);
			//将该集合存入session中
			session.setAttribute("buyList", list);
		}else{
			//如果存在，先判断此次药品是否已存在
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
			//取出药品id
			int buyDrugId=drugsList.getDrugId();
			//取出药品名
			String buyDrugName=drugsList.getDrugName();
			//取出药品类型
			String buyDrugType=drugsList.getDrugType();
			//取出药品价格
			double buyDrugPrice=drugsList.getDrugOutRoomPrice();
			//默认数量
			int buyDrugNumber=1;
			//计算出小计
			double buyDrugTotlePrice=buyDrugPrice*buyDrugNumber;
			//将数据添加至购物清单
			BuyList buyList=new BuyList(buyDrugId,buyDrugName,buyDrugType,buyDrugPrice,buyDrugNumber,buyDrugTotlePrice);
			//将设置好的购物清单添加至购物清单集合中
			getList.add(buyList);
			//把集合放入session中
			session.setAttribute("buyList", getList);
		}
		//返回结果
		return 0;
	}
	/**
	 * 
	 * @param buyListFlag-进入此方法的标识符
	 * @param session
	 * @return-Map<String,Object>
	 * @need:购物清单编码
	 * Description:获取session中的购物清单
	 */
	@RequestMapping("/getBuyList.do")
	@ResponseBody
	public Map<String, Object> getBuyList(String buyListFlag,HttpSession session){
		//预创建map集合
		Map<String , Object> map=new HashMap<String , Object>();
		//预创建购物清单集合
		List<BuyList> list=new ArrayList<BuyList>();
		//接收session中的购物清单
		list=(List<BuyList>)session.getAttribute("buyList");
		//定义空的总价
		double allPrice=0;
		//如果集合不为空，则在map结婚中返回回调数据
		if(list!=null){
			//计算出此次购物清单的总价
			for(int i=0;i<list.size();i++){
				//循环计算
				allPrice=allPrice+list.get(i).getBuyDrugTotlePrice();
			}
			//放入总价
			map.put("msg", allPrice);
			//放入
			map.put("code", 0);
			//放入数据集合
			map.put("data", list);
			//放入总行数
			map.put("count", list.size());
			//返回map集合
			return map;
		}
		//返回结果null
		return null;
	}
	/**
	 * 
	 * @param buyDrugId-药品编码号
	 * @param session
	 * @return-Integer-返回结果
	 * @need:药品条形码id
	 * Description:根据药品的条形码id，删除购物清单中对应的药品
	 */
	@RequestMapping("/delBuyList.do")
	@ResponseBody
	public Integer delBuyList(String buyDrugId,HttpSession session){
		//新建购物集合
		List<BuyList> list=new ArrayList<BuyList>();
		//接收到session中预存的购物清单
		list=(List<BuyList>)session.getAttribute("buyList");
		//定义为0的整数对象
		Integer parId=0;
		//转换数据格式
		parId=Integer.parseInt(buyDrugId);
		//如果session中没有数据
		if(list==null){
			//返回空
			return null;
		}
		//如果有数据，则开始循环，判断购物清单中是否对应的商品id
		for(int i=0;i<list.size();i++){
			//如果存在，则删除该药品
			if(parId.equals(list.get(i).getBuyDrugId())){
				//删除该下标上的药品数据
				list.remove(i);
			}
		}
		//将新的购物集合放回session中
		session.setAttribute("buyList", list);
		//返回结果
		return 0;
	}
	
	/**
	 * 
	 * @param session
	 * @return-Integer
	 * @need: session对象
	 * Description:删除session中的购物清单
	 */
	@RequestMapping("/resetBuyList.do")
	@ResponseBody
	public Integer resetBuyList(HttpSession session){
		//删除session中的采购清单
		session.removeAttribute("buyList");
		//返回结果
		return 0;
	}
	
	/**
	 * 
	 * @param session
	 * @param empId:员工号
	 * @param vipNo:会员号
	 * @param allPrice:总价
	 * @param payMoney:支付金额
	 * @return-double:找零
	 * @need:员工id、会员号、总价、收银
	 * Description:
	 * 1.扣减库存 --先出库
	 * 2.创建新的购物清单 
	 * 3.创建新的购物详情单 
	 */
	@RequestMapping("/newBuyList.do")
	@ResponseBody
	public double newBuyList(HttpSession session,Integer empId, Integer vipNo,Double allPrice,Double payMoney){
		//创建购物清单集合
		List<BuyList> list=new ArrayList<BuyList>();
		//从session中获取购物清单
		list=(List<BuyList>)session.getAttribute("buyList");
		//判断支付金额是否足够
		if(allPrice>payMoney){
			//不足，返回结果1
			return 0;
		}
		//判断购物清单是否为空
		if(list==null){
			//为空，返回结果1
			return 0;
		}
		
		//一.修改库存
		for(int i=0;i<list.size();i++){
			//获得该商品的商品id
			int buyDrugId=list.get(i).getBuyDrugId();
			//获得该商品的购买数量
			int buyNumber=list.get(i).getBuyDrugNumber();
			//获得该商品的库存量
			int roomNumber=sailListBiz.getDrugNumber(buyDrugId);
			//如果库存不足，则提示不能完成交易
			if(roomNumber<list.get(i).getBuyDrugNumber()){
				//返回结果1
				return 1;
			}
			//如果库存充足，则减少库存
			Map<String ,Object> map=new HashMap<String ,Object>();
			//放置该商品的id
			map.put("buyDrugId", buyDrugId);
			//放置该商品的购买量
			map.put("buyNumber", buyNumber);
			//执行减库存操作
			sailListBiz.changeDrugNumber(map);
		}
		//二.插入销售订单表
		//新建时间
		Date date=new Date();
		//格式化时间格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//初始化时间格式
		String salTime=sdf.format(date);
		//获得页面上的购买小计
		double salAllPrice=allPrice;
		//获得页面上的支付金额
		double salPayPrice=payMoney;
		//获得页面上的实收金额
		double salGetMoney=payMoney;
		//计算出找零
		double salChangePrice=salGetMoney-allPrice;
		//设置默认会员号
		Integer salVIPNo=110;
		//封装进购物列表实体类
		NewBuyList newBuyList=new NewBuyList(empId,salTime,salAllPrice,salPayPrice,salGetMoney,salChangePrice,salVIPNo);
		//执行新增销售表
		sailListBiz.newBuyList(newBuyList);
		//三.插入销售订单详情表
		Integer salId=newBuyList.getSalId();
		//初始化详情单id
		Integer slmId=0;
		//循环取出session中的list数据
		for(int i=0;i<list.size();i++){
			//获得药品id
			Integer slmDrugId=list.get(i).getBuyDrugId();
			//获得药品名
			String slmDrugName=list.get(i).getBuyDrugName();
			//获得药品单价
			double slmDrugPrice=list.get(i).getBuyDrugPrice();
			//获得购买数量
			Integer slmDrugNumber=list.get(i).getBuyDrugNumber();
			//获得购买小计
			double slmDrugTotlePrice=list.get(i).getBuyDrugTotlePrice();
			//定义两个未定义字段
			String slmOtherOne="";
			String slmOtherTwo="";
			//将对应的数据放入新购物清单实体类
			NewBuyListMessage newBuyListMessage=new NewBuyListMessage
					(slmId,salId,slmDrugId,slmDrugName,slmDrugPrice,slmDrugNumber,slmDrugTotlePrice,slmOtherOne,slmOtherTwo);
			//执行新增销售详情表
			sailListBiz.NewBuyListMessage(newBuyListMessage);
		}
		//清除session中的购物清单
		session.removeAttribute("buyList");
		//最后返回找零
		return payMoney-allPrice;
	}
	
	/**
	 * 
	 * @param page
	 * @param limit
	 * @return-Map<String,Object>
	 * @need:
	 * Description:
	 */
	@RequestMapping("/getAllSailChange.do")
	@ResponseBody
	public Map<String, Object> getAllSailChange(int page,int limit){
		//计算出当前页
		int page0=(page-1)*limit;
		//
		Map<String,Object> map=new HashMap<String,Object>();
		//放置当前页
		map.put("page", page0);
		//放置每页拿取的数据
		map.put("limit", limit);
		//定义一个集合
		List<SailList> list=new ArrayList<SailList>();
		//获取分页后的所有销售记录
		list=sailListBiz.getAllSailList(map);
		//判断总数据行数是否存在
		map.put("code", 0);
		map.put("data", list);
		map.put("count", list.size());
		//将所有的销售记录返回前台
		return map;
	}
	
	/**
	 * 
	 * @param sailId
	 * @return-Map<String,Object>
	 * @need:查询的销售单id
	 * Description:根据前台传输的销售单号查出所属的详情并返回给前台
	 */
	@RequestMapping("/findSailMessage.do")
	@ResponseBody
	public Map<String, Object> findSailMessage(String sailId){
		//定义转换i单号
		int salId=0;
		//定义回调集合
		List<SailMessage> list=new ArrayList<SailMessage>();
		//定义返回map集合
		Map<String ,Object> map=new HashMap<String ,Object>();
		//判断，是否为恶意空值
		if("".equals(sailId.trim())){
			//如果是，则赋予初始值
			salId=0000;
		}else{
			//如果不是，则进行转换
			salId=Integer.parseInt(sailId);
		}
		//调用biz层，获得结果集合
		list=sailListBiz.findSailMessage(salId);
		//map集合放值数据
		map.put("code", 0);
		map.put("data", list);
		map.put("count",0);
		//返回map
		return map;
	}
	
	
}
