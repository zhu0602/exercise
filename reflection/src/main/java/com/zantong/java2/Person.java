package com.zantong.java2;

import java.rmi.NotBoundException;
import java.util.Objects;

/**
 * @author ZhuGangGang
 * @Date 2020/2/13 9:31
 */
@MyAnnotation(value = "person")
public class Person  extends Creature<String> implements MyInterface,Comparable<String>{

    private String name;
    int age;
    public String gender;

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public Person() {
    }

    @MyAnnotation(value = "constructor")
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    @MyAnnotation
    public String nation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    private String display(String name,int age) throws ClassCastException, NotBoundException {
        System.out.println("我想展示的是"+name);
        return name+age;
    }

    void show(){
        System.out.println("show.....");
    }
    @Override
    public void info() {
        System.out.println("info........");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
