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
import com.project.Interface.ITrpService;
import com.project.entity.Alldata;
import com.project.entity.Trp;
import com.project.service.AlldataService;
import com.project.service.TrpService;

/**
 * Servlet implementation class SerachTrpServletControl
 */
@WebServlet("/serachTrpServletControl")
public class SerachTrpServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAlldataService ias=new AlldataService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachTrpServletControl() {
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
		
		String idcard=request.getParameter("idcard");
		Alldata data=ias.showPeopleByIDCard(idcard);
		if(data==null) {
			out.print("noIdcard");
		}else {
			if(data.getTrpid()==0) {
				out.print("noTrp");
			}else {
				out.print("have");
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
