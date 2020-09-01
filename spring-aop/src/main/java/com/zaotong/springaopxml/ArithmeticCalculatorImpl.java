package com.zaotong.springaopxml;

import org.springframework.stereotype.Component;

/**
 * @author ZhuGangGang
 * @Date 2020/2/2 12:11
 */
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    public int add(int i, int j) {
        return i+j;
    }

    public int sub(int i, int j) {
        return i-j;
    }

    public int division(int i, int j) {
        return i/j;
    }

    public int mul(int i, int j) {
        return i*j;
    }
}
