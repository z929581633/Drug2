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

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeBizImpl employeebizImpl;
	
	@RequestMapping("/getEmployee.do")
	@ResponseBody
	public Map<String, Object> getEmployee(int page){
		//
		Map<String ,Object> map=new HashMap<String ,Object>();
		//从数据库查询的全部店员信息
		List<Employee> list=new ArrayList<Employee>();
		//要返回前台的分页信息
		List<Employee> list0=new ArrayList<Employee>();
		//获得全部店员信息
		list=employeebizImpl.getAllEmployee();
		for(int i=((page-1)*10);i<=((page*10)-1);i++){
			if(i==list.size()){
				break;
			}
			Integer empId=list.get(i).getEmpId();
			String empName=list.get(i).getEmpName();
			String empSex=list.get(i).getEmpSex();
			Integer empAge=list.get(i).getEmpAge();
			String empUser=list.get(i).getEmpUser();
			String empPassword=list.get(i).getEmpPassword();
			String empWork=list.get(i).getEmpWork();
			String inWorkTime=list.get(i).getInWorkTime();
			String outWorkTime=list.get(i).getOutWorkTime();
			list0.add(new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime));
		}
		map.put("code", 0);
		map.put("count", list.size()); 
		map.put("data", list0);
		return map;
	}
	
	@RequestMapping("/delEmployee.do")
	@ResponseBody
	public int delEmployee(int empId){
		Map<String,Object> map=new HashMap<String,Object>();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String strDate=sdf.format(date);
		map.put("empId", empId);
		map.put("outWorkTime", strDate);
		int back=employeebizImpl.delEmployee(map);
		return back;
	}
	
	
	@RequestMapping("/newEmployee.do")
	@ResponseBody
	public int newEmployee(Employee employee){
		Integer empId=employee.getEmpId();
		String empName=employee.getEmpName();
		String empSex=employee.getEmpSex();
		Integer empAge=employee.getEmpAge();
		String empUser=employee.getEmpUser();
		String empPassword=employee.getEmpPassword();
		String empWork=employee.getEmpWork();
		String inWorkTime=employee.getInWorkTime();
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
		//职位
		if("".equals(empWork.trim())){
			empWork="店员";
		}
		//将新增的员工信息添加至数据库中
		Employee newEmployee=new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime);
		int back=employeebizImpl.addEmployee(newEmployee);
		return back;
	}
	
	@RequestMapping("/changeEmployee.do")
	@ResponseBody
	public int changeEmployee(Employee employee){
		Integer empId=employee.getEmpId();
		String empName=employee.getEmpName();
		String empSex=employee.getEmpSex();
		Integer empAge=employee.getEmpAge();
		String empUser=employee.getEmpUser();
		String empPassword=employee.getEmpPassword();
		String empWork=employee.getEmpWork();
		String inWorkTime=employee.getInWorkTime();
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
		//职位
		if("".equals(empWork.trim())){
			empWork="店员";
		}
		//将新的员工对象添加至实体类
		Employee newEmployee=new Employee(empId,empName,empSex,empAge,empUser,empPassword,empWork,inWorkTime,outWorkTime);
		int back=employeebizImpl.changeEmployee(newEmployee);
		return back;
	}
	
	
}
