package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.atguigu.bean.Person;
import com.atguigu.bean.Yellow;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.WindowsCondition;
import com.atguigu.facotry.MyBeanFactory;
import com.atguigu.register.MyImportBeanDefinitionRegistrar;
import com.atguigu.selector.MyImportSelector;

@Import({Yellow.class,MyBeanFactory.class,MyImportSelector.class,
	MyImportBeanDefinitionRegistrar.class})
@Configuration
@Conditional(value = {WindowsCondition.class})
public class MainConfig2 {

	/**scope是设置组件的作用域
	 prototype : 多实例:ioc容器启动不会调用方法创建对象
	  			 每次获取bean的时候才会去创建对象
	 singleton : 单实例（默认值）： ioc容器启动会调用方法创建对象
	 			 以后每次调用都是从容器中取
	 **/				
	//@Scope(value = "prototype")
	@Bean
	@Lazy
	public Person person() {
		System.out.println("person被实例化了。。。。。。。");
		 return new Person("詹姆斯",35);
	}
	
	@Bean
	@Lazy
	public Person person02() {
		System.out.println("person被实例化了。。。。。。。");
		 return new Person("bill gates",60);
	}
	  
	
	@Bean(value = "person01")
	@Lazy
	@Conditional(value = {LinuxCondition.class})
	public Person person01() {
		System.out.println("person被实例化了。。。。。。。");
		 return new Person("linus",50);
	}
	
	@Bean
	public MyBeanFactory myBeanFactory() {
		System.out.println("Color对象创建了.....");
		return new MyBeanFactory();
	}
	
}
