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
@WebServlet("/createDecoInfo")
public class CreateDecoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateDecoInfoServlet() {
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
		String decoProcedure = request.getParameter("decoProcedure");
		Integer hostId = Integer.parseInt(request.getParameter("hostId"));
		String decoIllegal = request.getParameter("decoIllegal");
		String decoPatrol = request.getParameter("decoPatrol");
		Float decoPledge = Float.parseFloat(request.getParameter("decoPledge"));
		Float decoPledgeReturn = Float.parseFloat(request.getParameter("decoPledgeReturn"));
		String decoResult = request.getParameter("decoResult");
		String text = null;
		String sql = "INSERT INTO `装修记录`(业主,装修手续,装修违规操作,物业巡查记录,装修押金,退还押金,验收结果) VALUES(" + hostId + ",'" + decoProcedure
				+ "','" + decoIllegal + "','" + decoPatrol + "'," + decoPledge + "," + decoPledgeReturn + ",'"
				+ decoResult + "');";
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