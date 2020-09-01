package com.baidu.factory;

import java.util.HashMap;
import java.util.Map;

/**静态工厂方法
 * @author ZhuGangGang
 * @Date 2020/1/31 10:45
 */
public class StaticFactoryBean {

    private  static Map<String, Car> cars=new HashMap<String, Car>();
    static {
        cars.put("audi", new Car("audi","800000"));
        cars.put("ford", new Car("ford","900000"));
    }
    public static Car getCar(String brand){
        return cars.get(brand);
    }
}
