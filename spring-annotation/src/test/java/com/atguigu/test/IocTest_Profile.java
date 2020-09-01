package com.atguigu.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.atguigu.config.MainConfigOfProfile;

public class IocTest_Profile {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

	//通过命令行的方式实现，根据当前环境，动态的实现一系列组件的 切换
	@Test
	public void testProfile() {
		String[] beans = context.getBeanNamesForType(DataSource.class);
		for (String bean : beans) {
			System.out.println(bean);
		}
	}
	
	//通过编程的方式实现profile的激活 
	@Test
	public void testProfile2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev","pro");
		context.register(MainConfigOfProfile.class);
		context.refresh();
		String[] beans = context.getBeanNamesForType(DataSource.class);
		for (String bean : beans) {
			System.out.println(bean);
		}
	}
}
