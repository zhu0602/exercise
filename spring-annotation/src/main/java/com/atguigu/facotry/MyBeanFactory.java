package com.atguigu.facotry;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.bean.Color;

public class MyBeanFactory implements FactoryBean<Color> {


	/**
	 * 返回一个Color对象，这个对象会添加到容器中
	 */
	public Color getObject() throws Exception {
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	//true ： 这个bean是单实例
	//false： 多实例，每次获取都会创建一个新的实例
	public boolean isSingleton() {
		return true;
	}



}
