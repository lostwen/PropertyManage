package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.googlecode.jsonplugin.JSONUtil;
import com.hd.util.Base;

public class GetCity extends Base {

	public ArrayList<Map<String, Object>> getCityInfo(String sql) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// String result=null;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		try {
			conn = getConn();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", rs.getInt("ID"));
				map.put("name", rs.getString("Name"));
				map.put("countryCode", rs.getString("CountryCode"));
				map.put("district", rs.getString("District"));
				map.put("population", rs.getInt("Population"));
				list.add(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, state, rs);
		}

		return list;
	}
}