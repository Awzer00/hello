package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.ITenantService;
import com.project.entity.Tenant;
import com.project.service.TenantService;

/**
 * Servlet implementation class AddTenantServletControl
 */
@WebServlet("/addTenantServletControl")
public class AddTenantServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITenantService its=new TenantService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTenantServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String licenceID=request.getParameter("licenceID");
		String IDCard=request.getParameter("IDCard");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		int trpID=Integer.parseInt(request.getParameter("trpID"));
		String b=request.getParameter("begin");
		String e=request.getParameter("end");
		
		
		Tenant t=new Tenant();
		t.setLicenceId(licenceID);
		t.setIdcard(IDCard);
		t.setName(name);
		t.setPhone(phone);
		t.setTrpid(trpID);
		t.setBeginDate(b);
		t.setEndDate(e);
		
		PrintWriter out = response.getWriter();
		int c=its.addTenant(t);
		System.out.println(c);
		if(c==1) {
			out.print("ok");
		}else {
			out.print("error");
		}
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
