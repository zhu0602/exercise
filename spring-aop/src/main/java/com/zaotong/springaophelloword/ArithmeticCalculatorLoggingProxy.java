package com.zaotong.springaophelloword;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ZhuGangGang
 * @Date 2020/2/4 12:41
 */
public class ArithmeticCalculatorLoggingProxy {

    //代理对象
    private Object ac;

    public ArithmeticCalculatorLoggingProxy(Object ac) {
        this.ac = ac;
    }

    public  Object getArithmeticCalculatorLoggingProxy() {
        ClassLoader loader = ac.getClass().getClassLoader();
        Class<?>[] classes = ac.getClass().getInterfaces();
        
        InvocationHandler invocationHandler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("方法的准备工作");
                Object result = method.invoke(ac, args);
                System.out.println("方法的收尾工作");
                return result;
            }
        };
        return  Proxy.newProxyInstance(loader,classes,invocationHandler);
    }
}

