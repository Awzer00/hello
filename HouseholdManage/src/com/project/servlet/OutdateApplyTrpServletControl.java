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

import com.project.Interface.IApplytrpService;
import com.project.entity.Applytrp;
import com.project.service.ApplytrpService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class OutdateApplyTrpServletControl
 */
@WebServlet("/outdateApplyTrpServletControl")
public class OutdateApplyTrpServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IApplytrpService ias=new ApplytrpService();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutdateApplyTrpServletControl() {
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
		
		String type="0";
		
		List<Applytrp> at=ias.showAllApplytrp(page,rows,type);
		Map<String,Object> map=new HashMap<>();
		map.put("rows", at);
		map.put("total", ias.showAllApplytrpCount(type));
		
		String message=JSONObject.fromObject(map).toString();
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
