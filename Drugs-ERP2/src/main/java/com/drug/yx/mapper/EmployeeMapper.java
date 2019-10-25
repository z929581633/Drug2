package com.drug.yx.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.yx.entity.Employee;

@Repository
public interface EmployeeMapper {
	
	//查询所有店员信息
	public List<Employee> getAllEmployee();
	
	//删除某位店员
	public int delEmployee(Map<String ,Object> map);
	
	
	//新增一位店员
	public int addEmployee(Employee newEmployee);
	
	//修改员工的信息
	public int changeEmployee(Employee newEmployee);
}
