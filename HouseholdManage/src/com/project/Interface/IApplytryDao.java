package com.project.Interface;

import java.util.List;

import com.project.entity.Applytrp;

public interface IApplytryDao {
	
	//��ѯ������û�������¼
	public List<Applytrp> selectIsHadApplytrp(String idcard);
	
	//�޸�������Ϣ
	public int updateApplytrpInfo(String idcard,String now,String end,String s);
	
	//���������
	public int insertApplytry(Applytrp atrp);
	
	//�������Ͳ�ѯ����
	public List<Applytrp> selectAllApplytrp(int page,int rows,String type);
	
	//��ѯ������
	public int selectAllApplytrpCount(String type);
	
	
	//�������֤ɾ�����ڼ�¼
	public int deleteOutdateApplytrpByIdcard(String idcard);
	
	//ɾ�������ļ�¼
	public int deleteApply(String idcard);
}
