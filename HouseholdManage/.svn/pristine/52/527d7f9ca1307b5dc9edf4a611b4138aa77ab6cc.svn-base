package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IApplytrpService;
import com.project.service.ApplytrpService;

/**
 * Servlet implementation class RemoveOutdateApplytrpServlctControl
 */
@WebServlet("/removeOutdateApplytrpServlctControl")
public class RemoveOutdateApplytrpServlctControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IApplytrpService ias=new ApplytrpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveOutdateApplytrpServlctControl() {
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
		
		String idcard=request.getParameter("idcard");
		int c=ias.removeOutdateApplytrpByIdcard(idcard);
		response.getWriter().print("ok");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
