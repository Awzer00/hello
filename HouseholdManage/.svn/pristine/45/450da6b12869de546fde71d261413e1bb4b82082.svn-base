package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Interface.IAlldataService;
import com.project.entity.Alldata;
import com.project.service.AlldataService;

/**
 * Servlet implementation class UpdateDataServletControl
 */
@WebServlet("/updateDataServletControl")
public class UpdateDataServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAlldataService ias=new AlldataService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataServletControl() {
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
		String IDCard=request.getParameter("IDCard");
		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		
		Alldata data=ias.showPeopleByIDCard(IDCard);
		if(data==null) {
			out.print("true");
		}else {
			String d=mapper.writeValueAsString(data);
			out.print(d);
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
