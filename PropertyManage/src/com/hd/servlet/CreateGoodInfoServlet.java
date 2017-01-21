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
@WebServlet("/createGoodInfo")
public class CreateGoodInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateGoodInfoServlet() {
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
		String goodIllegal = request.getParameter("goodIllegal");
		Integer hostId = Integer.parseInt(request.getParameter("hostId"));
		String goodHelp = request.getParameter("goodHelp");
		String goodThing = request.getParameter("goodThing");
		String goodComment = request.getParameter("goodComment");
		String text = null;
		String sql = "INSERT INTO `业主杂事`(业主,违规违章,求助,好事,备注) VALUES(" + hostId + ",'" + goodIllegal + "','" + goodHelp
				+ "','" + goodThing + "','" + goodComment + "');";
		int rs = 0;
		try {
			rs = new UpdateBase().updateBase(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rs > 0) {
			text = "新增报修记录成功！";
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