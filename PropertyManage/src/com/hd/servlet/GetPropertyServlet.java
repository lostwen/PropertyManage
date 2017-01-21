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
import com.hd.controller.GetCity;
import com.hd.controller.GetProperty;

/**
 * Servlet implementation class GetPropertyServlet
 */
@WebServlet("/GetProperty")
public class GetPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPropertyServlet() {
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
			sql = "SELECT base.`住户编号`,base.`业主姓名`,base.`婚姻状况`,base.`室号`,base.`家庭成员`,base.`工作单位`,"
					+ "base.`幢号`,base.`年龄`,base.`建筑面积`,base.`性别`,base.`所在小区`,base.`民族`," + "base.`联系电话`,base.`领房时间`,"
					+ "cost.`上次缴费日期`,cost.`公共服务费`,cost.`公共能耗费`,cost.`到期日期`,cost.`备注`,"
					+ "cost.`实收费用`,cost.`应收费用`,cost.`物业费`,cost.`电梯运营费`," + "COUNT(DISTINCT fix.`报修事项`) 报修记录,"
					+ "COUNT(DISTINCT car.`车牌号`) 车辆信息," + "COUNT(DISTINCT deco.`装修手续`) 装修记录,"
					+ "COUNT(DISTINCT other.`好事`) 好事记录,COUNT(DISTINCT other.`求助`) 求助记录,COUNT(DISTINCT other.`违规违章`) 违章记录 "
					+ "FROM `基础信息` base " + "LEFT JOIN `物业费` cost " + "ON base.`住户编号`=cost.`业主` "
					+ "LEFT JOIN `维修记录` fix " + "ON base.`住户编号`=fix.`报修业主` " + "LEFT JOIN `车位` car "
					+ "ON base.`住户编号`=car.`车主` " + "LEFT JOIN `装修记录` deco " + "ON base.`住户编号`=deco.`业主` "
					+ "LEFT JOIN `业主杂事` other " + "ON base.`住户编号`=other.`业主` " + "WHERE base.`所在小区`=" + 1
					+ " GROUP BY base.`住户编号`" + " ORDER BY base.`幢号` ASC;";
		} else {
			sql = "SELECT base.`住户编号`,base.`业主姓名`,base.`婚姻状况`,base.`室号`,base.`家庭成员`,base.`工作单位`,"
					+ "base.`幢号`,base.`年龄`,base.`建筑面积`,base.`性别`,base.`所在小区`,base.`民族`," + "base.`联系电话`,base.`领房时间`,"
					+ "cost.`上次缴费日期`,cost.`公共服务费`,cost.`公共能耗费`,cost.`到期日期`,cost.`备注`,"
					+ "cost.`实收费用`,cost.`应收费用`,cost.`物业费`,cost.`电梯运营费`," + "COUNT(DISTINCT fix.`报修事项`) 报修记录,"
					+ "COUNT(DISTINCT car.`车牌号`) 车辆信息," + "COUNT(DISTINCT deco.`装修手续`) 装修记录,"
					+ "COUNT(DISTINCT other.`好事`) 好事记录,COUNT(DISTINCT other.`求助`) 求助记录,COUNT(DISTINCT other.`违规违章`) 违章记录 "
					+ "FROM `基础信息` base " + "LEFT JOIN `物业费` cost " + "ON base.`住户编号`=cost.`业主` "
					+ "LEFT JOIN `维修记录` fix " + "ON base.`住户编号`=fix.`报修业主` " + "LEFT JOIN `车位` car "
					+ "ON base.`住户编号`=car.`车主` " + "LEFT JOIN `装修记录` deco " + "ON base.`住户编号`=deco.`业主` "
					+ "LEFT JOIN `业主杂事` other " + "ON base.`住户编号`=other.`业主` " + "WHERE base.`所在小区`=" + areaId
					+ " GROUP BY base.`住户编号`" + " ORDER BY base.`幢号` ASC;";
		}
		ArrayList<Map<String, Object>> list = new GetProperty().getPropertyInfo(sql);
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
		doGet(request, response);
	}

}