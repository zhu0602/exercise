package com.atguigu.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.atguigu.mybatis.bean.Employee;

public interface EmployeeMapper {
	
	//多条记录封装一个map：Map<Integer,Employee>:键是这条记录的主键，值是记录封装后的javaBean
	//@MapKey注解： 封装这个map的时候，使用哪个属性作为整个map的key
	@MapKey("id")
	public Map<String,Employee> getEmpByLastNameLikeReturnMap(String lastName);
	
   //返回一条记录的map key是列名，值就是对应的值 
    public Map<String, Object> getEmpByIdReturnMap(Integer id);

	public Employee getEmployeeById(Integer id);
	
	public Employee getEmployeeByIdAndLastName(@Param("id")Integer id,@Param("lastName")String lastName);

	public Employee getEmpByMap(Map<String,String> map);
	
	public Employee getEmpByE(Map<String,String> map);

	public Integer addEmp(Employee employee);
	
	public List<Employee>  getEmps(List<Integer> list);
	
}
