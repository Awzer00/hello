package com.project.service;

import java.util.List;

import com.project.Dao.TenantDao;
import com.project.Interface.ITenantDao;
import com.project.Interface.ITenantService;
import com.project.entity.Tenant;

public class TenantService implements ITenantService {

	private ITenantDao itd=new TenantDao();
	
	//查看所有房客
	@Override
	public List<Tenant> showAllTenant() {
		// TODO Auto-generated method stub
		return itd.selectAllTenant();
	}

	//倒序
	@Override
	public List<Tenant> showAllTenantDesc() {
		// TODO Auto-generated method stub
		return itd.selectAllTenantDesc();
	}

	//分页查看所有房客
	@Override
	public List<Tenant> showAllTenant(int page, int size) {
		// TODO Auto-generated method stub
		return itd.selectAllTenant(page, size);
	}

	//倒序分页查看所有房客
	@Override
	public List<Tenant> showAllTenantDesc(int page, int size) {
		// TODO Auto-generated method stub
		return itd.selectAllTenantDesc(page, size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Tenant> showAllTenant(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		return itd.selectAllTenant(page, size, sort, order);
	}

	//查看某一房屋许可证下的所有房客
	@Override
	public List<Tenant> showTenantByLicenceID(String licenceID) {
		// TODO Auto-generated method stub
		return itd.selectTenantByLicenceID(licenceID);
	}

	//通过身份证查询房客租房信息
	@Override
	public Tenant showTenantByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		List<Tenant> tenant=itd.selectTenantByIDCard(IDCard);
		return tenant.get(0);
	}

	//通过暂住证号查询房客租房信息
	@Override
	public Tenant showTenantByTRPID(String TRPID) {
		// TODO Auto-generated method stub
		List<Tenant> tenant=itd.selectTenantByTRPID(TRPID);
		return tenant.get(0);
	}

	//房东增加新来房客
	@Override
	public int addTenant(Tenant Tenant) {
		// TODO Auto-generated method stub
		return itd.insertTenant(Tenant);
	}

	//房东改变房客信息(电话,日期)
	@Override
	public int updateTenantPhone(Tenant Tenant) {
		// TODO Auto-generated method stub
		return itd.updateTenantPhone(Tenant);
	}
	@Override
	public int updateTenantDate(Tenant Tenant) {
		// TODO Auto-generated method stub
		return itd.updateTenantDate(Tenant);
	}

	//房东根据身份证删除房客信息
	@Override
	public int removeTenant(String IDCard) {
		// TODO Auto-generated method stub
		return itd.deleteTenant(IDCard);
	}

}
