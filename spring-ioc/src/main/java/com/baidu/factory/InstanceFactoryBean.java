package com.baidu.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例化工厂方法: 首先需要创建工产本身,才能拿到bean
 *
 * @author ZhuGangGang
 * @Date 2020/1/31 10:45
 */
public class InstanceFactoryBean {

    private  static Map<String, Car> cars;

    public InstanceFactoryBean() {
        cars=new HashMap<String, Car>();
        cars.put("audi", new Car("audi","20000"));
        cars.put("ford", new Car("ford","300000"));
    }

    public Car getCar(String name){
        return  cars.get(name);
    }
}
