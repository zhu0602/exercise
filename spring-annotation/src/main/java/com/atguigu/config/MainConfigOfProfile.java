package com.atguigu.config;


import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@PropertySource(value = "classpath:/datasource.properties")
@Component
public class MainConfigOfProfile {

	@Value("${db.username}")
	private String username;
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource testDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(username);
		dataSource.setPassword("${db.password}");
		dataSource.setDriverClass("${db.driver}");
		dataSource.setJdbcUrl("${db.url}");
		return dataSource;
	}
	
	@Profile("dev")
	@Bean("devDataSource")
	public DataSource devDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(username);
		dataSource.setPassword("${db.password}");
		dataSource.setDriverClass("${db.driver}");
		dataSource.setJdbcUrl("${db.url}");
		return dataSource;
	}
	
	@Profile("pro")
	@Bean("prodDataSource")
	public DataSource prodDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(username);
		dataSource.setPassword("${db.password}");
		dataSource.setDriverClass("${db.driver}");
		dataSource.setJdbcUrl("${db.url}");
		return dataSource;
	}
}
