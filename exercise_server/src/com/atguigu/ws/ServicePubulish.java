package com.atguigu.ws;

import javax.xml.ws.Endpoint;

import com.atguigu.serviceimpl.RegionServiceImpl;

public class ServicePubulish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7777/areas", new RegionServiceImpl());
		System.out.println("服务启动了");
	}
}
