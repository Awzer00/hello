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

import com.project.Interface.IRoleService;
import com.project.entity.Role;
import com.project.service.RoleService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowPowerServlet
 */
@WebServlet("/showAllPowerServletControl")
public class ShowAllPowerServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoleService irs=new RoleService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllPowerServletControl() {
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
		
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		
		
		List<Role> role = 
				page==0 ?
				irs.showAllRole(): 
					sort == null ?
				irs.showAllRole(page, rows) :
					irs.showAllRole(page, rows, sort, order);	
		
		Map<String, Object> r = new HashMap<>();
		r.put("rows", role);
		r.put("total",irs.showRoleCount());
		String message = JSONObject.fromObject(r).toString();
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
