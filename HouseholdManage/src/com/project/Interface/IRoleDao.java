package com.project.Interface;

import java.util.List;
import com.project.entity.Role;


public interface IRoleDao {
	
	
	//登录
	public List<Role> roleLogin(String id,String password,String type);
	
	//查
	
	public List<Role> selectRole(String logID);
	
	//查询总页数
	public int selectTotalPage(int size);
	
	//管理员查看所有人权限
	public List<Role> selectAllRole();
	
	//分页
	public List<Role> selectAllRole(int page,int size);
	
	//倒序
	public List<Role> selectAllRoleDesc();
	
	//分页倒序
	public List<Role> selectAllRoleDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Role> selectAllRole(int page,int size,String sort,String order);
	
	//管理员通过名字查看某一人的权限
	public List<Role> selectRoleByName(String name);
	
	//通过登录号查询
	public List<Role> selectRoleByLogId(String logID);
	
	//查看某一权限的所有人
	public List<Role> selectRoleByLimit(String limit);
	
	//查看记录数
	public int selectRoleCount();
	
	//增
	//管理员给别人分配权限
	public int insertRole(Role role);
	
	//改
	//管理员给别人改变权限
	public int updateRole(String limit,String logID);
	
	//重置密码
	public int updateRolePwd(String logPwd,String logID);
	
	
	//删
	//管理员删除权限
	public int deleteRole(String logID);
		
}
