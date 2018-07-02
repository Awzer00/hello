package com.project.Interface;
import java.util.Date;
import java.util.List;

/**
 * 房东
 */
import com.project.entity.Host;

public interface IHostService {
	//增
	//新申请房屋租赁许可证
	public int addHost(Host host);
	
	//改
	//改变许可证信息(如:日期,户主名字等)
	public int updateHost(Host host);
	public int updateDateHost(Host host);
	
	//删
	//根据许可证号删除某一许可证
	public int removeHost(String licenceID);
	
	//查
	//查询所有房屋许可证户主
	public List<Host> showAllHost();
	
	//倒序
	public List<Host> showAllHostDesc();
	
	//分页
	public List<Host> showAllHost(int page,int size);
	
	//分页倒序
	public List<Host> showAllHostDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Host> showAllHousehold(int page,int size,String sort,String order);
	
	//按照许可证id查找
	public Host showHostByLicenceID(String licenceID);
	
	//按身份证查找某一房主
	public Host showHostByIDCard(String IDCard);
	
	//按名字查找某一房主
	public List<Host> showHostByName(String name);
		
	//查找某一时间段内的申请的房主
	public List<Host> showHostByDate(Date begin,Date end);
	
	public int showHostCount();
	
	public boolean showHost(String licenceID);
	
	public boolean checkHadIDcard(String IDCard);
}
