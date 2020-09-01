package com.baidu.bean;

import java.util.Properties;

/**
 * @author ZhuGangGang
 * @Date 2020/1/29 17:01
 */
public class Database {

    private Properties properties;

    public Database() {
    }

    public Database(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Database{" +
                "properties=" + properties +
                '}';
    }
}
