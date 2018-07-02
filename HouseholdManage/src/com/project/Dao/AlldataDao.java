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
	
	//查询所有户口
	@Override
	public List<Alldata> selectAllHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata`";
		return executeQuery(sql, Alldata.class);
	}

	//分页查询所有户口
	@Override
	public List<Alldata> selectAlldata(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` order by id desc LIMIT ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*size,size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Alldata> selectAllHousehold(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*page,size);
	}
	
	//倒序查询
	@Override
	public List<Alldata> selectAllHouseholdByDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` ORDER BY id DESC ";
		return executeQuery(sql, Alldata.class);
	}

	//倒序分页
	@Override
	public List<Alldata> selectAllHouseholdByDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `alldata` ORDER BY id DESC limit ?,?";
		return executeQuery(sql, Alldata.class,(page-1)*size,size);
	}
	
	//查询有暂住证的户口
	@Override
	public List<Alldata> selectTrpHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid IS NOT NULL";
		return executeQuery(sql, Alldata.class);
	}

	//查询所有人中没有暂住证
	@Override
	public List<Alldata> selectNoTrpHousehold() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid IS NULL";
		return executeQuery(sql, Alldata.class);
	}

	//通过身份证查找
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
	
	//通过名字查找
	@Override
	public List<Alldata> selectByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `name`=?";
		return executeQuery(sql, Alldata.class, name);
	}
	
	//查询地区名查找该地区范围
	@Override
	public List<Alldata> selectByNatives(String natives) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `natives`=?";
		return executeQuery(sql, Alldata.class, natives);
	}
	
	//查找某一性别的户口
	@Override
	public List<Alldata> selectBySex(String sex) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `sex`=?";
		return executeQuery(sql, Alldata.class, sex);
	}
	
	//查找某一民族的户口
	@Override
	public List<Alldata> selectByNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//查找某一民族的户口数
	@Override
	public List<Alldata> selectCountByNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT count(1) FROM alldata WHERE `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//统计有暂住证中某一性别的
	@Override
	public List<Alldata> selectByTrpAndSex(String sex) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `sex`=?";
		return executeQuery(sql, Alldata.class, sex);
	}

	//统计有暂住证中某一民族
	@Override
	public List<Alldata> selectByTrpAndNation(String nation) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `nation`=?";
		return executeQuery(sql, Alldata.class, nation);
	}
	
	//统计某一地区中有暂住证的户口
	@Override
	public List<Alldata> selectByTrpAndNatives(String natives) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM alldata WHERE trpid is not null and `natives`=?";
		return executeQuery(sql, Alldata.class, natives);
	}

	//增加新来人员
	@Override
	public int insertAlldata(Alldata data) {
		// TODO Auto-generated method stub
		
		String sql="insert into Alldata values(default,?,?,?,?,?,?)";
		return executeUpdate(sql, data.getIdcard(),data.getName(),data.getSex(),data.getNatives(),data.getNation(),data.getTrpid());
	}

	//删除人员
	@Override
	public int deleteAlldata(String IDCard) {
		// TODO Auto-generated method stub
		String sql="delete from Alldata where idcard=?";
		return executeUpdate(sql,IDCard);
	}

	//修改个人信息
	public int updatePeopledata(Alldata data) {
		String sql="UPDATE alldata SET NAME=?,sex=?,natives=?,nation=?,trpid=? WHERE idcard=?";
		return executeUpdate(sql, data.getName(),data.getSex(),data.getNatives(),data.getNation(),data.getTrpid(),data.getIdcard());
	}
	
	//修改有无暂住证
	@Override
	public int updateAlldata(String IDCard, int trpid) {
		// TODO Auto-generated method stub
		String sql="update Alldata set trpid=? where idcard=?";
		return executeUpdate(sql,trpid,IDCard);
	}

}
