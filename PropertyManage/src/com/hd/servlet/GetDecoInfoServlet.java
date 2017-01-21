package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.hd.controller.GetDecoInfo;

/**
 * Servlet implementation class GetCarInfoServlet
 */
@WebServlet("/getDecoInfo")
public class GetDecoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDecoInfoServlet() {
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
		Integer areaId = Integer.parseInt(request.getParameter("area"));
		String sql = "";
		if (areaId == 0) {
			sql = "SELECT deco.`物业巡查记录`,deco.`装修手续`,deco.`装修押金`,deco.`退还押金`,deco.`装修违规操作`,deco.`验收结果`, "
					+ "base.`业主姓名`,base.`幢号`,base.`室号`,base.`联系电话`,base.`住户编号` " + "FROM `装修记录` deco "
					+ "LEFT JOIN `基础信息` base " + "ON deco.`业主`=base.`住户编号` " + "WHERE base.`所在小区`=1;";
		} else {
			sql = "SELECT deco.`物业巡查记录`,deco.`装修手续`,deco.`装修押金`,deco.`退还押金`,deco.`装修违规操作`,deco.`验收结果`, "
					+ "base.`业主姓名`,base.`幢号`,base.`室号`,base.`联系电话`,base.`住户编号` " + "FROM `装修记录` deco "
					+ "LEFT JOIN `基础信息` base " + "ON deco.`业主`=base.`住户编号` " + "WHERE base.`所在小区`=" + areaId + ";";
		}
		ArrayList<Map<String, Object>> list = new GetDecoInfo().getDecoInfo(sql);
		String text = null;
		try {
			text = JSONUtil.serialize(list);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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