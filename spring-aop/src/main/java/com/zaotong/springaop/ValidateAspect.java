package com.zaotong.springaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ZhuGangGang
 * @Date 2020/3/15 15:39
 */
@Component
@Aspect
@Order(1)
public class ValidateAspect {

    @Before("AspectMethod.declareJointPointExpression()")
    public void  beforeMethod(JoinPoint joinPoint){
        System.out.println("Validate: ["+ Arrays.asList(joinPoint.getArgs()) +"]");
    }
}
