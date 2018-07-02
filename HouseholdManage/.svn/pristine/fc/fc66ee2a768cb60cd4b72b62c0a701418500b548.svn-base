package com.project.Interface;

import java.util.List;

import com.project.entity.Tenant;

/**
 * 房客
 * @author baiming
 *
 */
public interface ITenantService {
	//查
	//查看所有房客
	public List<Tenant> showAllTenant();
	
	//倒序
	public List<Tenant> showAllTenantDesc();

	//分页查看所有房客
	public List<Tenant> showAllTenant(int page,int size);
		
	//倒序分页查看所有房客
	public List<Tenant> showAllTenantDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Tenant> showAllTenant(int page,int size,String sort,String order);
	
	//查看某一房屋许可证下的所有房客
	public List<Tenant> showTenantByLicenceID(String licenceID);
	
	//通过身份证查询房客租房信息
	public Tenant showTenantByIDCard(String IDCard);
	
	//通过暂住证号查询房客租房信息
	public Tenant showTenantByTRPID(String TRPID);
	
	//增
	//房东增加新来房客
	public int addTenant(Tenant Tenant);
	
	//改
	//房东改变房客电话信息
	public int updateTenantPhone(Tenant Tenant);
	
	//房东改变房客日期信息
	public int updateTenantDate(Tenant Tenant);
	
	//删
	//房东删除房客信息
	public int removeTenant(String IDCard);
}
