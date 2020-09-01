package com.baidu.generic.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 20:28
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("genericApplication.xml");
        UserService service = (UserService) acx.getBean("userService");
        service.add();
    }
}
