package com.atguigu.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;


public class HelloWorldClientTest {

	public static void main(String[] args) {
		JaxWsProxyFactoryBean proxy=new JaxWsProxyFactoryBean();
		proxy.setAddress("http://localhost:8888/cxf1022_server");
		proxy.setServiceClass(HelloWorld.class);
		HelloWorld helloWorld=(HelloWorld)proxy.create();
		String result= helloWorld.sayHello("王五", 90);
		System.out.println(result);
	}
}
