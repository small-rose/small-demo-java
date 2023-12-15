package com.xiaocai.demo.java.utils;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;

import javax.sql.DataSource;

/**
 * @Project : small-demo-java
 * @Author : zhangzongyuan
 * @Description : [ DataSourceUtils ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/15 10:39
 * @Version ： 1.0
 **/
public class DataSourceUtils {

    @Data
    public static class DbConfig{
        private String driverName;
        private String url;
        private String userName;
        private String password;
    }


    public static DataSource createDataSource(DbConfig config) {
        DruidDataSource dataSource = new DruidDataSource();

        // 设置数据源配置
        dataSource.setDriverClassName(config.getDriverName());
        dataSource.setUrl(config.getUrl());
        dataSource.setUsername(config.getUserName());
        dataSource.setPassword(config.getPassword());

        // 其他配置项，根据需要进行设置
        // 设置连接池大小
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(100);
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(20);
        dataSource.setMaxWait(5000);

        // 设置连接相关配置
        if (dataSource.getDriverClassName().toLowerCase().contains("oracle")){
            dataSource.setValidationQuery("SELECT 1 FROM DUAL");
        }else {
            dataSource.setValidationQuery("SELECT 1");
        }
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(false);

        // 设置逐出策略和时间
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);
        dataSource.setMaxEvictableIdleTimeMillis(1800000);

        return dataSource;
    }
}
