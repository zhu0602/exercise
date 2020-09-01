package com.atguigu.mybatis.test;

public enum EmpStatus {

	LOGIN("300","用户登录"),
	LOGOUT("400","用户登出"),
	REMOVE("500","用户删除");
	
	private String code;
	private String msg;
	
	
	EmpStatus(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
