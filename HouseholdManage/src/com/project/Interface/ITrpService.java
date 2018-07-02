package com.project.Interface;

import java.util.List;

import com.project.entity.Trp;

public interface ITrpService {

	//查
	//查询所有暂住证
	public List<Trp> showAllTrp();
	
	//倒序查询所有暂住证
	public List<Trp> showAllTrpDesc();
	
	//分页查询正序
	public List<Trp> showAllTrp(int page,int size);
	
	//分页查询倒序
	public List<Trp> showAllTrpDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Trp> showAllTrp(int page,int size,String sort,String order);
	
	//通过暂住证ID查询
	public boolean showTrpByTrpid(String TRPID);
	
	public Trp showTrpByTrp(String TRPID);
	
	//通过身份证查询暂住证
	public Trp showTrpByIDCard(String IDCard);
	
	//查询某一地区的暂住证
	public List<Trp> showTrpByAddress(String address);
	
	//查询最后一条数据
	public Trp showLastTrp();
	
	//增
	//增加暂住证
	public int addTrp(Trp trp);
	
	//删
	//删除暂住证
	public int removeTrp(String TRPID);
	
	//改
	//根据暂住证id修改暂住证居住地
	public int updateTrpAddress(Trp trp);
	
	//根据暂住证id修改暂住证日期
	public int updateTrpDate(Trp trp);
	
	//查询表中记录数
	public int showTrpCount();
}
