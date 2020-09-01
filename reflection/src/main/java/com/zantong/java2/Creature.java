package com.zantong.java2;

import java.io.Serializable;

/**
 * @author ZhuGangGang
 * @Date 2020/2/13 9:33
 */
@MyAnnotation
public class Creature<T>  implements Serializable {
    private String name;
    public int age;

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

    public Creature() {
    }

    public Creature(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
