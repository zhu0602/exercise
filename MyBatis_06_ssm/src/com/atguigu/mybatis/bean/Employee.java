package com.atguigu.mybatis.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer dId;
	private String lastName;
	private String email;
	private String gender;
	
	public Employee() {
		super();
	}
	public Employee(Integer id, Integer dId, String lastName, String email, String gender) {
		super();
		this.id = id;
		this.dId = dId;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dId=" + dId + ", lastName=" + lastName + ", email=" + email + ", gender="
				+ gender + "]";
	}


}
