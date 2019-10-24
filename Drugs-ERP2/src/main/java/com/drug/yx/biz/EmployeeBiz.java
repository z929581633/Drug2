package com.drug.yx.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.drug.yx.entity.Employee;

@Repository
public interface EmployeeBiz {
	
	public List<Employee> getAllEmployee();
	
	public int delEmployee(Map<String ,Object> map);
	
}
