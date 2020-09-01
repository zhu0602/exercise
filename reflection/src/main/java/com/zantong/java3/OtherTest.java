package com.zantong.java3;

import com.zantong.java2.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ZhuGangGang
 * @Date 2020/2/13 9:57
 */
public class OtherTest {
    @Test
    public void test1() throws ClassNotFoundException {
        //获取运行时类和父类属性为public属性
        Class<?> name = Class.forName("com.zantong.java2.Person");
        Field[] fields = name.getFields();
        for (Object field : fields) {
            System.out.println(field);
        }
        System.out.println("*************");
        //获取运行时类的所有属性
        Field[] fields1 = name.getDeclaredFields();
        for (Object field : fields1) {
            System.out.println(field);
        }
    }

    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //获取权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //获取类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");
            //获取变量名
            String name = f.getName();
            System.out.print(name);
            System.out.println();
        }
    }

    @Test
    public void test3() {
        Class clazz = Person.class;
        Method[] methods = clazz.getMethods();
        //获取运行时类声明为public权限的方法及其父类权限方法
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    @Test
    public void test4() {
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //获取运行时类的所有方法(不包括父类声明的方法)
        for (Method method : declaredMethods) {
            //获取运行时类的注解
            Annotation[] annos = method.getAnnotations();
            if (annos.length > 0) {
                for (int i = 0; i < annos.length; i++) {
                    System.out.println(annos[i].annotationType());
                }
            }
            //获取运行时类的权限修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");
            //获取返回值类型
            System.out.print(method.getReturnType().getName() + "\t");
            //获取方法名称
            System.out.print(method.getName() + "\t");
            //获取形参列表
            Class[] types = method.getParameterTypes();
            System.out.print(" (");
            if (types.length > 0) {
                for (int i = 0; i < types.length; i++) {
                    if (i == types.length - 1) {
                        System.out.print(types[i].getName() + " arg_" + i);
                        break;
                    }
                    System.out.print(types[i].getName() + "arg_" + i + " ,");
                }
            }
            System.out.print(")");
            //获取异常throw
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if (i == exceptionTypes.length - 1) {
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }
            System.out.println();
        }
    }

    @Test
    public void test5() {
        Class clazz = Person.class;
        //获取运行时类声明public权限的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor cons : constructors) {
            System.out.println(cons);
        }
        //获取运行时类所有权限的构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor cons : declaredConstructors) {
            System.out.println(cons);
        }
    }

    @Test
    public void test6() {
        Class clazz = Person.class;
        //获取父类名称
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
        //获取带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
        //获取泛型类型
        ParameterizedType parType = (ParameterizedType) genericSuperclass;
        System.out.println(parType.getActualTypeArguments()[0]);
    }


    @Test
    public void test7() {
        Class clazz = Person.class;
        //获取类上的注解:
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获取父类上的注解
        Annotation[] annotations1 = clazz.getSuperclass().getAnnotations();
        for (Annotation annotation : annotations1) {
            System.out.println(annotation);
        }
        //获取运行时类的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println(i.getName());
        }
        //获取运行时类父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class i : interfaces1) {
            System.out.println(i.getName());
        }
    }

    @Test
    public void test8() throws Exception {
        Class clazz = Person.class;
        //获取指定的属性
        Field nation = clazz.getDeclaredField("name");
        //保证属性是可以被访问的
        nation.setAccessible(true);
        //获取运行时类
        Person person = (Person) clazz.newInstance();
        //设置当前属性(参数一: 指明设置哪个对象的属性,参数二:设置当前属性值)
        nation.set(person, "Tom");
        //获取当前属性值(参数一: 设置哪个对象的属性值)
        String o = (String) nation.get(person);
        System.out.println(o);
    }

    @Test
    public void test9() {
        Class clazz = Person.class;
        //获取运行时类实现的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class face : interfaces) {
            System.out.println(face);
        }
        //获取运行时的类包名
        Package pack = clazz.getPackage();
        System.out.println(pack.toString());
        //获取运行时类的注解
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    @Test
    public void test10() throws Exception {
        Class clazz = Person.class;
        //创建运行时类的实例
        Person p= (Person) clazz.newInstance();
        //获取指定的方法
        Method nation = clazz.getDeclaredMethod("nation", String.class);
        //保证方法可以被访问
        nation.setAccessible(true);
        //调用invoke方法 第一个参数表示: 运行时对象   第二个参数是运行时对象的实参
        //invoke方法返回返回值就是指定方法的返回值
        String method = (String) nation.invoke(p, "中国");
        System.out.println(method);
    }

}
