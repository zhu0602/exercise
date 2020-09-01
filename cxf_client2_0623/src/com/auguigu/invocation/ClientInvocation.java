package com.auguigu.invocation;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.auguigu.test.WeatherServiceImpl;

public class ClientInvocation {

	public static void main(String[] args) throws MalformedURLException {
		//1. 设置服务的地址(服务的wsdl地址)
	   URL url = new URL("http://localhost:8888/weather");
	   
	   //2. 设置服务名称和命名空间
	   //第一个参数是targetNamespace
	   //第二个参数是服务视图
	   QName qName = new QName("http://test.auguigu.com/","WeatherServiceImplService");
	   //3. 创建服务视图
	   Service service = Service.create(url,qName);
	   //4. 得到服务的实现类
	   WeatherServiceImpl weatherServiceImpl = service.getPort(WeatherServiceImpl.class);
	   
	   //5. 调用方法
	   String city = weatherServiceImpl.getCity("哈哈");
	   System.out.println(city);
	   
	 
	}
}
