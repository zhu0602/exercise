package com.baidu.relation;

import com.baidu.autowire.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:24
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("relationApplication.xml");
       // Address address1 = (Address) applicationContext.getBean("address");
       // System.out.println(address1);
      //  Address address2= (Address) applicationContext.getBean("address2");
       // System.out.println(address2);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
