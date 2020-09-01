package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.atguigu.bean.Car;
import com.atguigu.bean.Girl;
import com.atguigu.bean.Man;

@Configuration //声明是一个配置类
@ComponentScan("com.atguigu.bean")
public class MainConfigOfLifeCycle {

	@Bean(initMethod = "init",destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
	
}
