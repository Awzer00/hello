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

import com.project.Interface.IHostService;
import com.project.entity.Host;
import com.project.service.HostService;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class ShowAllHostServletControl
 */
@WebServlet("/showAllHostServletControl")
public class ShowAllHostServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IHostService ihs=new HostService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllHostServletControl() {
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
		
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		
		List<Host> host=
				page==0?
				ihs.showAllHost():
					sort==null?
				ihs.showAllHost(page, rows):
					ihs.showAllHousehold(page, rows, sort, order);
		Map<String,Object> h=new HashMap<>();
		h.put("total", ihs.showHostCount());
		h.put("rows", host);
		String message=JSONObject.fromObject(h).toString();
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
