package com.zantong.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/2/7 13:22
 */
public class ReflectionTest {

    @Test
    public void test1() {
        Person person = new Person("Tom", "20");
        person.getClass();
        person.age = "10";
        person.setName("Jack");
        person.feed();
        System.out.println(person);
    }

    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        //通过反射创建对象
        Constructor cons = clazz.getConstructor(String.class, String.class);
        //通过反射,来创建对象
        Object joanna = cons.newInstance("Joanna", "23");
        System.out.println(joanna.toString());
        Person person = (Person) joanna;
        //通过反射来对象属性和方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(joanna, "20");
        System.out.println(joanna.toString());
        //调用方法
        Method feed = clazz.getDeclaredMethod("feed");
        System.out.println(feed.invoke(joanna));

        System.out.println("**********************");

        //通过反射可以获取到私有构造器; 比如私有构造器,方法,属性
        Constructor cons2 = clazz.getDeclaredConstructor(String.class);
        cons2.setAccessible(true);
        Person rose = (Person) cons2.newInstance("Rose");
        System.out.println(rose.toString());

        //调用私有属性
        Method behavior = clazz.getDeclaredMethod("behavior", String.class);
        behavior.setAccessible(true);
        String eat = (String) behavior.invoke(rose, "吃饭");
        System.out.println(eat);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        //获取运行时类的属性
        Class<Person> clazz = Person.class;
        System.out.println(clazz);
        //通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> clazz2 = person.getClass();
        System.out.println(clazz2);
        //通过Class类的静态方法
        Class<?> name = Class.forName("com.zantong.java.Person");
        System.out.println(name);
    }

    @Test
    public void test4() {
        //获取系统加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        System.out.println(classLoader);
        //获取系统加载器的父亲,扩展加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        //获取扩展加载器的父亲,引导类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);
    }
}
