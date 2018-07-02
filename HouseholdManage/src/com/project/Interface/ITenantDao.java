package com.project.Interface;

import java.util.Date;
import java.util.List;

import com.project.entity.Tenant;

/**
 * ���ͽӿ�,���������ⷿ
 * @author baiming
 *
 */
public interface ITenantDao {
	//��
	//�鿴���з���
	public List<Tenant> selectAllTenant();
	
	//����
	public List<Tenant> selectAllTenantDesc();

	//��ҳ�鿴���з���
	public List<Tenant> selectAllTenant(int page,int size);
		
	//�����ҳ�鿴���з���
	public List<Tenant> selectAllTenantDesc(int page,int size);
	
	//��ҳ�Ұ���sort����order����
	public List<Tenant> selectAllTenant(int page,int size,String sort,String order);
	
	//�鿴ĳһ�������֤�µ����з���
	public List<Tenant> selectTenantByLicenceID(String licenceID);
	
	//ͨ�����֤��ѯ�����ⷿ��Ϣ
	public List<Tenant> selectTenantByIDCard(String IDCard);
	
	//ͨ����ס֤�Ų�ѯ�����ⷿ��Ϣ
	public List<Tenant> selectTenantByTRPID(String TRPID);
	
	//��
	//����������������
	public int insertTenant(Tenant Tenant);
	
	//��
	//�����ı䷿�͵绰��Ϣ
	public int updateTenantPhone(Tenant Tenant);
	
	//�����ı䷿��������Ϣ
	public int updateTenantDate(Tenant Tenant);
	
	//ɾ
	//����ɾ��������Ϣ
	public int deleteTenant(String IDCard);
		
}
