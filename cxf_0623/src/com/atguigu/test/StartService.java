package com.atguigu.test;

import javax.xml.ws.Endpoint;

import com.auguigu.test.WeatherServiceImpl;

public class StartService {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9999/weather", new WeatherServiceImpl());
		System.out.println("服务启动了");
	}
}
