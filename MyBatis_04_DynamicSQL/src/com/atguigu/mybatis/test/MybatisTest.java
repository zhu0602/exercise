package com.atguigu.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
import com.atguigu.mybatis.dao.EmployeeMapperDynamicSQL;
import com.atguigu.mybatis.dao.EmployeePlusMapper;

/**
 * Mybatis的接口式开发 sqlSession代表和数据库的一次会话，会话完需要关闭 Mybatis有两个重要的xml文件
 * 一个是mybatis的全局配置文件： 里面数据库连接源，事务管理器等等 另一个是sql映射文件： 里面保存了sql，和映射的规则 接口式的编程开发:
 * 接口更像是一种规则，mybatis（通过接口和xml的绑定） mapper接口，没有实现类，mybatis自动为mapper接口创建自动代理
 * 
 * @author azhu0
 *
 */
class MybatisTest {

	@Test
	public void test() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = session.selectOne("com.atguigu.mybatis.bean.EmployeeMapper.selectEmp", 1);
			System.out.println(employee);
		} finally {
			session.close();
		}

	}

	/**
	 * 通过接口式的
	 * 
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			// 3、获取接口的实现类对象
			// 会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = mapper.getEmployeeById(100);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test3() throws IOException {
		SqlSessionFactory sessionFactory = getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		EmployeeMapper mapper;
		try {
			mapper = session.getMapper(EmployeeMapper.class);
			// Employee employee = mapper.getEmployeeByIdAndLastName(1,"tom");
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", "1");
			Employee employee = mapper.getEmpByMap(map);
			System.out.println(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test4() throws IOException {
		SqlSessionFactory sessionFactory = getSessionFactory();
		SqlSession session = sessionFactory.openSession(true);
		try {
			EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
			Employee employee = new Employee();
			employee.setEmail("jimmy@163.com");
			employee.setLastName(null);
			mapper.addEmp(employee);
		} finally {
			session.close();
		}
	}

	@Test
	public void test5() throws IOException {
		SqlSessionFactory sessionFactory = getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		EmployeeMapper mapper;
		try {
			mapper = session.getMapper(EmployeeMapper.class);
			/*
			 * Map<String, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%j%");
			 * System.out.println("获取getEmpByLastNameLikeReturnMap的值"); Employee employee =
			 * map.get(4); System.out.println(employee);
			 */
			Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
			System.out.println(map);
		} finally {
			session.close();
		}
	}

	/**
	 * 自定义结果集映射规则测试
	 * 
	 * @throws IOException
	 */
	@Test
	public void test6() throws IOException {
		SqlSessionFactory sessionFactory = getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		EmployeePlusMapper mapper;
		try {
			mapper = session.getMapper(EmployeePlusMapper.class);
			Employee employee = mapper.getEmpById(4);
			System.out.println(employee);

			/*
			 * mapper = session.getMapper(DepartmentMapper.class); Department department =
			 * mapper.getDepByIdStep(1); System.out.println(department.getDepName());
			 */
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void test7() throws IOException {
		SqlSessionFactory sessionFactory = getSessionFactory();
		SqlSession session = sessionFactory.openSession();
		EmployeeMapperDynamicSQL mapper;
		try {
			mapper = session.getMapper(EmployeeMapperDynamicSQL.class);
			List<Employee> employees = new ArrayList<Employee>();
			Employee employee = new Employee(4, 2, "zhangsan", "zhangsan7@qq.com", "1");
			Employee employee2 = new Employee(5, 3, "zhangsan2", "zhangsan6@qq.com", "1");
			employees.add(employee);
			employees.add(employee2);
			mapper.addEmps(employees);
			session.commit();
		} finally {
			session.close();
		}
	}

	private SqlSessionFactory getSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

}
