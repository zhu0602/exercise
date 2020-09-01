package com.zantong.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ejb.config.JeeNamespaceHandler;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.xml.ws.Service;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ZhuGangGang
 * @Date 2020/3/16 10:14
 */
public class JDBCTest {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;

    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }

    @Test
    public void test1() throws SQLException {
        String sql = "update sys_role set  role_name= ? where id =?";
        jdbcTemplate.update(sql, "超级管理员", 1);
    }

    @Test
    public void test2() throws SQLException {
        String sql = "insert into sys_role(role_name,enabled,create_by,create_time) values (?,?,?,?)";
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"项目经理2", "1", 2, new Timestamp(new Date().getTime())});
        list.add(new Object[]{"程序员2", "1", 1, null});
        jdbcTemplate.batchUpdate(sql, list);
    }
    /**
     * @description:  获取某一个角色
     * @param:
     * @return:
     */
    @Test
    public void test3() {
        String sql = "select * from sys_role where id=?";
        RowMapper<SysRole> sysRoleBeanPropertyRowMapper = new BeanPropertyRowMapper<SysRole>(SysRole.class);
        SysRole sysRole = jdbcTemplate.queryForObject(sql,sysRoleBeanPropertyRowMapper , 1);
        System.out.println(sysRole);
    }

    /**
     * @description: 获取角色集合
     * @param:
     * @return:
     */
    @Test
    public void test4() {
        String sql = "select * from sys_role where id<6";
        List<SysRole> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<SysRole>(SysRole.class));
        System.out.println(result);
    }


    /**
     * @description: 获取单个属性
     * @param:
     * @return:
     */
    @Test
    public void test5() {
        String sql = "select count(*) from sys_role";
        Long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

}
