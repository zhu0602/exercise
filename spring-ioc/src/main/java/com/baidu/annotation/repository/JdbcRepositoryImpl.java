package com.baidu.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 17:41
 */
@Repository
public class JdbcRepositoryImpl implements UserRepository {
    public int save() {
        System.out.println("JdbcRepositoryImpl....save");
        return 0;
    }
}
