package com.zaotong.springaophelloword;

import org.springframework.stereotype.Component;

/**
 * @author ZhuGangGang
 * @Date 2020/2/2 12:08
 */
public interface ArithmeticCalculator {
    int add(int i,int j);
    int sub(int i, int j);
    int division(int i, int j);
    int mul(int i,int j);
}
