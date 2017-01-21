package com.hd.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hd.util.Base;

public class DeleteBase extends Base {

	public int deleteBase(String sql1, String sql2, String sql3, String sql4, String sql5, String sql6, String sql7)
			throws SQLException {
		Connection conn = null;
		Statement state = null;
		int rs = 0;
		int[] i;
		try {
			conn = getConn();
			state = conn.createStatement();
			// rs = state.executeUpdate(sql);
			state.addBatch(sql1);
			state.addBatch(sql2);
			state.addBatch(sql3);
			state.addBatch(sql4);
			state.addBatch(sql5);
			state.addBatch(sql6);
			state.addBatch(sql7);
			i = state.executeBatch();
			if (i[0] > 0) {
				rs = 1;
			}
			System.out.println(i.length);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs = 0;
		} finally {
			state.close();
			conn.close();
		}

		return rs;
	}
}