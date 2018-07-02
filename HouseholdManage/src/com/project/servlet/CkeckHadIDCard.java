package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IAlldataService;
import com.project.Interface.IRoleService;
import com.project.entity.Alldata;
import com.project.entity.Role;
import com.project.service.AlldataService;
import com.project.service.RoleService;

/**
 * Servlet implementation class CkeckHadLodid
 */
@WebServlet("/ckeckHadIDCard")
public class CkeckHadIDCard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAlldataService ias=new AlldataService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CkeckHadIDCard() {
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
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		
		String IDCard=request.getParameter("IDCard");
		Alldata data=ias.showPeopleByIDCard(IDCard);
		PrintWriter out=response.getWriter();
		if(data!=null) {
			out.print("ok");
			
		}else {
			out.print("error");
		}
	}

}
