package com.zaotong.springaopxml;

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
public class ValidateAspect {

    public void  beforeAdvice(JoinPoint joinPoint){
        System.out.println("Validate: ["+ Arrays.asList(joinPoint.getArgs()) +"]");
    }
}
