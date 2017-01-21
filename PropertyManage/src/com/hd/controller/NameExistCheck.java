package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.jsonplugin.JSONUtil;
import com.hd.util.Base;

public class NameExistCheck extends Base {

	public Integer nameExistCheck(String sql) {
		Integer result = 0;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("exist");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, state, rs);
		}

		return result;
	}
}