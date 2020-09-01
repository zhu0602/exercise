package com.atguigu.service.impl;

import javax.jws.WebService;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;

@WebService
public class UserServiceImpl  implements UserService{

	@Override
	public int addUser(User user) {
		System.out.println("user已成功添加到数据库中"+user);
		return 0;
	}

	
}
