package com.project.Dao;

import java.sql.Connection;
import java.util.List;
import com.project.DBManager.BaseDao;
import com.project.Interface.IAlldataDao;
import com.project.entity.Alldata;
import com.project.entity.Host;
import com.project.entity.Tenant;

public class AlldataDao extends BaseDao<Alldata> implements IAlldataDao {
	
	public int selectPeopleCount() {
		String sql="select count(1) from Alldata";
		return countRecord(sql);
	};
	
	//��ѯ���л���
	@Override
	public List<Alldata> selectAllHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata`";
		return executeQuery(sql, Alldata.class);
	}

	//��ҳ��ѯ���л���
	@Override
	public List<Alldata> selectAlldata(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` order by id desc LIMIT ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*size,size);
	}

	//��ҳ�Ұ���sort����order����
	@Override
	public List<Alldata> selectAllHousehold(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*page,size);
	}
	
	//�����ѯ
	@Override
	public List<Alldata> selectAllHouseholdByDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` ORDER BY id DESC ";
		return executeQuery(sql, Alldata.class);
	}

	//�����ҳ
	@Override
	public List<Alldata> selectAllHouseholdByDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` ORDER BY id DESC limit ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*size,size);
	}
	
	//��ѯ����ס֤�Ļ���
	@Override
	public List<Alldata> selectTrpHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid IS NOT NULL";
		return executeQuery(sql, Alldata.class);
	}

	//��ѯ��������û����ס֤
	@Override
	public List<Alldata> selectNoTrpHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid IS NULL";
		return executeQuery(sql, Alldata.class);
	}

	//ͨ�����֤����
	@Override
	public Alldata selectByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `idcard`=?";
		List<Alldata> data=executeQuery(sql, Alldata.class, IDCard);
		if(data.size()>0) {
			return data.get(0);
		}
		return null;
	}
	
	//ͨ�����ֲ���
	@Override
	public List<Alldata> selectByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `name`=?";
		return executeQuery(sql, Alldata.class, name);
	}
	
	//��ѯ���������Ҹõ�����Χ
	@Override
	public List<Alldata> selectByNatives(String natives) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `natives`=?";
		return executeQuery(sql, Alldata.class, natives);
	}
	
	//����ĳһ�Ա�Ļ���
	@Override
	public List<Alldata> selectBySex(String sex) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `sex`=?";
		return executeQuery(sql, Alldata.class, sex);
	}
	
	//����ĳһ����Ļ���
	@Override
	public List<Alldata> selectByNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//����ĳһ����Ļ�����
	@Override
	public List<Alldata> selectCountByNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT count(1) FROM alldata WHERE `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//ͳ������ס֤��ĳһ�Ա��
	@Override
	public List<Alldata> selectByTrpAndSex(String sex) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `sex`=?";
		return executeQuery(sql, Alldata.class, sex);
	}

	//ͳ������ס֤��ĳһ����
	@Override
	public List<Alldata> selectByTrpAndNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//ͳ��ĳһ����������ס֤�Ļ���
	@Override
	public List<Alldata> selectByTrpAndNatives(String natives) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `natives`=?";
		return executeQuery(sql, Alldata.class, natives);
	}

	//����������Ա
	@Override
	public int insertAlldata(Alldata data) {
		// TODO Auto-generated method stub
		
		String sql="insert into Alldata values(default,?,?,?,?,?,?)";
		return executeUpdate(sql, data.getIdcard(),data.getName(),data.getSex(),data.getNatives(),data.getNation(),data.getTrpid());
	}

	//ɾ����Ա
	@Override
	public int deleteAlldata(String IDCard) {
		// TODO Auto-generated method stub
		String sql="delete from Alldata where idcard=?";
		return executeUpdate(sql,IDCard);
	}

	//�޸ĸ�����Ϣ
	public int updatePeopledata(Alldata data) {
		String sql="UPDATE alldata SET NAME=?,sex=?,natives=?,nation=?,trpid=? WHERE idcard=?";
		return executeUpdate(sql, data.getName(),data.getSex(),data.getNatives(),data.getNation(),data.getTrpid(),data.getIdcard());
	}
	
	//�޸�������ס֤
	@Override
	public int updateAlldata(String IDCard, int trpid) {
		// TODO Auto-generated method stub
		String sql="update Alldata set trpid=? where idcard=?";
		return executeUpdate(sql,trpid,IDCard);
	}

}
