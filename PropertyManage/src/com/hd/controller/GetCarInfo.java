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

public class GetCarInfo extends Base {

	public ArrayList<Map<String, Object>> getCarInfo(String sql) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
				map.put("startTime", sdf.format(rs.getDate("车位领用日期")));
				map.put("lastTime", sdf.format(rs.getDate("上次缴费日期")));
				map.put("endTime", sdf.format(rs.getDate("停车费到期日期")));
				map.put("state", rs.getInt("车位状况") == 0 ? "买" : "租");
				map.put("carId", rs.getInt("编号"));
				map.put("hostId", rs.getInt("住户编号"));
				map.put("carPlace", rs.getString("停车位"));
				map.put("carNum", rs.getString("车牌号"));
				map.put("hostName", rs.getString("业主姓名"));
				map.put("phone", rs.getString("联系电话"));
				map.put("buildNum", rs.getString("幢号"));
				map.put("roomNum", rs.getString("室号"));
				map.put("comment", rs.getString("备注"));

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