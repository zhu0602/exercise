package com.atguigu.mybatis.bean;

import java.util.List;

public class Department {

	private Integer id;
	private String depName;
	private List<Employee> emps;
	
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", emps=" + emps + "]";
	}
	
}
