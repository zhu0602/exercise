package com.atguigu.mybatis.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.atguigu.mybatis.bean.Employee;
import com.atguigu.mybatis.bean.EmployeeExample;
import com.atguigu.mybatis.bean.EmployeeExample.Criteria;
import com.atguigu.mybatis.dao.EmployeeMapper;

/**
 * 两级缓存：
 * 一级缓存(本地缓存)：sqlSession级别的缓存。一级缓存是一直开启的；
 *     sqlSession级别的一个Map与数据库同一次会话查询到的数据会放在本地缓存中。
 *     以后需要获取相同的数据，直接从缓存中获取，没有必要再查数据库
 *     
 *     一级缓存失效的情况（没有使用到当前一级缓存的情况，效果就是，还需要在向数据库进行查询）   
 *	   1. sqlSession不同
 *	   2. sqlSession相同，查询的条件不同.(当前一级缓存中还没有这个数据)
 * 	   3. sqlSession相同，两次查询的之间执行了增删改查操作（这次增删改查可能对当前数据有影响）
 *     4. sqlSession相同，手动清除了一次缓存	 
 *二级缓存：（全局缓存）： 基于namespace级别的缓存；一个namespace对应一个二级缓存   
 *     工作机制：
 *      1. 一个会话，查询一条数据，这个数据就会被放在当前会话的一级缓存中
 *      2. 如果会话关闭，一级缓存中的数据就会被保存到二级会话中.新的会话查询信息，就可以查询二级缓存中的内容
 *      3. 不同的namespace查出的数据会被放在自己对应的缓存中
 *      效果: 数据会从二级缓存中获取
 *            查询出的数据都会默认先放在一级缓存中
 *            只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中 	 
 *      使用： 
 *         1.  开启二级缓存<setting name="cacheEnabled" value="true" />
 *         2.  去mapper.xml中配置使用二级缓存：
 * 				<cache></cache>
 * 		   3. 我们的POJO需要实现序列化接口	
 * 和缓存有关的设置/属性： 
 *          1). cacheEnabled=true：false关闭缓存（一级缓存一直可用）
 *          2). 每个select标签多有useCache=true 
 *              false: 不使用缓存 (一级缓存依然使用，二级缓存不使用)
 *          3). 每个增删改标签的： flushCache='true'(一级二级都会被清除)
 *              查询标签： flushCache=false
 *                    如果flushCache每次查询之后都会被清空缓存，缓存是没有被使用的
 *                               
 *@author azhu0
 */
class MybatisTest {
	
	private SqlSessionFactory getSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	@Test
	public void getGenerator() throws Exception {
		List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   File configFile = new File("mbg.xml");
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
	}
	
	
	@Test
	public void MybatisTest() throws Exception {
			SqlSessionFactory sessionFactory = getSessionFactory();
			SqlSession openSession = sessionFactory.openSession();
			EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
			//封装条件
			EmployeeExample example = new EmployeeExample();
			Criteria criteria = example.createCriteria();
			Criteria lastNameLike = criteria.andLastNameLike("%tom%");
			List<Employee> list;
			try {
				list = mapper.selectByExample(example);
				list.stream().forEach(emp->System.out.println(emp.getEmail()));
			} finally {
				openSession.close();
			}
	}
	

}
