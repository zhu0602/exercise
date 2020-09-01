package com.atguigu.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.bean.Man;
import com.atguigu.bean.Red;
import com.atguigu.config.MainConfigOfAutowire;

public class IocTest_Autowire {

	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
	@Test
	public void testAutowire() {
		Object bean = context.getBean("bookService");
		System.out.println(bean.toString());
	}
	
	@Test
	public void testAutowire2() {
	    Man bean = context.getBean(Man.class);
		System.out.println(bean);
	}
	
	@Test
	public void testAutowire3() {
	    Red bean = context.getBean(Red.class);
		System.out.println(bean);
	}
	
}
