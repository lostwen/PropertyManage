package com.hd.servlet;


import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.googlecode.jsonplugin.JSONException;
import com.googlecode.jsonplugin.JSONUtil;
import com.hd.controller.NameExistCheck;


/**
 * Servlet implementation class NameExistCheckServlet
 */
@WebServlet("/nameExistCheck")
public class NameExistCheckServlet extends HttpServlet {
private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public NameExistCheckServlet() {
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
String name=request.getParameter("name");
String text="";
String sql="SELECT COUNT(用户名) exist FROM `管理员` WHERE `用户名`='"+name+"';";


Integer exist = new NameExistCheck().nameExistCheck(sql);
if(exist>0){
text="该用户昵称已存在！";
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
doGet(request, response);
}


}