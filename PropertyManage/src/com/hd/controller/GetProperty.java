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

public class GetProperty extends Base {

	public ArrayList<Map<String, Object>> getPropertyInfo(String sql) {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
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
				map.put("propertyCost", rs.getFloat("物业费"));
				map.put("liftCost", rs.getFloat("电梯运营费"));
				map.put("serviceCost", rs.getFloat("公共服务费"));
				map.put("energyCost", rs.getFloat("公共能耗费"));
				map.put("supposedPay", rs.getFloat("应收费用"));
				map.put("area", rs.getFloat("建筑面积"));
				map.put("realPay", rs.getFloat("实收费用"));
				map.put("receiveDate", sdf.format(rs.getDate("领房时间")));
				map.put("propertyDate", sdf.format(rs.getDate("到期日期")));
				map.put("lastDate", sdf.format(rs.getDate("上次缴费日期")));
				map.put("hostId", rs.getInt("住户编号"));
				map.put("fix", rs.getInt("报修记录"));
				map.put("car", rs.getInt("车辆信息"));
				map.put("decoration", rs.getInt("装修记录"));
				map.put("good", rs.getInt("好事记录"));
				map.put("help", rs.getInt("求助记录"));
				map.put("infringe", rs.getInt("违章记录"));
				map.put("age", rs.getInt("年龄"));
				map.put("marriage", rs.getInt("婚姻状况")==0 ? "未婚" : "已婚");
				map.put("sex", rs.getInt("性别")==0 ? "男" : "女");
				map.put("buildNum", rs.getString("幢号"));
				map.put("roomNum", rs.getString("室号"));
				map.put("hostName", rs.getString("业主姓名"));
				map.put("phone", rs.getString("联系电话"));
				map.put("family", rs.getString("家庭成员"));
				map.put("company", rs.getString("工作单位"));
				map.put("nation", rs.getString("民族"));
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