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


	@Override
	public int addEmployee(Employee newEmployee) {
		int back=employeeMapper.addEmployee(newEmployee);
		return back;
	}


	@Override
	public int changeEmployee(Employee newEmployee) {
		int back=employeeMapper.changeEmployee(newEmployee);
		return back;
	}


	@Override
	public List<Employee> getAllHistoryEmployee() {
		List<Employee> list=new ArrayList<Employee>();
		list=employeeMapper.getAllHistoryEmployee();
		return list;
	}


	@Override
	public List<Employee> findEmployeeById(String id) {
		List<Employee> list=new ArrayList<Employee>();
		list=employeeMapper.findEmployeeById(id);
		return list;
	}


	@Override
	public List<Employee> findEmployeeByName(String name) {
		List<Employee> list=new ArrayList<Employee>();
		list=employeeMapper.findEmployeeByName(name);
		return list;
	}
	
	
	
}
