package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Interface.IAlldataService;
import com.project.Interface.IApplytrpService;
import com.project.entity.Alldata;
import com.project.entity.Applytrp;
import com.project.service.AlldataService;
import com.project.service.ApplytrpService;

/**
 * Servlet implementation class ApplyTrpServletControl
 */
@WebServlet("/applyTrpServletControl")
public class ApplyTrpServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IApplytrpService ias=new ApplytrpService(); 
    private IAlldataService ialls=new AlldataService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyTrpServletControl() {
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
		String name=request.getParameter("name");
		String natives=request.getParameter("natives");
		String address=request.getParameter("address");
		
		Calendar c=Calendar.getInstance();
		Date now=c.getTime();
		c.add(Calendar.DAY_OF_MONTH, +3);
		Date end=c.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Alldata data=ialls.showPeopleByIDCard(idcard);
		//�ܱ�û������,��ȥ�ܱ�ע��
		if(data==null) {
			out.print("noId");
		}else {
			//�ܱ�������,�ж���û����ס֤
			Alldata d=ialls.showPeopleByIDCard(idcard);
			//����ס֤,ȥ��ʧ
			if(d.getTrpid()!=0) {
				out.print("hadTrp");
			}else {
				//û����ס֤
				boolean bool=ias.showIsHadApplytrp(idcard);
				if(bool) {
					//�������֤��ѯ֮ǰ��û�������¼
					int co=ias.updateApplytrpInfo(idcard,sdf.format(now),sdf.format(end),"1");
					out.print("yes");
				}else {
					//��һ��������ס֤
					Applytrp atrp=new Applytrp();
					atrp.setIdcard(idcard);
					atrp.setName(name);
					atrp.setNatives(natives);
					atrp.setAddress(address);
					atrp.setDate(sdf.format(now));
					atrp.setEndDate(sdf.format(end));
				
					int count=ias.addApplytrp(atrp);
					if(count==1) {
						out.print("ok");
					}else {
						out.print("error");
					}
				}
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
