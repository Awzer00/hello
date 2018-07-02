package com.project.Dao;

import java.util.Date;
import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.ITenantDao;
import com.project.entity.Tenant;

public class TenantDao extends BaseDao<Tenant> implements ITenantDao {

	//查看所有房客
	@Override
	public List<Tenant> selectAllTenant() {
		// TODO Auto-generated method stub
		String sql="select * from `tenant`";
		return executeQuery(sql, Tenant.class);
	}

	//倒序
	@Override
	public List<Tenant> selectAllTenantDesc() {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by id desc";
		return executeQuery(sql, Tenant.class);
	}

	//分页查看所有房客
	@Override
	public List<Tenant> selectAllTenant(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//倒序分页查看所有房客
	@Override
	public List<Tenant> selectAllTenantDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by id desc limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Tenant> selectAllTenant(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//查看某一房屋许可证下的所有房客
	@Override
	public List<Tenant> selectTenantByLicenceID(String licenceID) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `licenceId`=?";
		return executeQuery(sql, Tenant.class,licenceID);
	}

	//通过身份证查询房客租房信息
	@Override
	public List<Tenant> selectTenantByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `idcard`=?";
		return executeQuery(sql, Tenant.class,IDCard);
	}

	//通过暂住证号查询房客租房信息
	@Override
	public List<Tenant> selectTenantByTRPID(String TRPID) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `trpid`=?";
		return executeQuery(sql, Tenant.class,TRPID);
	}

	//房东增加新来房客
	@Override
	public int insertTenant(Tenant Tenant) {
		// TODO Auto-generated method stub
		String sql="insert into `tenant` values(default,?,?,?,?,?,?,?)";
		System.out.println("oo");
		return executeUpdate(sql, Tenant.class,Tenant.getLicenceId(),Tenant.getIdcard(),Tenant.getName(),Tenant.getPhone(),Tenant.getTrpid(),Tenant.getBeginDate(),Tenant.getEndDate());
	}

	//房东改变房客信息(电话,日期)
	@Override
	public int updateTenantPhone(Tenant Tenant) {
		// TODO Auto-generated method stub
		String sql="update `tenant` set `phone`=? where idcard=?";
		return executeUpdate(sql, Tenant.getPhone(),Tenant.getIdcard());
	}
	@Override
	public int updateTenantDate(Tenant Tenant) {
		String sql="update `tenant` set `beginDate`=?,`endDate`=? where idcard=?";
		return executeUpdate(sql,Tenant.getBeginDate(),Tenant.getEndDate(),Tenant.getIdcard());
	}

	//房东删除房客信息
	@Override
	public int deleteTenant(String IDCard) {
		// TODO Auto-generated method stub
		String sql="delete from `tenant` where idcard=?";
		return executeUpdate(sql, IDCard);
	}

}
