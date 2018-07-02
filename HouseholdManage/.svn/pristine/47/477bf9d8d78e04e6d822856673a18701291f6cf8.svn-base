package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.ITrpService;
import com.project.entity.Trp;
import com.project.service.TrpService;

/**
 * Servlet implementation class CheckHadTrpID
 */
@WebServlet("/checkHadTrpID")
public class CheckHadTrpID extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITrpService its=new TrpService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckHadTrpID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String trpid=request.getParameter("trpid");
		boolean bool=its.showTrpByTrpid(trpid);
		if(!bool) {
			out.print("noID");
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
