package com.atguigu.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;

@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	
   public  List<Employee>  getEmployee() {
	List<Employee> employees = employeeMapper.getEmployees();
	return employees;
 }

}
