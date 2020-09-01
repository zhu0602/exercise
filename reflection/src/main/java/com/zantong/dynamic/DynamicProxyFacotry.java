package com.zantong.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhuGangGang
 * @Date 2020/3/5 16:20
 */
public class DynamicProxyFacotry {

    /**
     1. 如何根据加载到内存中的被代理类,动态的创建被代理类和其对象
     2. 当通过代理类的对象调用法方法时,如何动态的去调用被代理类的同名方法
     */

    /**
     * @description:
     * @param:
     * @return:
     */
    public static Object getProxyInstance(Object object) {
        //被代理类的加载器
        ClassLoader loader = object.getClass().getClassLoader();
        //被代理类实现的接口
        Class<?>[] interfaces = object.getClass().getInterfaces();

        //创建调用的匿名实现类非匿名对象
        InvocationHandler invocationHandler=new InvocationHandler() {
            //当我们调用代理类对象的a方法,就会自动调用如下方法: invoke()
            //将被代理类要执行的方法就声明在这里
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //method方法就是: 代理类对象调用的方法,此方法也就作为被代理类调用的方法
                //obj: 被代理对象 arg: 代理类方法需要的实参
                Object returnValue = method.invoke(object, args);
                return returnValue;
            }
        };
       return Proxy.newProxyInstance(loader,interfaces,invocationHandler);
    }
}
