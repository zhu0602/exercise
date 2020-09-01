package com.zaotong.springaopxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/11 19:36
 */
public class LoggerAspect {

    public void declareJointPointExpression(){}


    public void beforeAdvice(JoinPoint joinpoint){
        //方法名
        String name = joinpoint.getTarget().getClass().getName();
        //方法参数
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("The Method"+"_begins"+name+args);
    }

    public void afterAdvice(JoinPoint joinpoint){
        //方法名
        String name = joinpoint.getTarget().getClass().getName();
        System.out.println("The Method"+name+"_end");
    }

    public void returnAdvice(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("The Method "+name+"_return: "+result);
    }


    public void throwAdvice(JoinPoint joinPoint,NullPointerException e){
        String name = joinPoint.getSignature().getName();
        System.out.println("The Method "+name+"Exception "+e);
    }


    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        String name = proceedingJoinPoint.getSignature().getName();
        Object result=null;
        try {
            //前置通知
            System.out.println("The Method around "+name+" begin");
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The Method around"+name+" result: "+ result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The Method around"+ name+ "Happen Error: "+ e);
        }
        //最后通知or 后置通知(无论是否发生异常,程序都将被执行)
        System.out.println("The Method "+name+" end");
        return result;
    }
}
