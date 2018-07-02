package com.project.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String randomCode = request.getParameter("randomCode");

		String randomCodeSession = (String) session.getAttribute(RandomValidateCode.RANDOM_CODE_KEY);

		// session.setAttribute(RandomValidateCode.RANDOMCODEKEY, "");
		session.removeAttribute(RandomValidateCode.RANDOM_CODE_KEY);

		if (randomCode.equalsIgnoreCase(randomCodeSession)) {

			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			if ("han".equals(name) && "123".equals(pass)) {
				response.sendRedirect("ok.jsp");
			} 
		} else {
			request.setAttribute("message", "验证码无效！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			//response.sendRedirect("checkServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
