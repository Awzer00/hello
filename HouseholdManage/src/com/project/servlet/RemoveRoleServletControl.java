package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IRoleService;
import com.project.entity.Role;
import com.project.service.RoleService;

/**
 * Servlet implementation class RemoveRoleServletControl
 */
@WebServlet("/removeRoleServletControl")
public class RemoveRoleServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService rs=new RoleService();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRoleServletControl() {
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
		
		PrintWriter out=response.getWriter();
		String logID=request.getParameter("logID");
		if(logID==""||logID==null) {
			out.print("empty");
		}else {
			boolean bool=rs.showRoleByLogId(logID);
			if(bool) {
				int c= rs.removeRole(logID);
				if(c==0) {
					out.print("error");
				}else {
					out.print("ok");
				}
			}else {
				out.print("noID");
			}
		}
//		boolean bool=rs.showRoleByLogId(logID);
//		if(!bool) {
//			request.setAttribute("message", "该用户不存在");
//			request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
//		}else {
//			int c= rs.removeRole(logID);
//			if(c==0) {
//				request.setAttribute("message", "删除失败");
//				request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
//			}else {
//				request.setAttribute("message", "删除成功");
//				request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request, response);
//			}
//		}
	}

}
