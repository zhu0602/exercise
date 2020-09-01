package com.baidu.annotation;

import com.baidu.annotation.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 16:31
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext acx = new ClassPathXmlApplicationContext("annotationApplication.xml");
        UserController userController = (UserController) acx.getBean("userController");
        userController.execute();
//        UserRepository userRepository = (UserRepository) acx.getBean("userRepository");
//        System.out.println(userRepository);
        //UserServiceImpl userService = (UserServiceImpl) acx.getBean("userService");
//        System.out.println(userService);
    }
}
