package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import com.atguigu.config.MainConfigOfPropertyValues;

public class IocTest_PropertyValue {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);
	ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("bean.xml");

	@Test
	public void testGetProperty() {
		Object bean = context.getBean("person2");
		ConfigurableEnvironment environment = context.getEnvironment();
		String value= environment.getProperty("person2.nkName");
		System.out.println(value);
		System.out.println(bean);
	}
	
	@Test
	public void testGetProperty2() {
		Object bean = context2.getBean("person2");
		System.out.println(bean);
	}
}
