package com.baidu.cycle;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 20:35
 */
public class Car {
    private String brand;

    public Car() {
        System.out.println("构造方法执行了");
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    private void  init(){
        System.out.println("init方法执行了......");
    }


    private void destroy(){
        System.out.println("destroy方法执行了");
    }
}
