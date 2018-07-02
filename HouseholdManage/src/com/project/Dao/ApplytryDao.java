package com.project.Dao;

import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.IApplytryDao;
import com.project.entity.Applytrp;

public class ApplytryDao extends BaseDao implements IApplytryDao {

	//查询表中有没有申请记录
	public List<Applytrp> selectIsHadApplytrp(String idcard){
		String sql="select * from applytrp where idcard=?";
		return executeQuery(sql,Applytrp.class, idcard);
	};
	
	//修改申请信息
	public int updateApplytrpInfo(String idcard,String now,String end,String s) {
		String sql="update applytrp set `date`=?,`endDate`=?,`status`=? where idcard=?";
		return executeUpdate(sql, now,end,s,idcard);
	};
	
	//添加申请表
	@Override
	public int insertApplytry(Applytrp atrp) {
		// TODO Auto-generated method stub
		String sql="insert into `applytrp` values(default,?,?,?,?,?,?,?)";
		return executeUpdate(sql, atrp.getIdcard(),atrp.getName(),atrp.getNatives(),atrp.getAddress(),atrp.getDate(),atrp.getEndDate(),"1");
	}
	
	//按类型查询所有申请表
	public List<Applytrp> selectAllApplytrp(int page,int rows,String type){
		String sql="select * from `applytrp` where status=? limit ?,?";
		return executeQuery(sql, Applytrp.class, type,(page-1)*rows,rows);
	}
	
	//查询总条数
	public int selectAllApplytrpCount(String type) {
		String sql="select count(1) from `applytrp` where status=?";
		return countRecord(sql, type);
	};
	
	//根据身份证删除过期记录
	public int deleteOutdateApplytrpByIdcard(String idcard) {
		String sql="delete from applytrp where idcard=?";
		return executeUpdate(sql,idcard);
	};

	//删除处理成功后的记录
	public int deleteApply(String idcard) {
		String sql="delete from applytrp where idcard=?";
		return executeUpdate(sql, idcard);
	};
}
