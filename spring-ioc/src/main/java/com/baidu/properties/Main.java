package com.baidu.properties;

import com.baidu.bean.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author ZhuGangGang
 * @Date 2020/1/30 10:24
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("propertiesApplication.xml");
        Database database = applicationContext.getBean(Database.class);
        System.out.println(database);
    }
}
