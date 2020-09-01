package com.zantong.proxy;

/**
 * @author ZhuGangGang
 * @Date 2020/3/3 16:22
 */
//被代理类
public class XiaoMing  implements House{

    @Override
    public void Home() {
        System.out.println("开始找房子了");
    }
}
