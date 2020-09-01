package com.atguigu.invacation;

import com.auguigu.test.WeatherServiceImpl;
import com.auguigu.test.WeatherServiceImplService;

public class Demo {

	public static void main(String[] args) {
		//1. 创建服务视图
		WeatherServiceImplService weatherServiceImplService = new WeatherServiceImplService();
		//2. 得到服务的实现
		WeatherServiceImpl weatherServiceImpl = weatherServiceImplService.getPort(WeatherServiceImpl.class);
		//3.调用服务的接口
		String city = weatherServiceImpl.getCity("上海");
		System.out.println(city);
	}
}
