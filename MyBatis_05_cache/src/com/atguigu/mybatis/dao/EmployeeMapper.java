package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	

	public Employee getEmployeeById(Integer id);
	
	public Integer addEmp(Employee employee);
}
