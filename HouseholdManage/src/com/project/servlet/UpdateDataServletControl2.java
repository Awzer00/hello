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
 * Servlet implementation class UpdateDataServletControl2
 */
@WebServlet("/updateDataServletControl2")
public class UpdateDataServletControl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAlldataService ias=new AlldataService();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDataServletControl2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out=response.getWriter();
		ObjectMapper mapper=new ObjectMapper();
		
		String IDCard=request.getParameter("IDCard");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String natives=request.getParameter("natives");
		String nation=request.getParameter("nation");
		int trpid=Integer.parseInt(request.getParameter("trpid"));
		
		Alldata data=new Alldata();
		data.setIdcard(IDCard);
		data.setName(name);
		data.setSex(sex);
		data.setNatives(natives);
		data.setNation(nation);
		data.setTrpid(trpid);
		
		int d=ias.updatePeople(data);
		if(d>0) {
			out.print("success");
		}else {
			out.print("false");
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
