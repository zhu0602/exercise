package com.atguigu.test;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class MainServer {
  
	public static void main(String[] args) {
		
		JaxWsServerFactoryBean jaxWsServerFactoryBean=new JaxWsServerFactoryBean();
		jaxWsServerFactoryBean.setAddress("http://localhost:9999/cxf1022_server");
		jaxWsServerFactoryBean.setServiceClass(HelloWorldServiceImpl.class); 
		
		Server server = jaxWsServerFactoryBean.create();
		
		server.start();
	}
	
}
