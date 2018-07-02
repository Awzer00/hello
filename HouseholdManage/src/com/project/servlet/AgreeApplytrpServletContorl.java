package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Dao.ControlApplytrpDao;
import com.project.Interface.IAlldataService;
import com.project.Interface.IApplytrpService;
import com.project.Interface.ITrpService;
import com.project.entity.Trp;
import com.project.service.AlldataService;
import com.project.service.ApplytrpService;
import com.project.service.TrpService;

/**
 * Servlet implementation class AgreeApplytrpServletContorl
 */
@WebServlet("/agreeApplytrpServletContorl")
public class AgreeApplytrpServletContorl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITrpService its=new TrpService();  
    private IAlldataService ias=new  AlldataService();
    private IApplytrpService ia=new ApplytrpService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgreeApplytrpServletContorl() {
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
		
		String idcard=request.getParameter("idcard");
		String name=request.getParameter("name");
		String natives=request.getParameter("natives");
		String address=request.getParameter("address");
		
		Calendar c=Calendar.getInstance();
		Date d=c.getTime();
		c.add(Calendar.YEAR, +3);
		Date dd=c.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String now=sdf.format(d);
		String end=sdf.format(dd);
		
		Trp t=its.showLastTrp();
		int trpid=0;
		if(t==null) {
			trpid=10000;
		}else {
			trpid=t.getTrpid()+1;
		}
	
		
		Trp trp=new Trp();
		trp.setTrpid(trpid);
		trp.setIdcard(idcard);
		trp.setName(name);
		trp.setNatives(natives);
		trp.setAddress(address);
		trp.setBeginDate(now);
		trp.setEndDate(end);
		
		
		ControlApplytrpDao cad=new ControlApplytrpDao();
		int count=0;
		try {
			count=cad.controlApplytrp(trp, idcard, trpid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out=response.getWriter();
		
		if(count==3) {
			out.print("ok");
		}else {
			out.print("error");
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
