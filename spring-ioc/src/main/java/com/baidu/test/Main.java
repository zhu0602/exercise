package com.baidu.test;

import com.baidu.cycle.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 20:46
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("cycleApplication.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
        applicationContext.close();
    }
}
