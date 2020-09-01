package com.atguigu.test;

public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String name, int age) {
		
		return "cxf 1022 hello:"+name+"\t"+age;
	}

}
