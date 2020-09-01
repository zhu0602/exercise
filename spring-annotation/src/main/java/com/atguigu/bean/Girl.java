package com.atguigu.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Girl {

	public Girl() {
		System.out.println("Girl...Construct");
	}
	//对象创建并赋值之后
	@PostConstruct
	public void init() {
		System.out.println("Girl...Init...");
	}
	//容器移除对象之前，会调用这个方法
	@PreDestroy
	public void destroy() {
		System.out.println("Girl...Destroy...");
	}
}
