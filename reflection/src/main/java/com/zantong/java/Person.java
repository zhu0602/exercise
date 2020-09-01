package com.zantong.java;

/**
 * @author ZhuGangGang
 * @Date 2020/2/7 13:18
 */
public class Person {
    private String name;
    public  String age;


    public Person() {
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String behavior(String move){
        System.out.println("我在"+move);
        return move;
    }

    public void feed(){
        System.out.println("一个人的脚");
    }
    @Override
    public String  toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
