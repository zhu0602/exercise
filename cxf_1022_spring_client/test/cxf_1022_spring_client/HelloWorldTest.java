package cxf_1022_spring_client;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.test.HelloWorld;
import com.atguigu.test.HelloWorldImplService;

public class HelloWorldTest {

	@Test
	public void test() {

     //初始化容器
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		HelloWorld helloWorld = context.getBean("helloWorldServiceProxy",HelloWorld.class);
		String result = helloWorld.sayHello("朱刚刚", 12);
		System.out.println(result);
	}

}
