package com.project.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IAlldataService;
import com.project.entity.Alldata;
import com.project.service.AlldataService;


import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowAlldataServletControl
 */
@WebServlet("/showAlldataServletControl")
public class ShowAlldataServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAlldataService ias=new AlldataService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAlldataServletControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/javascript;charset=UTF-8");
		

		int page = 0;
		int rows = 0;
	
		try{
			page = Integer.parseInt(request.getParameter("page"));
			rows = Integer.parseInt(request.getParameter("rows"));
		
		}catch(Exception e){
			page = 0;
			rows = 0;
		
		}
		
//		String sort = request.getParameter("sort");
//		String order = request.getParameter("order");
		
		
		List<Alldata> data = ias.showAllPeople(page, rows); 
		Map<String, Object> d = new HashMap<>();
		d.put("rows", data);
		d.put("total",ias.showPeopleCount());
		String message = JSONObject.fromObject(d).toString();
		response.getWriter().print(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
