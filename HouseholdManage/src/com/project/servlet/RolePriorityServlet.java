package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.entity.Role;

/**
 * Servlet implementation class RolePriorityServlet
 */
@WebServlet("/rolePriorityServlet")
public class RolePriorityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolePriorityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*		HttpSession session=request.getSession();
		Role role=(Role) session.getAttribute("role");
		String type=role.getRlimit();
				if("����Ա".equals(type)) {
			request.getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
		}else if("Э��Ա".equals(type)) {
			System.out.println("Э��Ա");
		}else {
			System.out.println("����");
		}*/
		request.getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
