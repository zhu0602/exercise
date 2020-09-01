package com.zaotong.springaopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhuGangGang
 * @Date 2020/3/11 20:29
 */
public class SpringAopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
        ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        calculator.add(10, 2);
      calculator.division(10, 0);
    }
}
