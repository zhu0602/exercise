package com.atguigu.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Man implements InitializingBean, DisposableBean {

	public Car car;

	//@Autowired
	public Man(Car car) {
		this.car = car;
		System.out.println("Man对象的有参构造器初始化。。。。。。");
	}

	public Car getCar() {
		return car;
	}

	// @Autowired
	public void setCar(Car car) {
		this.car = car;
	}

	public void destroy() throws Exception {
		System.out.println("Man....destory方法执行了");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Man....init方法执行了");
	}

	@Override
	public String toString() {
		return "Man [car=" + car + "]";
	}

}
