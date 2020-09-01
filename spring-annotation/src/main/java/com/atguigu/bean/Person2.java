package com.atguigu.bean;

public class Person2 {

	/**
	 * 1. 使用@Value进行赋值
	 * 2. 使用Spel表达式 #{}
	 * 3. 使用写${}来取出配置【properties】文件中的值（在运行环境变量中的值）
	 */
	
	private String name;
	private Integer age;
	private String nkName;
	
	public String getNkName() {
		return nkName;
	}
	public void setNkName(String nkName) {
		this.nkName = nkName;
	}
	public Person2() {
		super();
	}
	public Person2(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person2 [name=" + name + ", age=" + age + ", nkName=" + nkName + "]";
	}
}
