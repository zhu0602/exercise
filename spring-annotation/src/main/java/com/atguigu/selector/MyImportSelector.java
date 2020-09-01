package com.atguigu.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{

	//返回需要导入的全类名
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.atguigu.bean.Black","com.atguigu.bean.RainBow"};
	}

}
