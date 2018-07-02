package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IHostService;
import com.project.service.HostService;

/**
 * Servlet implementation class CheckHadHostIDCard
 */
@WebServlet("/checkHadHostIDCard")
public class CheckHadHostIDCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IHostService ihs=new HostService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckHadHostIDCard() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String IDCard=request.getParameter("IDCard");
		boolean bool=ihs.checkHadIDcard(IDCard);
		if(!bool) {
			out.print("error");
		}
		out.flush();
	}

}
