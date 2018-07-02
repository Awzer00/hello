package com.project.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.Interface.IRoleService;
import com.project.entity.Role;
import com.project.service.RoleService;

import com.project.web.RandomValidateCode;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService roleService = new RoleService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String id=request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String type=request.getParameter("userType");
		String randomCode = request.getParameter("randomCode");
		
		HttpSession session=request.getSession();
		String randomCodeSession = (String) session.getAttribute(RandomValidateCode.RANDOM_CODE_KEY);
		session.removeAttribute(RandomValidateCode.RANDOM_CODE_KEY);
		if (randomCodeSession.equalsIgnoreCase(randomCode)) {
			Role role = roleService.login(id, password,type);
			if(role == null){
				request.setAttribute("message", "输入错误,请重新输入！");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				session.setAttribute("role", role);
				request.getRequestDispatcher("rolePriorityServlet").forward(request, response);
			}
		}else {
			request.setAttribute("message", "验证码无效！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
