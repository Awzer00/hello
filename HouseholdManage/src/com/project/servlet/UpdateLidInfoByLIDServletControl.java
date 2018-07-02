package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IHostService;
import com.project.entity.Host;
import com.project.service.HostService;

/**
 * Servlet implementation class UpdateLidInfoByLIDServletControl
 */
@WebServlet("/updateLidInfoByLIDServletControl")
public class UpdateLidInfoByLIDServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IHostService ihs=new HostService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLidInfoByLIDServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String licenceID=request.getParameter("licenceID");
		String name=request.getParameter("name");
		String idcard=request.getParameter("idcard");
		String address=request.getParameter("address");
		String b=request.getParameter("begin");
		String e=request.getParameter("end");
		
	
		Host host=new Host();
		host.setId(id);
		host.setLicenceId(licenceID);
		host.setName(name);
		host.setIdcard(idcard);
		host.setAddress(address);
		host.setBeginDate(b);
		host.setEndDate(e);
		
		PrintWriter out=response.getWriter();
		int c=ihs.updateHost(host);
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
