package com.baidu.test;

import com.baidu.Person;
import com.baidu.bean.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/29 15:11
 */
public class SpringTest {
    public static void main(String[] args) {
        //创建springioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Person person = (Person) applicationContext.getBean("person3");
        Database database = (Database) applicationContext.getBean("database");
        //System.out.println(person);
        System.out.println(database);
    }
}
