package com.baidu.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 11:11
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("factoryApplication.xml");
        Car car2 = (Car) acx.getBean("car2");
        System.out.println(car2);
    }
}
