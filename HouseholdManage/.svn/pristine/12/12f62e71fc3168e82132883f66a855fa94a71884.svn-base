package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class ShowHostServletControl
 */
@WebServlet("/showHostByLIDServletControl")
public class ShowHostByLIDServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHostService ihs=new HostService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHostByLIDServletControl() {
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
		String licenceID=request.getParameter("licenceID");
		boolean bool=ihs.showHost(licenceID);
		if(!bool) {
			out.print("noID");
		}else {
			Host host=ihs.showHostByLicenceID(licenceID);
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
