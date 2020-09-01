package com.aspect;

import com.zaotong.springaop.ArithmeticCalculatorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author ZhuGangGang
 * @Date 2020/3/11 21:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AspectTest {

    @Autowired
    private ArithmeticCalculatorImpl arithmeticCalculator;

    @Test
    public void test1(){
        int add = arithmeticCalculator.add(10, 29);
        System.out.println(add);
    }
}
