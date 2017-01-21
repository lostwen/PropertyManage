package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.hd.controller.UpdateBase;
import com.hd.controller.ValidateUser;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/createCarInfo")
public class CreateCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCarInfoServlet() {
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
		String carNum = request.getParameter("carNum");
		Integer carState = Integer.parseInt(request.getParameter("carState"));
		Integer hostId = Integer.parseInt(request.getParameter("hostId"));
		String carPlace = request.getParameter("carPlace");
		Date startTime = Date.valueOf(request.getParameter("startTime"));
		Date lastTime = Date.valueOf(request.getParameter("lastTime"));
		Date endTime = Date.valueOf(request.getParameter("endTime"));
		String text = null;
		String sql = "INSERT INTO `车位`(车牌号,车主,停车位,车位状况,车位领用日期,上次缴费日期,停车费到期日期) VALUES('" + carNum + "'," + hostId + ",'"
				+ carPlace + "'," + carState + ",'" + startTime + "','" + lastTime + "','" + endTime + "');";
		int rs = 0;
		try {
			rs = new UpdateBase().updateBase(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs > 0) {
			text = "新增车位成功！";
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