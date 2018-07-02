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

import com.project.Interface.ITrpService;
import com.project.entity.Trp;
import com.project.service.TrpService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowAllTrpServletControl
 */
@WebServlet("/showAllTrpServletControl")
public class ShowAllTrpServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITrpService its=new TrpService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllTrpServletControl() {
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
		
		int page=0;
		int rows=0;
				
		try {
			page=Integer.parseInt(request.getParameter("page"));
			rows=Integer.parseInt(request.getParameter("rows"));
		} catch (Exception e) {
			// TODO: handle exception
			page=0;
			rows=0;
		}		
		
		List<Trp> trp=its.showAllTrp();
		Map<String,Object> m=new HashMap<>();
		m.put("rows", trp);
		m.put("total",its.showTrpCount());
		
		String message=JSONObject.fromObject(m).toString();
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
