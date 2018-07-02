package com.project.Interface;

import java.util.List;

import com.project.entity.Applytrp;

public interface IApplytrpService {
	
	//��ѯ������û�������¼
	public boolean showIsHadApplytrp(String idcard);
	
	//���������޸ĵļ�¼
	public int updateApplytrpInfo(String idcard,String now,String end,String s);
	
	//���������
	public int addApplytrp(Applytrp atrp);
	
	//��ѯ���������
	public List<Applytrp> showAllApplytrp(int page,int rows,String type);
	
	//��ѯ���м�¼��
	public int showAllApplytrpCount(String type);
	
	//�������֤ɾ�����ڼ�¼
	public int removeOutdateApplytrpByIdcard(String idcard);
	
	//����ɹ�ɾ����¼
	public int removeApply(String idcard);
}
