package com.erpsystem.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil2 {
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Connection conn = null;
		Properties prop = new Properties();
		InputStream input = JdbcUtil2.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		prop.load(input);
		String driverName = prop.getProperty("driverClass");
		String url = prop.getProperty("url");
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, userName, password);
		return conn;
	}
	
	public static void close(Connection conn,Statement st,ResultSet rs) throws SQLException {
		if(null!=rs)
			rs.close();
		if(null!=st)
			st.close();
		if(null!=conn)
			conn.close();
	}
}
