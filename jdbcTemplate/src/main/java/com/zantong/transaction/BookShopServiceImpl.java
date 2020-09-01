package com.zantong.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ZhuGangGang
 * @Date 2020/3/20 20:29
 */
@Component("bookShopServiceImpl")
public class BookShopServiceImpl implements BookShopService{

    @Autowired
    private BookShopImpl bookShop;

    //使用isolation指定事务的隔离级别,最常用的取值为READ_COMMITTED
    //默认情况下Spring的声明式事务对所有的运行时异常进行回滚,也可以公国对应进行调整
    //属性进行设置,通常情况下午默认即可
    //使用readOnly指定事务是否为只读,表示这个事务只读取数据但不更新数据
    //使用timeout 指定强制回滚之前事务可以占用的时间
    @Transactional
    public void purchase(String userName, String isbn) {
        //查看单价
        int price = bookShop.findBookPriceByIsbn(isbn);
        //库存减一
        bookShop.updateBookStock(isbn);
        //账户减一
        bookShop.updateUserAccount(userName, price);
    }
}
