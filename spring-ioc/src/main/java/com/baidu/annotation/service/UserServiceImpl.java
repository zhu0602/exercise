package com.baidu.annotation.service;

import com.baidu.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 16:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepositoryImpl")
    private UserRepository userRepository;


    public void add() {
        System.out.println("UserServiceImpl.....add");
        userRepository.save();
    }
}
