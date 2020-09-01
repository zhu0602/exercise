package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Person;
import com.atguigu.dao.BookDao;
import com.atguigu.fileter.MyTypeFilter;
import com.atguigu.service.BookService;

//配置类的等于配置文件
@Configuration //告诉spring这是一个配置类
@ComponentScan(value = "com.atguigu",includeFilters = {
		/*
		 * @Filter(type =FilterType.ANNOTATION,classes = { Controller.class}),
		 * 
		 * @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = { BookDao.class })
		 */
		@Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
},useDefaultFilters = false)

// @ComponentScan value: 指定扫描的包
// excludeFilters= Filter[] : 指定扫描的时候按照什么规则派排除那些组件
// includeFilters= Filter[] :指定扫描的时候只包含什么规则的组件
// FilterType.ANNOTATION:按照注解
// FilterType.ASSIGNABLE_TYPE： 按照给定的类型
//FilterType.ASPECTJ:按照ASPECTJ表达式
//FilterType.REGEX: 按照正则表达式
//FilterType.CUSTOM: 使用自定义规则
public class MainConfig {

	//给容器中注册一个bean;类型是返回值的类型,默认是用方法名作为id
	@Bean(value = "person")
	public Person person() {
		return new Person("lisi",30);
	}
}
