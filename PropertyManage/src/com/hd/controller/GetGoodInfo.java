package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hd.util.Base;

public class GetGoodInfo extends Base {

	public ArrayList<Map<String, Object>> getGoodInfo(String sql) {
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
				map.put("hostId", rs.getInt("住户编号"));
				map.put("hostName", rs.getString("业主姓名"));
				map.put("phone", rs.getString("联系电话"));
				map.put("buildNum", rs.getString("幢号"));
				map.put("roomNum", rs.getString("室号"));
				map.put("goodIllegal", rs.getString("违规违章"));
				map.put("goodHelp", rs.getString("求助"));
				map.put("goodThing", rs.getString("好事"));
				map.put("goodComment", rs.getString("备注"));

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