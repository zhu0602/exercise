package com.baidu.spel;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:11
 */
public class Person {
    private String name;
    private String city;
    private String info;
    private Car car;

    public Person() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                ", car=" + car +
                '}';
    }
}
