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

import com.hd.controller.UpdateBase;

/**
 * Servlet implementation class UpdateBaseInfoServlet
 */
@WebServlet("/updateBaseInfo")
public class UpdateBaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBaseInfoServlet() {
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
		String phone=request.getParameter("phone");
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
		Integer hostId=Integer.parseInt(request.getParameter("hostId"));
		
		String sql1="UPDATE `基础信息` SET `联系电话`='"+phone+"',`婚姻状况`="+marriage+",`家庭成员`='"+family+"',`工作单位`='"+company+"' WHERE `住户编号`="+hostId+";";
		String sql2="UPDATE `物业费` SET `物业费`="+propertyCost+",`公共服务费`="+serviceCost+",`公共能耗费`="+energyCost+",`电梯运营费`="+liftCost+",`应收费用`="+supposedPay+",`上次缴费日期`='"+lastDate+"',`到期日期`='"+propertyDate+"',`实收费用`="+realPay+",`备注`='"+comment+"' WHERE `业主`="+hostId+";";
		
		String text = null;
		int rs1=0;
		int rs2=0;
		try {
			rs1=new UpdateBase().updateBase(sql1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs2=new UpdateBase().updateBase(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rs1>0 && rs2>0){
			text="更新成功";
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
