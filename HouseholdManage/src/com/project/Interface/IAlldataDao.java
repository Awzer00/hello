package com.project.Interface;

import java.util.List;

import com.project.entity.Alldata;
import com.project.entity.Host;
import com.project.entity.Tenant;

public interface IAlldataDao {
	
	//��
	public int selectPeopleCount();
	
	//��ѯ���л���
	public List<Alldata> selectAllHousehold();
	
	//��ҳ��ѯ���л���
	public List<Alldata> selectAlldata(int page,int size);
	
	//��ҳ�Ұ���sort����order����
	public List<Alldata> selectAllHousehold(int page,int size,String sort,String order);
	
	//�����ѯ
	public List<Alldata> selectAllHouseholdByDesc();
	
	//�����ѯ��ҳ
	public List<Alldata> selectAllHouseholdByDesc(int page,int size);
	
	//��ѯ����ס֤�Ļ���
	public List<Alldata> selectTrpHousehold();
	
	//��ѯ����û����ס֤
	public List<Alldata> selectNoTrpHousehold();
	
	//ͨ�����֤����
	public Alldata selectByIDCard(String IDCard);
	
	//ͨ�����ֲ���
	public List<Alldata> selectByName(String name);
	
	//��ѯ���������Ҹõ�����Χ����
	public List<Alldata> selectByNatives(String natives);
	
	//����ĳһ�Ա�Ļ���
	public List<Alldata> selectBySex(String sex);
	
	//����ĳһ����Ļ���
	public List<Alldata> selectByNation(String nation);
	
	//����ĳһ��������
	public List<Alldata> selectCountByNation(String nation);
	
	//ͳ������ס֤��ĳһ�Ա�����
	public List<Alldata> selectByTrpAndSex(String sex);
	
	//ͳ������ס֤��ĳһ��������
	public List<Alldata> selectByTrpAndNation(String nation);
	
	//ͳ��ĳһ����������ס֤�Ļ���
	public List<Alldata> selectByTrpAndNatives(String natives);
	
	//��
	//����������Ա
	public int insertAlldata(Alldata data);
	
	//ɾ
	//ɾ����Ա
	public int deleteAlldata(String IDCard);
	
	//��
	//�޸ĸ�����Ϣ
	public int updatePeopledata(Alldata data);
	
	//�޸�������ס֤
	public int updateAlldata(String IDCard,int TRPID);
	
	
	
}
