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
 * Servlet implementation class RemoveLidByLIDServletControl
 */
@WebServlet("/removeLidByLIDServletControl")
public class RemoveLidByLIDServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IHostService ihs=new HostService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveLidByLIDServletControl() {
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
		PrintWriter out=response.getWriter();
		String licenceID=request.getParameter("licenceID");
		if(licenceID==null||licenceID=="") {
			out.print("empty");
		}else {
			int c=ihs.removeHost(licenceID);
			if(c==1) {
				out.print("ok");
			}else {
				out.print("error");
			}
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
