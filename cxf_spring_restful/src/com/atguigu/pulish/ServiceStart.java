package com.atguigu.pulish;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.atguigu.bean.Student;
import com.atguigu.service.impl.UserServiceImpl;

public class ServiceStart {
	
	public static void main(String[] args) {
		// 1.使用JAXRSS发布WebService
				JAXRSServerFactoryBean jaxrsServerFactoryBean = new JAXRSServerFactoryBean();

				// 2.设置服务的地址
				jaxrsServerFactoryBean.setAddress("http://localhost:8080/studentServie");

				// 3.设置服务实现类
				jaxrsServerFactoryBean.setServiceBean(new UserServiceImpl());

				// 4.设置资源对象,如果有多个资源类，可以以“,”隔开。
				jaxrsServerFactoryBean.setResourceClasses(Student.class);

				// 5.发布
				jaxrsServerFactoryBean.create();

				System.out.println("发布成功");

	}
}
