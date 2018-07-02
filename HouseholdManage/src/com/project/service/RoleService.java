package com.project.service;

import java.util.List;

import com.project.Dao.RoleDao;
import com.project.Interface.IRoleDao;
import com.project.Interface.IRoleService;
import com.project.entity.Role;

public class RoleService implements IRoleService {
	private IRoleDao ird=new RoleDao();
	
	//登录
	public Role login(String id,String password,String type){
		List<Role> roleList= ird.roleLogin(id, password, type);
		if(roleList.size()==0) {
			return null;
		}else {
			return roleList.get(0);
		}
	}
	
	public Role showRole(String logID) {
		List<Role> role=ird.selectRole(logID);
		try {
			if(role.size()==0) {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return role.get(0);
	}
	
	//查询总页数
	public int showTotalPage(int size) {
		return ird.selectTotalPage(size);
	};
	
	//管理员查看所有人权限
	@Override
	public List<Role> showAllRole() {
		// TODO Auto-generated method stub
		return ird.selectAllRole();
	}

	//分页
	@Override
	public List<Role> showAllRole(int page, int size) {
		// TODO Auto-generated method stub
		return ird.selectAllRole(page, size);
	}

	//倒序
	@Override
	public List<Role> showAllRoleDesc() {
		// TODO Auto-generated method stub
		return ird.selectAllRoleDesc();
	}

	//分页倒序
	@Override
	public List<Role> showAllRoleDesc(int page, int size) {
		// TODO Auto-generated method stub
		return ird.selectAllRoleDesc(page, size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Role> showAllRole(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		return ird.selectAllRole(page, size, sort, order);
	}

	//管理员通过名字查看某人的权限
	@Override
	public List<Role> showRoleByName(String name) {
		// TODO Auto-generated method stub
		return ird.selectRoleByName(name);
	}

	//根据登录号查询
	public boolean showRoleByLogId(String logID) {
		boolean bool=false;
	    try {
	    	List<Role> role=ird.selectRoleByLogId(logID);
	    	bool=role.size()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
	    return bool;
	};
	
	//查看某权限的所有人
	@Override
	public List<Role> showRoleByLimit(String limit) {
		// TODO Auto-generated method stub
		return ird.selectRoleByLimit(limit);
	}
	
	//查看记录数
	public int showRoleCount() {
		return ird.selectRoleCount();
	};

	//管理员给别人分配权限
	@Override
	public boolean addRole(Role role) {
		// TODO Auto-generated method stub
		boolean bool=false;
		try {
			int c=ird.insertRole(role);
			bool=c==1?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}

	//管理员给别人改变权限
	@Override
	public int updateRole(String limit, String logID) {
		// TODO Auto-generated method stub
		return ird.updateRole(limit, logID);
	}

	//重置密码
	@Override
	public int updateRolePwd(String logPwd, String logID) {
		// TODO Auto-generated method stub
		return ird.updateRolePwd(logPwd, logID);
	}

	//管理员删除权限
	@Override
	public int removeRole(String logID) {
		// TODO Auto-generated method stub
		return ird.deleteRole(logID);
	}

}
