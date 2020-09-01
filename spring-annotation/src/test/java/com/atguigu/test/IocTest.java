package com.atguigu.test;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig2;

public class IocTest {
	AnnotationConfigApplicationContext context 
	= new AnnotationConfigApplicationContext(MainConfig2.class);

	@Test
	public void testIoc() {
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}

	@Test
	public void testCondition() {
		System.out.println("容器创建完成.....");
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
		Map<String, Person> map = context.getBeansOfType(Person.class);
		System.out.println(map);
		
	}
	
	
	@Test
	public void testImport() {
			printBeans(context);
			Object bean = context.getBean("myBeanFactory");
			System.out.println("bean的类型："+bean.getClass());
	
	}
	
	public void printBeans(AnnotationConfigApplicationContext context) {
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
