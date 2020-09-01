package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.atguigu.dao.BookDao;

@Configuration
@Component
@ComponentScan(value = { "com.atguigu.dao", "com.atguigu.service","com.atguigu.bean"})
public class MainConfigOfAutowire {


	@Bean
	public BookDao bookDao2() {
		BookDao bookDao = new BookDao();
		bookDao.setNumber("2");
		return bookDao;
	}

}
