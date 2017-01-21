package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.hd.controller.ValidateUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String uName = request.getParameter("username");
		String uPwd = request.getParameter("password");
		String text = null;
		String sql = "SELECT 用户名,密码,真实姓名,联系方式,使用权限,管辖区域,备注 FROM 管理员  WHERE 用户名='" + uName + "';";
		Map<String, Object> map = new ValidateUser().getLoginInfo(sql);
		if (!map.isEmpty()) {
			if (uPwd.equals(map.get("pwd"))) {
				LOGGER.info("用户：" + uName + "登录成功。");
				try {
					map.remove("pwd");
					text = JSONUtil.serialize(map);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("user", map);
			} else {
				LOGGER.error("密码错误。");
			}
		} else {
			LOGGER.error("用户不存在。");
		}
		PrintWriter out = response.getWriter();
		out.print(text);
		out.flush();
		out.close();

	}

}