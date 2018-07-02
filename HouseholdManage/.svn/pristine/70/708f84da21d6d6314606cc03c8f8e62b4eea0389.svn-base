package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Interface.IHostService;
import com.project.entity.Host;
import com.project.service.HostService;

/**
 * Servlet implementation class ShowHostByIDCardServletControl
 */
@WebServlet("/showHostByIDCardServletControl")
public class ShowHostByIDCardServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHostService ihs=new HostService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHostByIDCardServletControl() {
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
		PrintWriter out = response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		String IDCard=request.getParameter("IDCard");
		Host host=ihs.showHostByIDCard(IDCard);
		if(host==null) {
			out.print("noID");
		}else {
			String h=mapper.writeValueAsString(host);
			out.print(h);
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
