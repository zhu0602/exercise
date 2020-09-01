package com.atguigu.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	

	public List<Employee> getEmployees();
	
}
