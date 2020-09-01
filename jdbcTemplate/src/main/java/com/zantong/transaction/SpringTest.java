package com.zantong.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/20 20:01
 */
public class SpringTest {

    private BookShopImpl bookShopDao=null;
    private ApplicationContext act=null;
    private BookShopServiceImpl bookShopService=null;
  /*
    private CashierImpl cashier=null;*/
    {
         act=new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao= (BookShopImpl) act.getBean("bookShipImpl");
        bookShopService= (BookShopServiceImpl) act.getBean("bookShopServiceImpl");
       /*
        cashier= (CashierImpl) act.getBean("cashierImpl");*/
    }
   /* @Test
    public void  testTransactionPropagation(){
        cashier.checkout("AA", Arrays.asList("1001","1002"));

    }

    @Test
    public void test5(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("1001");
        list.add("1002");
        cashier.checkout("AA", list);
    }

    */

    @Test
    public void test4(){
        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void test1(){
        int price = bookShopDao.findBookPriceByIsbn("1001");
        System.out.println(price);
    }

    @Test
    public void test2(){
        bookShopDao.updateBookStock("1001");
    }

    @Test
    public void test3(){
        bookShopDao.updateUserAccount("AA",100);
    }
}
