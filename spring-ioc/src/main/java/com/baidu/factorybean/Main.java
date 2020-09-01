package com.baidu.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 15:21
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext acx=new ClassPathXmlApplicationContext("factoryBeanApplication.xml");
        Car car = (Car) acx.getBean("car");
        System.out.println("car = " + car);
    }
}
