package com.hd.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hd.util.Base;

public class ValidateUser extends Base {

	public Map<String, Object> getLoginInfo(String sql) {
		// ArrayList<Map<String,Object>> list=new
		// ArrayList<Map<String,Object>>();
		// String result=null;
		Connection conn = null;
		Statement state = null;
		ResultSet rs = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			conn = getConn();
			state = conn.createStatement();
			rs = state.executeQuery(sql);
			if (rs.next()) {
				map.put("name", rs.getString("用户名"));
				map.put("pwd", rs.getString("密码"));
				map.put("trueName", rs.getString("真实姓名"));
				map.put("phone", rs.getString("联系方式"));
				map.put("right", rs.getInt("使用权限"));
				map.put("area", rs.getInt("管辖区域"));
				map.put("content", rs.getString("备注"));
				// result=JSONUtil.serialize(map);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, state, rs);
		}

		return map;
	}
}