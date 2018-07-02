package com.project.Interface;

import java.util.Date;
import java.util.List;

import com.project.entity.Host;

public interface IHostDao {
	
	//��
	//�����뷿���������֤
	public int insertHost(Host host);
	
	//��
	//�ı����֤��Ϣ(��:����,�������ֵ�)
	public int updateHost(Host host);
	public int updateDateHost(Host host);
	
	//ɾ
	//ɾ��ĳһ���֤
	public int deleteHost(String licenceID);
	
	//��
	//��ѯ���з������֤����
	public List<Host> selectAllHost();
	
	//��ҳ
	public List<Host> selectAllHost(int page,int size);
	
	//����
	public List<Host> selectAllHostDesc();
	
	//��ҳ����
	public List<Host> selectAllHostDesc(int page,int size);
	
	//��ҳ�Ұ���sort����order����
	public List<Host> selectAllHost(int page,int size,String sort,String order);
	
	//�������֤id����
	public List<Host> selectHostByLicenceID(String licenceID);
	
	//�����֤����ĳһ����
	public List<Host> selectHostByIDCard(String IDCard);
	
	//�����ֲ���ĳһ����
	public List<Host> selectHostByName(String name);
	
	//����ַ����ĳһ������
	public List<Host> selectHostByNatives(String natives);
	
	//����ĳһʱ����ڵ�����ķ���
	public List<Host> selectHostByDate(Date begin,Date end);
	
	public int slectHostCount();
	
}
