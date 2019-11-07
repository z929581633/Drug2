package com.drug.yx.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.yx.entity.Employee;

@Repository
public interface EmployeeBiz {
	
	//查询所有员工
	public List<Employee> getAllEmployee();
	
	//删除某位员工
	public int delEmployee(Map<String ,Object> map);
	
	//新增一位员工
	public int addEmployee(Employee newEmployee);
	
	//修改某位员工信息
	public int changeEmployee(Employee newEmployee);
	
	//获取所有离职员工数据
	public List<Employee> getAllHistoryEmployee();
	
	//根据员工号查询某位离职员工
	public List<Employee> findEmployeeById(String id);
	
	//根据员工姓名查询某位离职员工
	public List<Employee> findEmployeeByName(String name);
}
