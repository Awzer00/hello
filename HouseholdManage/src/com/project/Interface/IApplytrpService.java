package com.project.Interface;

import java.util.List;

import com.project.entity.Applytrp;

public interface IApplytrpService {
	
	//查询表中有没有申请记录
	public boolean showIsHadApplytrp(String idcard);
	
	//重新申请修改的记录
	public int updateApplytrpInfo(String idcard,String now,String end,String s);
	
	//增加申请表
	public int addApplytrp(Applytrp atrp);
	
	//查询所有申请表
	public List<Applytrp> showAllApplytrp(int page,int rows,String type);
	
	//查询所有记录数
	public int showAllApplytrpCount(String type);
	
	//根据身份证删除过期记录
	public int removeOutdateApplytrpByIdcard(String idcard);
	
	//处理成功删除记录
	public int removeApply(String idcard);
}
