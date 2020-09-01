package com.atguigu.mybatis.dao;

import java.util.List;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapperDynamicSQL {

	public List<Employee> getEmpsByConditionTrim(Employee employee);
	
	public List<Employee> getEmpsByConditionChoose(Employee employee);
	
	public List<Employee> getEmpsByConditionForeach(List<Integer> list);
	
	public int updateEmp(Employee employee);
	
	public int addEmps(List<Employee> list);
}
