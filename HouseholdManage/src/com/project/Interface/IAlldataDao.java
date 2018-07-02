package com.project.Interface;

import java.util.List;

import com.project.entity.Alldata;
import com.project.entity.Host;
import com.project.entity.Tenant;

public interface IAlldataDao {
	
	//查
	public int selectPeopleCount();
	
	//查询所有户口
	public List<Alldata> selectAllHousehold();
	
	//分页查询所有户口
	public List<Alldata> selectAlldata(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Alldata> selectAllHousehold(int page,int size,String sort,String order);
	
	//倒序查询
	public List<Alldata> selectAllHouseholdByDesc();
	
	//倒序查询分页
	public List<Alldata> selectAllHouseholdByDesc(int page,int size);
	
	//查询有暂住证的户口
	public List<Alldata> selectTrpHousehold();
	
	//查询所有没有暂住证
	public List<Alldata> selectNoTrpHousehold();
	
	//通过身份证查找
	public Alldata selectByIDCard(String IDCard);
	
	//通过名字查找
	public List<Alldata> selectByName(String name);
	
	//查询地区名查找该地区范围的人
	public List<Alldata> selectByNatives(String natives);
	
	//查找某一性别的户口
	public List<Alldata> selectBySex(String sex);
	
	//查找某一民族的户口
	public List<Alldata> selectByNation(String nation);
	
	//查找某一民族人数
	public List<Alldata> selectCountByNation(String nation);
	
	//统计有暂住证中某一性别人数
	public List<Alldata> selectByTrpAndSex(String sex);
	
	//统计有暂住证中某一民族人数
	public List<Alldata> selectByTrpAndNation(String nation);
	
	//统计某一地区中有暂住证的户口
	public List<Alldata> selectByTrpAndNatives(String natives);
	
	//增
	//增加新来人员
	public int insertAlldata(Alldata data);
	
	//删
	//删除人员
	public int deleteAlldata(String IDCard);
	
	//改
	//修改个人信息
	public int updatePeopledata(Alldata data);
	
	//修改有无暂住证
	public int updateAlldata(String IDCard,int TRPID);
	
	
	
}
