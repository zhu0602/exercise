package com.atguigu.mybatis.dao;

import org.apache.ibatis.annotations.Select;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeesMapperAnnotation {

	@Select("select * from tbl_employee where id=#{id}")
	public Employee getEmployeeById(Integer id);
	
}
