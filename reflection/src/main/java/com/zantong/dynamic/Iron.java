package com.zantong.dynamic;

/**
 * @author ZhuGangGang
 * @Date 2020/3/5 16:18
 */
public class Iron implements Human{
    @Override
    public String eat(String food) {
        System.out.println("钢铁侠吃"+food);
        return food;
    }

    @Override
    public void behavior() {
        System.out.println("钢铁侠打败坏蛋");
    }
}
