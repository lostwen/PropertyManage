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
@WebServlet("/updateCarInfo")
public class UpdateCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCarInfoServlet() {
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
		Integer carId = Integer.parseInt(request.getParameter("carId"));
		Date lastTime = Date.valueOf(request.getParameter("lastTime"));
		Date endTime = Date.valueOf(request.getParameter("endTime"));
		String text = null;
		String sql = "UPDATE `车位` SET `车牌号`='" + carNum + "',`车位状况`=" + carState + ",`上次缴费日期`='" + lastTime
				+ "',`停车费到期日期`='" + endTime + "' WHERE `编号`=" + carId + ";";
		int rs = 0;
		try {
			rs = new UpdateBase().updateBase(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs > 0) {
			text = "更新车位成功！";
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