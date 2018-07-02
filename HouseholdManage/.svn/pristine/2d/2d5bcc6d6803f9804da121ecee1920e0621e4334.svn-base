package com.project.Interface;

import java.util.List;

import com.project.entity.Role;

/**
 * 管理员
 * @author baiming
 *
 */
public interface IRoleService {
	
	//登录
	public Role login(String id,String password,String type);
	
	//查
	
	public Role showRole(String logID);
	
	//查询总页数
	public int showTotalPage(int size);
	
	//管理员查看所有人权限
	public List<Role> showAllRole();
	
	//分页
	public List<Role> showAllRole(int page,int size);
	
	//倒序
	public List<Role> showAllRoleDesc();
	
	//分页倒序
	public List<Role> showAllRoleDesc(int page,int size);
	
	//分页且按照sort进行order排序
	public List<Role> showAllRole(int page,int size,String sort,String order);
	
	//管理员通过名字查看某一人的权限
	public List<Role> showRoleByName(String name);
	
	//通过登录号查询
	public boolean showRoleByLogId(String logID);
	
	//查看某一权限的所有人
	public List<Role> showRoleByLimit(String limit);
	
	//查询记录数
	public int showRoleCount();
	
	//增
	//管理员给别人分配权限
	public boolean addRole(Role role);
	
	//改
	//管理员给别人改变权限
	public int updateRole(String limit,String logID);
	
	//重置密码
	public int updateRolePwd(String logPwd,String logID);
	
	//删
	//管理员删除权限
	public int removeRole(String logID);

}
