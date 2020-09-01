package com.zaotong.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/11 19:36
 */
@Service
@Aspect
@Order(2)
public class AspectMethod {

    /**
     定义一个方法,用于声明切入点表达式,一般的,该方法中不需要声明其他代码
     使用pointCut声明切入点表达式
     后面的其他通知直接使用方法名来进行引用切入点表达式
     */
    @Pointcut("execution(* com.zaotong.springaop.ArithmeticCalculator.*(..))")
    public void declareJointPointExpression(){}


    //前置通知
    @Before("declareJointPointExpression()")
    public void beforeAdvice(JoinPoint joinpoint){
        //方法名
        String name = joinpoint.getTarget().getClass().getName();
        //方法参数
        List<Object> args = Arrays.asList(joinpoint.getArgs());
        System.out.println("The Method"+"_begins"+name+args);
    }

    @After("execution(public int com.zaotong.springaop.ArithmeticCalculator.*(..))")
    public void afterAdvice(JoinPoint joinpoint){
        //方法名
        String name = joinpoint.getTarget().getClass().getName();
        System.out.println("The Method"+name+"_end");
    }

    //返回通知
    @AfterReturning(value = "execution(public int com.zaotong.springaop.ArithmeticCalculator.*(..))",returning = "result")
    public void returnAdvice(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        System.out.println("The Method "+name+"_return: "+result);
    }


    //异常通知
    @AfterThrowing(value = "execution(public int com.zaotong.springaop.ArithmeticCalculator.*(..))",throwing = "e")
    public void throwAdvice(JoinPoint joinPoint,NullPointerException e){
        String name = joinPoint.getSignature().getName();
        System.out.println("The Method "+name+"Exception "+e);
    }


    //环绕通知
    //环绕通知携带返回ProceedingJoinPoint 类型的参数
    //环绕通知有点像动态代理的全过程: ProceedingJoinPoint类型的参数可以决定是否执行该目标法方法
    //环绕通知必须有返回值,即为目标方法的返回值
    @Around(value = "execution(public int com.zaotong.springaop.ArithmeticCalculator.*(..))")
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
