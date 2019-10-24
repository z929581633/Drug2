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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String strDate=sdf.format(date);
		map.put("empId", empId);
		map.put("outWorkTime", strDate);
		int back=employeebizImpl.delEmployee(map);
		return back;
	}
	
	
}
