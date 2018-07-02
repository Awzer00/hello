package com.project.Dao;

import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.ITrpDao;
import com.project.entity.Trp;

public class TrpDao extends BaseDao<Trp> implements ITrpDao {

	//查询所有暂住证
	@Override
	public List<Trp> selectAllTrp() {
		// TODO Auto-generated method stub
		String sql="select * from `trp` order by trpid desc";
		return executeQuery(sql, Trp.class);
	}

	
	//查询最后一条数据
	public List<Trp> selectLastTrp(){
		String sql="select * from trp order by `trpid` desc limit 1";
		return executeQuery(sql, Trp.class);
	};
	
	//倒序查询所有暂住证
	@Override
	public List<Trp> selectAllTrpDesc() {
		// TODO Auto-generated method stub
		String sql="select * from `trp` order by trpid desc";
		return executeQuery(sql, Trp.class);
	}
	
	//分页查询正序
	@Override
	public List<Trp> selectAllTrp(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` limit ?,?";
		return executeQuery(sql, Trp.class,(page-1)*size,size);
	}

	//分页查询倒序
	@Override
	public List<Trp> selectAllTrpDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` order by id desc limit ?,?";
		return executeQuery(sql, Trp.class,(page-1)*size,size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Trp> selectAllTrp(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Trp.class,(page-1)*size,size);
	}

	//通过暂住证ID查询
	@Override
	public List<Trp> selectTrpByTrpid(String TRPID) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` where `trpid`=?";
		return executeQuery(sql,Trp.class,TRPID);
	}
    
	//通过身份证查询暂住证
	@Override
	public List<Trp> selectTrpByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` where idcard=?";
		return executeQuery(sql, Trp.class,IDCard);
	}

	//查询某一地区的暂住证
	@Override
	public List<Trp> selectTrpByAddress(String address) {
		// TODO Auto-generated method stub
		String sql="select * from `trp` where address=?";
		return executeQuery(sql, Trp.class,address);
	}

	//增加暂住证
	@Override
	public int insertTrp(Trp trp) {
		// TODO Auto-generated method stub
		String sql="insert into `trp` values(?,?,?,?,?,?,?)";
		return executeUpdate(sql,trp.getTrpid(),trp.getIdcard(),trp.getName(),trp.getNatives(),trp.getAddress(),trp.getBeginDate(),trp.getEndDate());
	}

	//删除暂住证
	@Override
	public int delectTrp(String TRPID) {
		// TODO Auto-generated method stub
		String sql="delete from `trp` where trpid=?";
		return executeUpdate(sql,TRPID);
	}

	//根据暂住证id修改暂住证居住地
	@Override
	public int updateTrpAddress(Trp trp) {
		// TODO Auto-generated method stub
		String sql="update `trp` set address=? where trpid=?";
		return executeUpdate(sql,trp.getAddress(),trp.getTrpid());
	}

	//根据暂住证id修改暂住证日期
	@Override
	public int updateTrpDate(Trp trp) {
		// TODO Auto-generated method stub
		String sql="update `trp` set `beginDate`=?,`endDate`=? where trpid=?";
		return executeUpdate(sql,trp.getBeginDate(),trp.getEndDate(),trp.getTrpid());
	}
	
	//查询记录数
	public int selectTrpCount() {
		return countRecord("select count(1) from trp");
	};
}
