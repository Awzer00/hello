package com.project.service;

import java.util.List;

import com.project.Dao.ApplytryDao;
import com.project.Interface.IApplytrpService;
import com.project.Interface.IApplytryDao;
import com.project.entity.Applytrp;


public class ApplytrpService implements IApplytrpService {
	private IApplytryDao iad=new ApplytryDao();
	
	//查询表中有没有申请记录
	public boolean showIsHadApplytrp(String idcard) {
		boolean bool=false;
		try {
			List<Applytrp> at=iad.selectIsHadApplytrp(idcard);
			bool=at.size()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	};
	
	//重新申请修改的记录
		public int updateApplytrpInfo(String idcard,String now,String end,String s) {
			return iad.updateApplytrpInfo(idcard,now,end,s);
		};
	
	//申请表
	@Override
	public int addApplytrp(Applytrp atrp) {
		// TODO Auto-generated method stub
		return iad.insertApplytry(atrp);
	}
	
	//查询所有表
	public List<Applytrp> showAllApplytrp(int page,int rows,String type){
		return iad.selectAllApplytrp(page,rows,type);
	}
	
	//查询总条数
	public int showAllApplytrpCount(String type) {
		return iad.selectAllApplytrpCount(type);
	};

	
	//根据身份证删除过期记录
	public int removeOutdateApplytrpByIdcard(String idcard) {
		return iad.deleteOutdateApplytrpByIdcard( idcard);
	};
	
	//处理成功删除记录
	public int removeApply(String idcard) {
		return iad.deleteApply(idcard);
	};
}
