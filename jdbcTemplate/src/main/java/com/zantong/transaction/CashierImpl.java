package com.zantong.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/20 21:54
 */
public class CashierImpl implements Cashier {

    @Autowired
    private  BookShopServiceImpl bookShopService;

    //添加事务注解
    //使用propagation指定事务的传播行为,即当前的事务方法被另外的一个事务方法调用时
    //如何使用事务,默认取值为REQUIRED, 即用调用方法的事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    //REQUIRES_NEW:事务使用自己的事务,调用方法的事务被挂起
    public void checkout(String username, List<String> isbns) {
        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
