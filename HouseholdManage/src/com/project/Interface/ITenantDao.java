package com.project.Interface;

import java.util.Date;
import java.util.List;

import com.project.entity.Tenant;

/**
 * 房客接口,即房东出租房
 * @author baiming
 *
 */
public interface ITenantDao {
	//查
	//查看所有房客
	public List<Tenant> selectAllTenant();
	
	//倒序
	public List<Tenant> selectAllTenantDesc();

	//分页查看所有房客
	public List<Tenant> selectAllTenant(int page,int size);
		
	//倒序分页查看所有房客
	public List<Tenant> selectAllTenantDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Tenant> selectAllTenant(int page,int size,String sort,String order);
	
	//查看某一房屋许可证下的所有房客
	public List<Tenant> selectTenantByLicenceID(String licenceID);
	
	//通过身份证查询房客租房信息
	public List<Tenant> selectTenantByIDCard(String IDCard);
	
	//通过暂住证号查询房客租房信息
	public List<Tenant> selectTenantByTRPID(String TRPID);
	
	//增
	//房东增加新来房客
	public int insertTenant(Tenant Tenant);
	
	//改
	//房东改变房客电话信息
	public int updateTenantPhone(Tenant Tenant);
	
	//房东改变房客日期信息
	public int updateTenantDate(Tenant Tenant);
	
	//删
	//房东删除房客信息
	public int deleteTenant(String IDCard);
		
}
