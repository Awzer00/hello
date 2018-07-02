package com.project.Dao;

import java.util.Date;
import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.ITenantDao;
import com.project.entity.Tenant;

public class TenantDao extends BaseDao<Tenant> implements ITenantDao {

	//�鿴���з���
	@Override
	public List<Tenant> selectAllTenant() {
		// TODO Auto-generated method stub
		String sql="select * from `tenant`";
		return executeQuery(sql, Tenant.class);
	}

	//����
	@Override
	public List<Tenant> selectAllTenantDesc() {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by id desc";
		return executeQuery(sql, Tenant.class);
	}

	//��ҳ�鿴���з���
	@Override
	public List<Tenant> selectAllTenant(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//�����ҳ�鿴���з���
	@Override
	public List<Tenant> selectAllTenantDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by id desc limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//��ҳ�Ұ���sort����order����
	@Override
	public List<Tenant> selectAllTenant(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Tenant.class,(page-1)*size,size);
	}

	//�鿴ĳһ�������֤�µ����з���
	@Override
	public List<Tenant> selectTenantByLicenceID(String licenceID) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `licenceId`=?";
		return executeQuery(sql, Tenant.class,licenceID);
	}

	//ͨ�����֤��ѯ�����ⷿ��Ϣ
	@Override
	public List<Tenant> selectTenantByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `idcard`=?";
		return executeQuery(sql, Tenant.class,IDCard);
	}

	//ͨ����ס֤�Ų�ѯ�����ⷿ��Ϣ
	@Override
	public List<Tenant> selectTenantByTRPID(String TRPID) {
		// TODO Auto-generated method stub
		String sql="select * from `tenant` where `trpid`=?";
		return executeQuery(sql, Tenant.class,TRPID);
	}

	//����������������
	@Override
	public int insertTenant(Tenant Tenant) {
		// TODO Auto-generated method stub
		String sql="insert into `tenant` values(default,?,?,?,?,?,?,?)";
		System.out.println("oo");
		return executeUpdate(sql, Tenant.class,Tenant.getLicenceId(),Tenant.getIdcard(),Tenant.getName(),Tenant.getPhone(),Tenant.getTrpid(),Tenant.getBeginDate(),Tenant.getEndDate());
	}

	//�����ı䷿����Ϣ(�绰,����)
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

	//����ɾ��������Ϣ
	@Override
	public int deleteTenant(String IDCard) {
		// TODO Auto-generated method stub
		String sql="delete from `tenant` where idcard=?";
		return executeUpdate(sql, IDCard);
	}

}
