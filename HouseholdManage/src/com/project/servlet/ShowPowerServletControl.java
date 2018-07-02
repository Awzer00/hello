package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Interface.IRoleService;
import com.project.entity.Role;
import com.project.service.RoleService;

/**
 * Servlet implementation class ShowPowerServletControl
 */
@WebServlet("/showPowerServletControl")
public class ShowPowerServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService irs=new RoleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPowerServletControl() {
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
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		String logID=request.getParameter("logID");
		boolean bool=irs.showRoleByLogId(logID);
		if(!bool) {
			out.print("noID");
		}else {
			Role role=irs.showRole(logID);
			if(role==null) {
				out.print("error");
			}else {
				String r=mapper.writeValueAsString(role);
				out.print(r);
			}
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
