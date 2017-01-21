package com.hd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String truename = request.getParameter("truename");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String right = request.getParameter("right");
		String area = request.getParameter("area");
		String comment = request.getParameter("comment");
		String text = null;
		String sql = "INSERT INTO `管理员` (用户名,密码,真实姓名,联系方式,使用权限,管辖区域,备注) VALUES ('"+name+"','"+password+"','"+truename+"','"+phone+"',"+right+","+area+",'"+comment+"');";
		int rs=0;
		try {
			rs=new UpdateBase().updateBase(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs>0){
			text="新增管理员成功！";
		}
		
		PrintWriter out = response.getWriter();
		out.print(text);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
