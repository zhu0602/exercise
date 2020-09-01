package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.atguigu.bean.Person2;


@Configuration
@Component
//使用@PropertySource来获取配置文件以key/val形式保存到环境变量中
@PropertySource(value = "classpath:/person.properties")
public class MainConfigOfPropertyValues {


	@Bean
	public Person2 person2() {
		return new Person2();
	}
	
}
