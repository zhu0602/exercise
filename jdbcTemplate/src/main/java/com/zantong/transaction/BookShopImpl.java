package com.zantong.transaction;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/17 22:34
 */
@Component("bookShipImpl")
public class BookShopImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //获取书的单价
    public int findBookPriceByIsbn(String isbn) {
        String sql= "select price from book where isbn=?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        return price;
    }

    //修改库存
    public void updateBookStock(String isbn) {
        String sql="select stock from book_stock where isbn=?";
        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        if (stock<1){
            throw  new RuntimeException("库存不足");
        }
        String sql2="update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql2, isbn);
    }

    //更新账户
    public void updateUserAccount(String userName, int price) {
        String sql="select balance from account where username=?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, userName);
        if (balance-price<0){
            throw  new RuntimeException("余额不足");
        }
        String sql2 = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql2, price,userName);
    }
}
