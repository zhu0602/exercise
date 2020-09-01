package com.atguigu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.atguigu.bean.Student;
import com.atguigu.service.UserService;
public class UserServiceImpl implements UserService {
	@Override
	public List<Student> getUserList() {
		List<Student> list=new ArrayList<Student>();
		for (int i = 1; i <10; i++) {
			Student student = new Student();
			student.setUserId(i);
			student.setUserName("张_"+i);
			student.setAge(10+i);
			student.setBirthday(new Date());
			list.add(student);
		}
		return list;
	}
	public Student queryStudentById(Integer id) {
		System.out.println("StudentServiceImpl.queryStudentById():"+id);
		Student student = new Student();
		student.setUserId(id);
		student.setUserName("张三");
		student.setAge(22);
		student.setBirthday(new Date());
		return student;
	}


}
