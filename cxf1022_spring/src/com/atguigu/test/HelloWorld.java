package com.atguigu.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface HelloWorld {

	@WebResult(name = "retValue")
	@WebMethod
	public String sayHello(@WebParam(name = "userName")String name,@WebParam(name = "userAge")int age);
	
}

