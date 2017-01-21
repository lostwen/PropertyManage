package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hd.util.Base;

public class GetPlotList extends Base {

	public ArrayList<Map<String, Object>> getPlotList(String sql) {
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
				map.put("plotId", rs.getInt("小区编号"));
				map.put("plotName", rs.getString("小区名"));

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