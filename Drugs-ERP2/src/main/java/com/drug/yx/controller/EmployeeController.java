package com.drug.yx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drug.yx.bizImpl.EmployeeBizImpl;
import com.drug.yx.entity.Employee;
/**
 * 
 * @author 杨旭
 * @dataTime:2019年11月7日下午3:39:27
 * Description:员工基本权限
 */
@Controller
public class EmployeeController {
	//自动注入biz实现层
	@Autowired
	private EmployeeBizImpl employeebizImpl;
	/**
	 * 
	 * @param page-当前页码
	 * @return-Map<String,Object>
	 * @need:当前页
	 * Description:根据前台页面传输过来的页面信息进行分页
	 */
	@RequestMapping("/getEmployee.do")
	@ResponseBody
	public Map<String, Object> getEmployee(int page){
		//定义回调数据格式
		Map<String ,Object> map=new HashMap<String ,Object>();
		//从数据库查询的全部店员信息
		List<Employee> list=new ArrayList<Employee>();
		//要返回前台的分页信息
		List<Employee> list0=new ArrayList<Employee>();
		//获得全部店员信息
		list=employeebizImpl.getAllEmployee();
		//循环分页
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			//如果到达下标上限，则跳出
			if(i==list.size()){
				break;
			}
			//获得员工id
			Integer empId=list.get(i).getEmpId();
			//获得员工名
			String empName=list.get(i).getEmpName();
			//获得员工姓名
			String empSex=list.get(i).getEmpSex();
			//获得员工年龄
			Integer empAge=list.get(i).getEmpAge();
			//获得员工账号
			String empUser=list.get(i).getEmpUser();
			//获得账号密码
			String empPassword=list.get(i).getEmpPassword();
			//获得员工职位
			String empWork=list.get(i).getEmpWork();
			//获得入职时间
			String inWorkTime=list.get(i).getInWorkTime();
			//获得离职时间
			String outWorkTime=list.get(i).getOutWorkTime();
			//将获得的数据封装进员工集合
			list0.add(new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime));
		}
		//放置map格式
		map.put("code", 0);
		//总数据为所有员工
		map.put("count", list.size()); 
		//返回数据为分页后的员工数据
		map.put("data", list0);
		
		return map;
	}
	
	/**
	 * 
	 * @param empId-员工号
	 * @return-Integer
	 * @need:员工号
	 * Description:根据前台页面传输过来的员工号，删除该员工
	 */
	@RequestMapping("/delEmployee.do")
	@ResponseBody
	public Integer delEmployee(int empId){
		//预创建map集合，用于传输回前台页面
		Map<String,Object> map=new HashMap<String,Object>();
		//新建时间格式
		Date date=new Date();
		//格式化时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//转时间类型
		String strDate=sdf.format(date);
		//放入员工号
		map.put("empId", empId);
		//放入离职时间
		map.put("outWorkTime", strDate);
		//执行删除操作
		int back=employeebizImpl.delEmployee(map);
		//回调结果
		return back;
	}
	
	/**
	 * 
	 * @param employee-员工对象
	 * @return-int
	 * @need:员工对象
	 * Description:新员工入职时，
	 */
	@RequestMapping("/newEmployee.do")
	@ResponseBody
	public int newEmployee(Employee employee){
		//取出员工号
		Integer empId=employee.getEmpId();
		//取出员工姓名
		String empName=employee.getEmpName();
		//取出员工性别
		String empSex=employee.getEmpSex();
		//取出员工年龄
		Integer empAge=employee.getEmpAge();
		//语出员工账号
		String empUser=employee.getEmpUser();
		//取出账号密码
		String empPassword=employee.getEmpPassword();
		//取出员工职位
		String empWork=employee.getEmpWork();
		//取出入职时间
		String inWorkTime=employee.getInWorkTime();
		//取出离职时间
		String outWorkTime=employee.getOutWorkTime();
		//检查必填项，包括:姓名、年龄、账号
		if("".equals(empName.trim())||"".equals(empAge)||"".equals(empUser.trim())){
			return 2;
		}
		//设置选填项，包括:性别、账号密码、入职时间、职位
		//性别、默认女
		if("".equals(empSex.trim())){
			empSex="女";
		}
		//账号密码、默认0000000
		if("".equals(empPassword.trim())){
			empPassword="000000";
		}
		//入职时间、默认系统当前时间
		if("".equals(inWorkTime.trim())){
			//新建时间对象
			Date date=new Date();
			//格式化时间
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//转时间类型
			String strDate=sdf.format(date);
			//入职时间就是系统当前时间
			inWorkTime=strDate;
		}
		//职位、默认一般店员
		if("".equals(empWork.trim())){
			empWork="店员";
		}
		//将新增的员工信息添加至数据库中
		Employee newEmployee=new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime);
		//执行
		int back=employeebizImpl.addEmployee(newEmployee);
		
		return back;
	}
	/**
	 * 
	 * @param employee-员工对象
	 * @return-int
	 * @need:更新过的员工对象
	 * Description:根据修改过的员工信息更新数据库中的员工信息
	 */
	@RequestMapping("/changeEmployee.do")
	@ResponseBody
	public int changeEmployee(Employee employee){
		//判断前台的员工对象是否为空
		if(employee==null){
			//为空，返回错误结果
			return 0;
		}
		//获取员工号
		Integer empId=employee.getEmpId();
		//获取员工姓名
		String empName=employee.getEmpName();
		//获取员工性别
		String empSex=employee.getEmpSex();
		//获取员工年龄
		Integer empAge=employee.getEmpAge();
		//获取员工账号
		String empUser=employee.getEmpUser();
		//获取员工密码
		String empPassword=employee.getEmpPassword();
		//获取员工职位
		String empWork=employee.getEmpWork();
		//获取入职时间
		String inWorkTime=employee.getInWorkTime();
		//获取离职时间
		String outWorkTime=employee.getOutWorkTime();
		//检查必填项，包括:姓名、年龄、账号
		if("".equals(empName.trim())||"".equals(empAge)||"".equals(empUser.trim())){
			return 2;
		}
		//设置选填项，包括:性别、账号密码、入职时间、职位
		//性别
		if("".equals(empSex.trim())){
			empSex="女";
		}
		//账号密码
		if("".equals(empPassword.trim())){
			empPassword="000000";
		}
		//入职时间
		if("".equals(inWorkTime.trim())){
			//新建时间对象
			Date date=new Date();
			//格式化时间
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			//
			String strDate=sdf.format(date);
			inWorkTime=strDate;
		}
		//职位,默认一般店员
		if("".equals(empWork.trim())){
			empWork="店员";
		}
		//将新的员工对象添加至实体类
		Employee newEmployee=new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime);
		//执行操作，获取结果
		int back=employeebizImpl.changeEmployee(newEmployee);
		//将结果返回
		return back;
	}
	
	/**
	 * 
	 * @param id-员工号
	 * @param name-员工姓名
	 * @param page-当前页码
	 * @return-Map<String,Object>
	 * @need:查询id、查询姓名、当前页码
	 * Description:根据前端页面传输过来的数据，判断是根据那种方法查询对应的离职员工
	 */
	@RequestMapping("/getHistoryEmployee.do")
	@ResponseBody
	public Map<String, Object> getHistoryEmployee(String id,String name,int page){
		//定义接收所有历史员工集合
		List<Employee> list=new ArrayList<Employee>();
		//定义分页后的历史员工集合
		List<Employee> list0=new ArrayList<Employee>();
		//如果查询框的值都为空
		if(id==null&&name==null||"".equals(id.trim())&&"".equals(name.trim())){
			//进入全查
			list=employeebizImpl.getAllHistoryEmployee();
		//如果查询员工号不为空
		}else if("".equals(name.trim())){
			//进入根据员工号查询
			list=employeebizImpl.findEmployeeById(id);
		//如果查询姓名不为空	
		}else if("".equals(id.trim())){
			//进入员工姓名查询
			list=employeebizImpl.findEmployeeByName(name);
		}
		//开始根据查询的结果进行分页操作
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			//如果到达下标上限，则跳出
			if(i==list.size()){
				break;
			}
			//获得员工id
			Integer empId=list.get(i).getEmpId();
			//获得员工名
			String empName=list.get(i).getEmpName();
			//获得员工姓名
			String empSex=list.get(i).getEmpSex();
			//获得员工年龄
			Integer empAge=list.get(i).getEmpAge();
			//获得员工账号
			String empUser=list.get(i).getEmpUser();
			//获得账号密码
			String empPassword=list.get(i).getEmpPassword();
			//获得员工职位
			String empWork=list.get(i).getEmpWork();
			//获得入职时间
			String inWorkTime=list.get(i).getInWorkTime();
			//获得离职时间
			String outWorkTime=list.get(i).getOutWorkTime();
			//将获得的数据封装进员工集合
			list0.add(new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime));
		}
		//创建回调map集合
		Map<String ,Object> map=new HashMap<String ,Object>();
		//放置code值
		map.put("code", 0);
		//放置数据
		map.put("data", list0);
		//放置总行数数据
		map.put("count", list.size());
		//返回结果
		return map;
	}
	
}
