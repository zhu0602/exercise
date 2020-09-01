package com.baidu.socpe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:24
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("scopeApplication.xml");
        Car car = (Car) applicationContext.getBean("car");
        Car car1 = (Car) applicationContext.getBean("car");
        System.out.println(car==car1);
    }
}
