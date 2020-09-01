package com.zantong.proxy;

import sun.applet.Main;

/**
 * @author ZhuGangGang
 * @Date 2020/3/3 16:21
 */
public class StaticProxTest {
    public static void main(String[] args) {
        //被代理类
        XiaoMing xiaoMing = new XiaoMing();
        //代理类
        HouseProxy proxy = new HouseProxy(xiaoMing);
        proxy.Home();
    }
}
