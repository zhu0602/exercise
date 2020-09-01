package com.baidu;

import java.util.Map;

/**
 * @author ZhuGangGang
 * @Date 2020/1/29 15:03
 */
public class Person {
    private String name;
    private int age;
    private Map<String, Car> cars;


    public Person() {
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
