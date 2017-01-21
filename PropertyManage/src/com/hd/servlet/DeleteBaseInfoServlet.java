package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hd.controller.DeleteBase;
import com.hd.controller.UpdateBase;

/**
 * Servlet implementation class UpdateBaseInfoServlet
 */
@WebServlet("/deleteBaseInfo")
public class DeleteBaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBaseInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Integer hostId = Integer.parseInt(request.getParameter("id"));

		String sql1 = "DELETE FROM `基础信息` WHERE 住户编号=" + hostId;
		String sql2 = "DELETE FROM `物业费` WHERE 业主=" + hostId;
		String sql3 = "DELETE FROM `车位` WHERE 车主=" + hostId;
		String sql4 = "DELETE FROM `维修记录` WHERE 报修业主=" + hostId;
		String sql5 = "DELETE FROM `装修记录` WHERE 业主=" + hostId;
		String sql6 = "DELETE FROM `业主杂事` WHERE 业主=" + hostId;
		String sql7 = "COMMIT;";

		String text = "";
		int rs = 0;
		try {
			rs = new DeleteBase().deleteBase(sql1, sql2, sql3, sql4, sql5, sql6, sql7);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (rs > 0) {
			text = "删除成功";
		}

		PrintWriter out = response.getWriter();
		out.print(text);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}