package com.baidu.annotation.repository;

import com.baidu.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 17:40
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired(required = false)
    private TestObject testObject;

    public int save() {
        System.out.println("UserRepositoryImpl.....save");
        System.out.println("TestObject...");
        return 0;
    }
}
