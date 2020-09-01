package com.baidu.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 20:21
 */
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> baseRepository;

    public void add(){
        System.out.println("add...");
        System.out.println("repository");
    }
}
