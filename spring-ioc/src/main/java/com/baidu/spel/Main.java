package com.baidu.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:24
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spelApplication.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
