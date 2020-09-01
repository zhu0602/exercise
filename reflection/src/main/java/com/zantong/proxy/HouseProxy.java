package com.zantong.proxy;

/**
 * @author ZhuGangGang
 * @Date 2020/3/5 14:37
 */
public class HouseProxy implements House {

    private House house;

    public HouseProxy(House house) {
        this.house = house;
    }

    @Override
    public void Home() {
        System.out.println("开始查看房源");
        house.Home();
        System.out.println("约定看房子");
    }
}
