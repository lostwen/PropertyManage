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

import com.hd.controller.CreateBaseInfo;
import com.hd.controller.UpdateBase;

/**
 * Servlet implementation class UpdateBaseInfoServlet
 */
@WebServlet("/createBaseInfo")
public class CreateBaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBaseInfoServlet() {
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
		String hostName=request.getParameter("hostName");
		String buildNum=request.getParameter("buildNum");
		String roomNum=request.getParameter("roomNum");
		Float area=Float.parseFloat(request.getParameter("area"));
		Date receiveDate=Date.valueOf(request.getParameter("receiveDate"));
		String phone=request.getParameter("phone");
		Integer sex=Integer.parseInt(request.getParameter("sex"));
		Integer age=Integer.parseInt(request.getParameter("age"));
		String userId=request.getParameter("userId");
		String nation=request.getParameter("nation");
		Integer marriage=Integer.parseInt(request.getParameter("marriage"));
		String family=request.getParameter("family");
		String company=request.getParameter("company");
		Float propertyCost=Float.parseFloat(request.getParameter("propertyCost"));
		Float serviceCost=Float.parseFloat(request.getParameter("serviceCost"));
		Float energyCost=Float.parseFloat(request.getParameter("energyCost"));
		Float liftCost=Float.parseFloat(request.getParameter("liftCost"));
		Float supposedPay=Float.parseFloat(request.getParameter("supposedPay"));
		Date lastDate=Date.valueOf(request.getParameter("lastDate"));
		Date propertyDate=Date.valueOf(request.getParameter("propertyDate"));
		Float realPay=Float.parseFloat(request.getParameter("realPay"));
		String comment=request.getParameter("comment");
		Integer areaId=Integer.parseInt(request.getParameter("areaId"));
		
		String sql1="INSERT INTO `基础信息`(业主姓名,所在小区,幢号,室号,建筑面积,联系电话,性别,年龄,领房时间,身份证号,工作单位,婚姻状况,民族,家庭成员) VALUES('"+hostName+"',"+areaId+",'"+buildNum+"','"+roomNum+"',"+area+",'"+phone+"',"+sex+","+age+",'"+receiveDate+"','"+userId+"','"+company+"',"+marriage+",'"+nation+"','"+family+"');";
		String sql2="INSERT INTO `物业费`(物业费,电梯运营费,公共能耗费,公共服务费,应收费用,上次缴费日期,到期日期,实收费用,备注) VALUES("+propertyCost+","+liftCost+","+energyCost+","+serviceCost+","+supposedPay+",'"+lastDate+"','"+propertyDate+"',"+realPay+",'"+comment+"');";
		
		String text = null;
		int rs1=0;
		int rs2=0;
		try {
			rs1=new CreateBaseInfo().createBase(sql1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs2=new CreateBaseInfo().createBase(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs1>0 && rs2>0){
			text="新建成功";
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
