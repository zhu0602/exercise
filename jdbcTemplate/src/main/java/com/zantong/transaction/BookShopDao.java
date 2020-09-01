package com.zantong.transaction;

/**
 * @author ZhuGangGang
 * @Date 2020/3/17 22:29
 */
public interface BookShopDao {
    //根据书号获取书的单价
    public  int findBookPriceByIsbn(String isbn);

    //更新数的库存  使书号对应的库存-1
    public void updateBookStock(String isbn);

    //更新用户的账户余额: 使userName的blance-price
    public void updateUserAccount(String userName,int price);



}
