package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IRoleService;
import com.project.entity.Role;
import com.project.service.RoleService;

/**
 * Servlet implementation class UpdatePowerServletControl
 */
@WebServlet("/updatePowerServletControl")
public class UpdatePowerServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService rs=new RoleService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePowerServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		String logID=request.getParameter("logID");
		PrintWriter out=response.getWriter();
		boolean bool=rs.showRoleByLogId(logID);
		if(!bool) {
			out.print("noID");
		}else {
			String limit=request.getParameter("power");
			int c=rs.updateRole(limit, logID);
			if(c==1) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}
	}

}
