package com.project.Interface;

import java.util.List;

import com.project.entity.Trp;

public interface ITrpDao {
	
	//查
	//查询所有暂住证
	public List<Trp> selectAllTrp();
	
	//查询最后一条数据
	public List<Trp> selectLastTrp();
	
	//倒序查询所有暂住证
	public List<Trp> selectAllTrpDesc();
	
	//分页查询正序
	public List<Trp> selectAllTrp(int page,int size);
	
	//分页查询倒序
	public List<Trp> selectAllTrpDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Trp> selectAllTrp(int page,int size,String sort,String order);
	
	//通过暂住证ID查询
	public List<Trp> selectTrpByTrpid(String TRPID);
	
	//通过身份证查询暂住证
	public List<Trp> selectTrpByIDCard(String IDCard);
	
	//查询某一地区的暂住证
	public List<Trp> selectTrpByAddress(String address);
	
	//增
	//增加暂住证
	public int insertTrp(Trp trp);
	
	//删
	//删除暂住证
	public int delectTrp(String TRPID);
	
	//改
	//根据暂住证id修改暂住证居住地
	public int updateTrpAddress(Trp trp);
	
	//根据暂住证id修改暂住证日期
	public int updateTrpDate(Trp trp);
	
	//查询总记录数
	public int selectTrpCount();
	
}
