package com.project.Interface;

import java.util.List;

import com.project.entity.Applytrp;

public interface IApplytryDao {
	
	//查询表中有没有申请记录
	public List<Applytrp> selectIsHadApplytrp(String idcard);
	
	//修改申请信息
	public int updateApplytrpInfo(String idcard,String now,String end,String s);
	
	//增加申请表
	public int insertApplytry(Applytrp atrp);
	
	//根据类型查询所有
	public List<Applytrp> selectAllApplytrp(int page,int rows,String type);
	
	//查询总条数
	public int selectAllApplytrpCount(String type);
	
	
	//根据身份证删除过期记录
	public int deleteOutdateApplytrpByIdcard(String idcard);
	
	//删除处理后的记录
	public int deleteApply(String idcard);
}
