package com.project.Interface;

import java.util.List;

import com.project.entity.Tenant;

/**
 * ����
 * @author baiming
 *
 */
public interface ITenantService {
	//��
	//�鿴���з���
	public List<Tenant> showAllTenant();
	
	//����
	public List<Tenant> showAllTenantDesc();

	//��ҳ�鿴���з���
	public List<Tenant> showAllTenant(int page,int size);
		
	//�����ҳ�鿴���з���
	public List<Tenant> showAllTenantDesc(int page,int size);
	
	//��ҳ�Ұ���sort����order����
	public List<Tenant> showAllTenant(int page,int size,String sort,String order);
	
	//�鿴ĳһ�������֤�µ����з���
	public List<Tenant> showTenantByLicenceID(String licenceID);
	
	//ͨ�����֤��ѯ�����ⷿ��Ϣ
	public Tenant showTenantByIDCard(String IDCard);
	
	//ͨ����ס֤�Ų�ѯ�����ⷿ��Ϣ
	public Tenant showTenantByTRPID(String TRPID);
	
	//��
	//����������������
	public int addTenant(Tenant Tenant);
	
	//��
	//�����ı䷿�͵绰��Ϣ
	public int updateTenantPhone(Tenant Tenant);
	
	//�����ı䷿��������Ϣ
	public int updateTenantDate(Tenant Tenant);
	
	//ɾ
	//����ɾ��������Ϣ
	public int removeTenant(String IDCard);
}
