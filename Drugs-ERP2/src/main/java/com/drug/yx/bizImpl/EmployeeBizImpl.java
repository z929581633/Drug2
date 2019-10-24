package com.drug.yx.bizImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.yx.biz.EmployeeBiz;
import com.drug.yx.entity.Employee;
import com.drug.yx.mapper.EmployeeMapper;

@Service
public class EmployeeBizImpl implements EmployeeBiz{

	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		list=employeeMapper.getAllEmployee();
		return list;
	}


	@Override
	public int delEmployee(Map<String, Object> map) {
		int back=employeeMapper.delEmployee(map);
		return back;
	}
	
	
	
}
