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
 * Servlet implementation class UpdatePowerLogIdServlet
 */
@WebServlet("/updateLogPwdServletControl")
public class UpdateLogPwdServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService rs=new RoleService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLogPwdServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
			String logPwd=request.getParameter("logPwd");
			int c = rs.updateRolePwd(logPwd, logID);
			if(c==1) {
				out.print("ok");
			}else {
				out.print("error");
			}
		}
	}

}
