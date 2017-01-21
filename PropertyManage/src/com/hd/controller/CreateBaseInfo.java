package com.hd.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hd.util.Base;

public class CreateBaseInfo extends Base {

	public int createBase(String sql) throws SQLException {
		Connection conn = null;
		Statement state = null;
		int rs = 0;
		try {
			conn = getConn();
			state = conn.createStatement();
			rs = state.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			state.close();
			conn.close();
		}

		return rs;
	}
}