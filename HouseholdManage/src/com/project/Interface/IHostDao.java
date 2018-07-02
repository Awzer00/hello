package com.project.Interface;

import java.util.Date;
import java.util.List;

import com.project.entity.Host;

public interface IHostDao {
	
	//增
	//新申请房屋租赁许可证
	public int insertHost(Host host);
	
	//改
	//改变许可证信息(如:日期,户主名字等)
	public int updateHost(Host host);
	public int updateDateHost(Host host);
	
	//删
	//删除某一许可证
	public int deleteHost(String licenceID);
	
	//查
	//查询所有房屋许可证户主
	public List<Host> selectAllHost();
	
	//分页
	public List<Host> selectAllHost(int page,int size);
	
	//倒序
	public List<Host> selectAllHostDesc();
	
	//分页倒序
	public List<Host> selectAllHostDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Host> selectAllHost(int page,int size,String sort,String order);
	
	//按照许可证id查找
	public List<Host> selectHostByLicenceID(String licenceID);
	
	//按身份证查找某一房主
	public List<Host> selectHostByIDCard(String IDCard);
	
	//按名字查找某一房主
	public List<Host> selectHostByName(String name);
	
	//按地址查找某一区域房主
	public List<Host> selectHostByNatives(String natives);
	
	//查找某一时间段内的申请的房主
	public List<Host> selectHostByDate(Date begin,Date end);
	
	public int slectHostCount();
	
}
