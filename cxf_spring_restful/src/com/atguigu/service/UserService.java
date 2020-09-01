package com.atguigu.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.atguigu.bean.Student;

@WebService
public interface UserService {

	@GET // 指定请求方式，如果服务端发布的时候指定的是GET，那么客户端访问时必须使用GET
	@Path("queryStudentById/{id}")
	@Produces(value=MediaType.APPLICATION_XML) // /指定服务端返回数据类型
	public Student queryStudentById(@PathParam("id")Integer id);

	
	
	@GET //请求方式
	@Path(value = "getUserList") //url
	List<Student> getUserList();
}
