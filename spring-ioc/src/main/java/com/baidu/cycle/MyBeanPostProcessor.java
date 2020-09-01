package com.baidu.cycle;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 20:50
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用postProcessBeforeInitialization:"+bean+":"+beanName);
        return null;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("调用postProcessAfterInitialization:"+bean+":"+beanName);
        return null;
    }
}
