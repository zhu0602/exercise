package com.atguigu.fileter;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter {

	/**
	 * @param metadataReader   the metadata reader for the target class\
	 * @param metadataReaderFactory a factory for obtaining metadata readers
	 * 
	 */
	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		//获取目标类的注解 
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		//获取目标类的类型
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		//获取目标类的资源
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("-------->"+className);
		if (className.contains("er")) {
			return  true;
		}
		return false;
	}

}
