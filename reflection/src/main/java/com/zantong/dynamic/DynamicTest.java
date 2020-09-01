package com.zantong.dynamic;

/**
 * @author ZhuGangGang
 * @Date 2020/3/5 17:39
 */
public class DynamicTest {

    public static void main(String[] args) {
        //被代理类对象
        Iron iron = new Iron();
        Human proxy = (Human) DynamicProxyFacotry.getProxyInstance(iron);
        String eat = proxy.eat("rice");
        System.out.println(eat);
    }
}
