package com.atguigu.pulish;

import javax.xml.ws.Endpoint;

import com.atguigu.service.impl.UserServiceImpl;

public class UserServerPulish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5555/user",new UserServiceImpl());
		System.out.println("服务起来了");
	}
}
