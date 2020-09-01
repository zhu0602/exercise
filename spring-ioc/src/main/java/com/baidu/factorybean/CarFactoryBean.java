package com.baidu.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author ZhuGangGang
 * @Date 2020/1/31 15:12
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car getObject() throws Exception {
        Car car = new Car(brand, "8000");
        return car;
    }



    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
