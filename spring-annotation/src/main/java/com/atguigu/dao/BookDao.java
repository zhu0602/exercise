package com.atguigu.dao;

import org.springframework.stereotype.Repository;

//@Repository
public class BookDao {


	private  String number="1";

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "BookDao [number=" + number + "]";
	}
	
	
}
