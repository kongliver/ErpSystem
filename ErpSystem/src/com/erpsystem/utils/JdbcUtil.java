package com.erpsystem.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 
 * @function   JDBC连接工具包
 * @author     极客空
 * @date       2018年9月2日 下午7:34:02
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public class JdbcUtil {

    private static DataSource ds = null;
    private static Properties prop = null;
    
    static {
        // 1. 加载配置文件
        prop = new Properties();
        try {
            // 获取字节码的目录
            InputStream ins = JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties");
            prop.load(ins);           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取数据库连接池
     * @return 连接池
     */
    private static DataSource getDataSource() {
        try {
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
    /**
     * 获取dbUtils的执行器
     * @return 执行器
     */
    public static QueryRunner getQueryRunner() {
        return new QueryRunner(JdbcUtil.getDataSource());
    }
    
}
