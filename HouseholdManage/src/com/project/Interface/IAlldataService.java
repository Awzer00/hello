package com.project.Interface;

import java.util.List;

import com.project.entity.Alldata;

/**
 * 总表
 * @author baiming
 *
 */
public interface IAlldataService {

	//查
	//查询所有记录数
	public int showPeopleCount();
	
	//查看所有户口
	public List<Alldata> showAllPeople();
	
	//分页查询所有户口
	public List<Alldata> showAllPeople(int page,int size);
	
	//倒序查询
	public List<Alldata> showAllPeopleDesc();
	
	//倒序查询分页
	public List<Alldata> showAllPeopleDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Alldata> showAllPeople(int page,int size,String sort,String order);

	//查询有暂住证的户口
	public List<Alldata> showTrpPeople();
	
	//查询所有没有暂住证
	public List<Alldata> showNoTrpPeople();
	
	//通过身份证查找
	public Alldata showPeopleByIDCard(String IDCard);
	
	//通过名字查找
	public List<Alldata> showPeopleByName(String name);
	
	//查询地区名查找该地区范围的人
	public List<Alldata> showPeopleByNatives(String natives);
	
	//查找某一性别的户口
	public List<Alldata> showPeopleBySex(String sex);
	
	//查找某一民族的户口
	public List<Alldata> showPeopleByNation(String nation);
	
	//查找某一民族人数
	public List<Alldata> showPeopleCountByNation(String nation);
	
	//统计有暂住证中某一性别人数
	public List<Alldata> showPeopleByTrpAndSex(String sex);
	
	//统计有暂住证中某一民族人数
	public List<Alldata> showPeopleByTrpAndNation(String nation);
	
	//统计某一地区中有暂住证的户口
	public List<Alldata> showPeopleByTrpAndNatives(String natives);
	
	//增
	//增加新来人员
	public int addNewPeople(Alldata data);
	
	//删除人员
	public int removePeople(String IDCard);
	//修改人员信息
	public int updatePeople(Alldata data);
	
	//修改有无暂住证
	public int updateTrpStatus(String IDCard,int TRPID);
	
	
}
