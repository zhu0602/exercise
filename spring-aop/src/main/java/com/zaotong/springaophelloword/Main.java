package com.zaotong.springaophelloword;

/**
 * @author ZhuGangGang
 * @Date 2020/2/4 10:48
 */
public class Main {
    public static void main(String[] args) {
        ArithmeticCalculatorImpl ac = new ArithmeticCalculatorImpl();
        ArithmeticCalculatorLoggingProxy arithmeticCalculatorLoggingProxy = new ArithmeticCalculatorLoggingProxy(ac);
        ArithmeticCalculator proxy = (ArithmeticCalculator) arithmeticCalculatorLoggingProxy.getArithmeticCalculatorLoggingProxy();
        int add = proxy.add(2, 2);
        System.out.println(add);
    }

}
