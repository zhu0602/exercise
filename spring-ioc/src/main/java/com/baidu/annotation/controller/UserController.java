package com.baidu.annotation.controller;

import com.baidu.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 16:17
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public  void  execute(){
        System.out.println("UserController...");
        userService.add();
    }
}
