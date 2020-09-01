package com.zantong.transaction;

import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/20 21:53
 */
public interface Cashier {

    public void checkout(String username, List<String> isbns);

}
