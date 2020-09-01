package com.auguigu.test;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;


//加了该注解可以发布成一个服务
@WebService(
		//该名称被用作 wsdl:portType 的名称。
		name = "WeatherServiceImpl2",
		//WebService的端口的名称，此名称被用作 wsdl:port 的名称。 
		portName = "WeatherServiceImplPort",
		//Web Service 的服务名称。此名称被用作 wsdl:service 的名称。
		serviceName = "WeatherService",
		//targetNamespace 用于 wsdl:portType（以及关联的 XML 元素）的名称空间
		targetNamespace = "http://com.baidu",
		//用于使用服务端点接口来确定抽象 WSDL 协定，将UserService接口对象不暴露给webService服务中
		endpointInterface = "com.auguigu.test.WeatherService"
		)
public class WeatherServiceImpl implements WeatherService,UserService {

	@Override
	public String getCity(String name) {
		if ("上海".equals(name)) {
			System.out.println(name+"是晴天26摄氏度");
			return name;
		}else if ("北京".equals(name)) {
			System.out.println(name+"是雨天12摄氏度");
			return name;
		}
		return "查询不到该城市的天气";
	}

	@WebMethod(exclude =true)
	public void delete() {
		
	}
	
	@Override
	public List<String> getUsers() {
		return null;
	}

}
