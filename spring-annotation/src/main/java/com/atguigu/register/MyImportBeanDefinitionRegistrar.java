package com.atguigu.register;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.atguigu.bean.Red;

public class MyImportBeanDefinitionRegistrar  implements ImportBeanDefinitionRegistrar{

	//参数一： 类上的注解信息
	//参数二： 把所有需要添加到容器中的bean调用registerBeanDefination手工注册进来
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean b = registry.containsBeanDefinition("com.atguigu.bean.Black");
		boolean c = registry.containsBeanDefinition("com.atguigu.bean.Yellow");
		if (b&&c) {
			RootBeanDefinition beanDefinition = new RootBeanDefinition(Red.class);
			registry.registerBeanDefinition("red", beanDefinition);
		}
		
	}

}
