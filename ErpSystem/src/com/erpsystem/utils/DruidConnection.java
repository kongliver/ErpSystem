package com.erpsystem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class DruidConnection {
    private static Properties properties = null;
    private static DataSource dataSource = null;
    private volatile static DruidConnection instatce = null;
    private Connection connection = null;

    //私有构造函数,防止实例化对象
    private DruidConnection() {}


    static {
        try {
            properties = new Properties();
            // 1.加载properties文件
            InputStream is = DruidConnection.class.getClassLoader().getResourceAsStream("db.properties");

            // 2.加载输入流
            properties.load(is);

            // 3.获取数据源
            dataSource = getDatasource();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用简单单例模式确保只返回一个链接对象
     * 
     * @return
     */
    public static  DruidConnection getInstace() {
        if(instatce == null) {
            synchronized (DruidConnection.class) {
                if(instatce == null) {
                    instatce = new DruidConnection();
                }
            }
        }
        return instatce;
    }

    // 返回一个数据源
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 返回一个链接
    public Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // 加载数据源
    private static DataSource getDatasource() {
        DataSource source = null;
        try {
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return source;
    }
}


