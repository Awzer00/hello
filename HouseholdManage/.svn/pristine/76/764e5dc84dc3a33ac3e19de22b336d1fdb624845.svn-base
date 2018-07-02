package com.project.Dao;

import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.IRoleDao;
import com.project.entity.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao {
	
	//登录
	public List<Role> roleLogin(String id,String password,String type) {
		String sql="SELECT * FROM role WHERE logId=? AND logPwd=PASSWORD(?) AND rlimit=?";
		return executeQuery(sql, Role.class,id,password,type);
	}
	
	public List<Role> selectRole(String logID){
		String sql="SELECT * FROM role WHERE logId=?";
		return executeQuery(sql, Role.class, logID);
	};
	
	//查询总页数
	public int selectTotalPage(int size) {
		int count=selectRoleCount();
		return count % size==0 ? count / size : count / size +1;
	}
	
	//管理员查看所有人权限
	@Override
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role";
		return executeQuery(sql, Role.class);
	}

	//分页
	@Override
	public List<Role> selectAllRole(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}
	
	//倒序
	@Override
	public List<Role> selectAllRoleDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role order by id desc";
		return executeQuery(sql, Role.class);
	}

	//分页倒序
	@Override
	public List<Role> selectAllRoleDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role order by id desc limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Role> selectAllRole(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from role order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}
	
	//根据登录号查询是否存在
	public List<Role> selectRoleByLogId(String logID){
		String sql="select * from role WHERE logId=?";
		return executeQuery(sql, Role.class,logID);
	}
	
	//管理员通过名字查看某一人的权限
	@Override
	public List<Role> selectRoleByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role where name=?";
		return executeQuery(sql, Role.class,name);
	}

	//查看记录数
	public int selectRoleCount(){
		String sql="select count(1) from role";
		return countRecord(sql);
	};
	
	//查看某一权限的所有人
	@Override
	public List<Role> selectRoleByLimit(String limit) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role where `rlimit`=?";
		return executeQuery(sql, Role.class,limit);
	}

	//管理员给别人分配权限
	@Override
	public int insertRole(Role role) {
		// TODO Auto-generated method stub
		String sql="insert into role values(default,?,?,password(?),?)";
		return executeUpdate(sql, role.getRoleName(),role.getLogId(),role.getLogPwd(),role.getRlimit());
	}
	
	//管理员给别人改变权限
	@Override
	public int updateRole(String limit,String logID) {
		// TODO Auto-generated method stub
		String sql="update role set `rlimit`=? where `logId`=?";
		return executeUpdate(sql, limit,logID);
	}
	
	//重置密码
	@Override
	public int updateRolePwd(String logPwd,String logID) {
		// TODO Auto-generated method stub
		String sql="update role set `logPwd`=password(?) where `logId`=?";
		return executeUpdate(sql, logPwd,logID);
	}

	//管理员删除权限
	@Override
	public int deleteRole(String logID) {
		// TODO Auto-generated method stub
		String sql="delete from role where `logId`=?";
		return executeUpdate(sql,logID);
	}

}
