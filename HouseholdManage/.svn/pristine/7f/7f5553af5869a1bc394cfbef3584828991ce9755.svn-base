package com.project.Dao;

import java.util.Date;
import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.IHostDao;
import com.project.entity.Alldata;
import com.project.entity.Host;

public class HostDao extends BaseDao<Host> implements IHostDao {
	
	//新申请房屋租赁许可证
	@Override
	public int insertHost(Host host) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM HOST";
		return executeUpdate(sql);
	}
	
	
	//改变许可证信息(如:日期,户主名字等)
	@Override
	public int updateHost(Host host) {
		// TODO Auto-generated method stub
		String sql="UPDATE HOST SET `name`=? WHERE `licenceId`=?";
		return executeUpdate(sql,host.getName(),host.getLicenceId());
	}
	@Override
	public int updateDateHost(Host host) {
		// TODO Auto-generated method stub
		String sql="UPDATE HOST SET beginDate=?,endDate=? WHERE `licenceId`=?";
		return executeUpdate(sql,host.getBeginDate(),host.getEndDate(),host.getLicenceId());
	}

	//删除某一许可证
	@Override
	public int deleteHost(String licenceID) {
		// TODO Auto-generated method stub
		String sql="delete from host WHERE `licenceId`=?";
		return executeUpdate(sql,licenceID);
	}
	
	//查询所有房屋许可证户主
	@Override
	public List<Host> selectAllHost() {
		// TODO Auto-generated method stub
		String sql="select * from host";
		return executeQuery(sql, Host.class);
	}
	
	//分页
	@Override
	public List<Host> selectAllHost(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from host limit ?,?";
		return executeQuery(sql, Host.class,(page-1)*size,size);
	}
	
	//倒序
	@Override
	public List<Host> selectAllHostDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM HOST ORDER BY id DESC";
		return executeQuery(sql, Host.class);
	}
	
	//分页倒序
	@Override
	public List<Host> selectAllHostDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM HOST ORDER BY id DESC limit ?,?";
		return executeQuery(sql, Host.class,(page-1)*size,size);
	}
	
	//分页且按照sort进行order排序
	@Override
	public List<Host> selectAllHost(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from host order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Host.class,(page-1)*size,size);
	}
	
	//按照许可证id查找
	@Override
	public List<Host> selectHostByLicenceID(String licenceID) {
		// TODO Auto-generated method stub
		String sql="select * from host where `licenceId`=?";
		return executeQuery(sql, Host.class,licenceID);
	}

	//按身份证查找某一房主
	@Override
	public List<Host> selectHostByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		String sql="select * from host where idcard=?";
		return executeQuery(sql, Host.class,IDCard);
	}
	
	//按名字查找某一房主
	@Override
	public List<Host> selectHostByName(String name) {
		// TODO Auto-generated method stub
		String sql="select * from host where name=?";
		return executeQuery(sql, Host.class,name);
	}
	
	//按地址查找某一区域房主
	@Override
	public List<Host> selectHostByNatives(String natives) {
		// TODO Auto-generated method stub
		String sql="select * from host where natives=?";
		return executeQuery(sql, Host.class,natives);
	}
	
	//查找某一时间段内申请的房主
	@Override
	public List<Host> selectHostByDate(Date begin, Date end) {
		// TODO Auto-generated method stub
		String sql="select * from host where beginDate=? and endDate=?";
		return executeQuery(sql, Host.class,begin,end);
	}
	
	public int slectHostCount() {
		String sql="select count(1) from host";
		return countRecord(sql);
	};

}
