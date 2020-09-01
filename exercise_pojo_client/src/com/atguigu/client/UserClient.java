package com.atguigu.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.atguigu.service.impl.User;
import com.atguigu.service.impl.UserServiceImpl;

public class UserClient {

	public static void main(String[] args) {
		try {
			// 设置服务请求的地址
			URL url = new URL("http://localhost:5555/user?wsdl");
			// 设置nameSpace和服务名称
			QName qName = new QName("http://impl.service.atguigu.com/", "UserServiceImplService");
			// 创建服务视图
			Service service = Service.create(url, qName);
			//获取服务的实现类
			UserServiceImpl userServiceImpl = service.getPort(UserServiceImpl.class);
			User user = new User();
			user.setId(20);
			user.setName("朱刚刚");
			user.setIsAdmin(true);
			user.setBirthday(new Date());
			//调用服务
			userServiceImpl.addUser(user);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
