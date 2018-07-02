package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IAlldataService;
import com.project.entity.Alldata;
import com.project.service.AlldataService;

/**
 * Servlet implementation class AddDataServletControl
 */
@WebServlet("/addDataServletControl")
public class AddDataServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAlldataService ad=new AlldataService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDataServletControl() {
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
		
		int c=ad.addNewPeople(data);
		PrintWriter out=response.getWriter();
		if(c==1) {
			out.print("ok");
		}else {
			out.print("error");
		}
		out.flush();
	}

}
