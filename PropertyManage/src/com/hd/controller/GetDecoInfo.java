package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hd.util.Base;

public class GetDecoInfo extends Base {

	public ArrayList<Map<String, Object>> getDecoInfo(String sql) {
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
				map.put("decoRecord", rs.getString("物业巡查记录"));
				map.put("decoProcedure", rs.getString("装修手续"));
				map.put("decoIllegal", rs.getString("装修违规操作"));
				map.put("decoResult", rs.getString("验收结果"));
				map.put("decoPrepay", Float.parseFloat(rs.getString("装修押金")));
				map.put("decoReturn", Float.parseFloat(rs.getString("退还押金")));

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