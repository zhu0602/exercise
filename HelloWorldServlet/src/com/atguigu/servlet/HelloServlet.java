package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet  implements Servlet{
	private ServletConfig servletConfig;

	 public HelloServlet() {
		System.out.println("构造器执行了");
	}
	
	@Override
	public void destroy() {
		System.out.println("destory....");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig=config;
		System.out.println("init...");
		//servletConfig配置参数
		System.out.println("InitParameter:"+servletConfig.getInitParameter("encode"));
		//上下文
		ServletContext context = servletConfig.getServletContext();
		System.out.println("servletContext:"+context);
		//服务名称
		System.out.println("servletName:"+servletConfig.getServletName());
		String ageParameter = context.getInitParameter("age");
		System.out.println("age:"+ageParameter);
		String realPath = context.getRealPath("login.html");
		System.out.println(realPath);
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("servlet ！！！");
	}

}
