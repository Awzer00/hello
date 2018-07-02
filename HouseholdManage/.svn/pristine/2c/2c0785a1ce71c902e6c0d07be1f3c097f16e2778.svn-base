package com.project.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Interface.ITrpService;
import com.project.entity.Trp;
import com.project.service.TrpService;

/**
 * Servlet implementation class ShowTrpByTrpidServlet
 */
@WebServlet("/showTrpByTrpidServlet")
public class ShowTrpByTrpidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITrpService its=new TrpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTrpByTrpidServlet() {
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
		
		String trpid=request.getParameter("trpid");
		Trp trp=its.showTrpByTrp(trpid);
		
		ObjectMapper om=new ObjectMapper();
		String t=om.writeValueAsString(trp);
		
		response.getWriter().print(t);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
