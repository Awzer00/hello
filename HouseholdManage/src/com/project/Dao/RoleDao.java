package com.project.Dao;

import java.util.List;

import com.project.DBManager.BaseDao;
import com.project.Interface.IRoleDao;
import com.project.entity.Role;

public class RoleDao extends BaseDao<Role> implements IRoleDao {
	
	//��¼
	public List<Role> roleLogin(String id,String password,String type) {
		String sql="SELECT * FROM role WHERE logId=? AND logPwd=PASSWORD(?) AND rlimit=?";
		return executeQuery(sql, Role.class,id,password,type);
	}
	
	public List<Role> selectRole(String logID){
		String sql="SELECT * FROM role WHERE logId=?";
		return executeQuery(sql, Role.class, logID);
	};
	
	//��ѯ��ҳ��
	public int selectTotalPage(int size) {
		int count=selectRoleCount();
		return count % size==0 ? count / size : count / size +1;
	}
	
	//����Ա�鿴������Ȩ��
	@Override
	public List<Role> selectAllRole() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role";
		return executeQuery(sql, Role.class);
	}

	//��ҳ
	@Override
	public List<Role> selectAllRole(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}
	
	//����
	@Override
	public List<Role> selectAllRoleDesc() {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role order by id desc";
		return executeQuery(sql, Role.class);
	}

	//��ҳ����
	@Override
	public List<Role> selectAllRoleDesc(int page, int size) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role order by id desc limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}

	//��ҳ�Ұ���sort����order����
	@Override
	public List<Role> selectAllRole(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		String sql="select * from role order by "+sort+" "+order+" limit ?,?";
		return executeQuery(sql, Role.class,(page-1)*size,size);
	}
	
	//���ݵ�¼�Ų�ѯ�Ƿ����
	public List<Role> selectRoleByLogId(String logID){
		String sql="select * from role WHERE logId=?";
		return executeQuery(sql, Role.class,logID);
	}
	
	//����Աͨ�����ֲ鿴ĳһ�˵�Ȩ��
	@Override
	public List<Role> selectRoleByName(String name) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role where name=?";
		return executeQuery(sql, Role.class,name);
	}

	//�鿴��¼��
	public int selectRoleCount(){
		String sql="select count(1) from role";
		return countRecord(sql);
	};
	
	//�鿴ĳһȨ�޵�������
	@Override
	public List<Role> selectRoleByLimit(String limit) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM role where `rlimit`=?";
		return executeQuery(sql, Role.class,limit);
	}

	//����Ա�����˷���Ȩ��
	@Override
	public int insertRole(Role role) {
		// TODO Auto-generated method stub
		String sql="insert into role values(default,?,?,password(?),?)";
		return executeUpdate(sql, role.getRoleName(),role.getLogId(),role.getLogPwd(),role.getRlimit());
	}
	
	//����Ա�����˸ı�Ȩ��
	@Override
	public int updateRole(String limit,String logID) {
		// TODO Auto-generated method stub
		String sql="update role set `rlimit`=? where `logId`=?";
		return executeUpdate(sql, limit,logID);
	}
	
	//��������
	@Override
	public int updateRolePwd(String logPwd,String logID) {
		// TODO Auto-generated method stub
		String sql="update role set `logPwd`=password(?) where `logId`=?";
		return executeUpdate(sql, logPwd,logID);
	}

	//����Աɾ��Ȩ��
	@Override
	public int deleteRole(String logID) {
		// TODO Auto-generated method stub
		String sql="delete from role where `logId`=?";
		return executeUpdate(sql,logID);
	}

}
