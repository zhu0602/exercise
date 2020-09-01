package com.atguigu.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

	public Car() {
		System.out.println("car .. Construct....");
	}
	
	public void init() {
		System.out.println("car...init...方法执行了");
	}
	
	public  void destroy() {
		System.out.println("car...destroy...方法执行了");
	}
}
