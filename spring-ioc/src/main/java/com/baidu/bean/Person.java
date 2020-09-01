package com.baidu.bean;

import com.baidu.Car;

import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/1/29 15:03
 */
public class Person {
    private String name;
    private int age;
    private List<Car> car;

    public Person() {
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

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }

    public Person(String name, int age, List<Car> car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
