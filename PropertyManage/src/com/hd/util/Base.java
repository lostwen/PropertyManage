package com.hd.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Base {

	private static DataSource ds = null;
	static {
		try {
			InputStream is = Base.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			Properties prop = new Properties();
			prop.load(is);
			ds = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Connection getConn() throws SQLException {
		return ds.getConnection();
	}

	public void closeAll(Connection conn, Statement state, ResultSet set) {
		try {
			if (set != null) {
				set.close();
			}
			if (state != null) {
				state.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}