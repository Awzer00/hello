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
 * Servlet implementation class AddRoleServletControl
 */
@WebServlet("/addRoleServletControl")
public class AddRoleServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService rs=new RoleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServletControl() {
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
		
		String logID=request.getParameter("logid");
		String name=request.getParameter("name");
		String logPwd=request.getParameter("logPwd");
		String type=request.getParameter("userType");
		PrintWriter out=response.getWriter();
		if(logID!=null && logID!="" && name!=null && name!="" && logPwd!=null && logPwd!="" && type!=null && type!="") {
			try {
				boolean bool=rs.showRoleByLogId(logID);
				if(bool) {
					out.print("hadID");
				}else {
					Role role=new Role();
					role.setRoleName(name);
					role.setLogId(logID);
					role.setLogPwd(logPwd);
					role.setRlimit(type);
					boolean b=rs.addRole(role);
					if(b) {
						out.print("ok");
					}else {
						out.print("error");
					}
				}
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			out.print("empty");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
