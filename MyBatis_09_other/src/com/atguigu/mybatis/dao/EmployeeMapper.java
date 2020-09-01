package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	public Integer addEmp(Employee employee);
	
	public List<Employee> getEmps();
	
	
	public Employee getEmpById(Integer id);
}
