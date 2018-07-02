package com.project.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.entity.Trp;

public class ControlApplytrpDao {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection openConnection() throws SQLException, IOException {
		String url="jdbc:mysql://localhost:3306/household?useSSL=true";
		String user="root";
		String password="root";
		return DriverManager.getConnection(url, user, password);
	}
	
	public void closeConnection(Connection conn) throws SQLException {
		if(conn!=null && !conn.isClosed()) {
			conn.close();
		}
	}
	
	public int execute(Connection conn,String sql,Object...obs) throws SQLException {
		int count=0;
		if(conn!=null && !conn.isClosed()) {
			PreparedStatement ps=conn.prepareStatement(sql);
			if(obs!=null) {
				//PreparedStatement的setXXX(int index,Object val)设置占位符的值，其中index的值从1开始
				for(int i=0;i<obs.length;i++) {
					ps.setObject(i+1, obs[i]);
				}
			}
			count=ps.executeUpdate();
		}
		return count;
	}
	
	public ResultSet query(Connection conn,String sql,Object...obs) throws SQLException {
		ResultSet rs=null;
		if(conn!=null && !conn.isClosed()) {
			PreparedStatement ps=conn.prepareStatement(sql);
			if(obs!=null) {
				for (int i = 0; i < obs.length; i++) {
					ps.setObject(i+1, obs[i]);
				}
			}
			rs=ps.executeQuery();
		}
		return rs;
	}
	
	public int controlApplytrp(Trp trp,String idcard,int trpid) throws SQLException, IOException {
		Connection conn=this.openConnection();
		int a=0;
		int b=0;
		int c=0;
		try {
			String sql0="insert into `trp` values(?,?,?,?,?,?,?)";
			String sql1="update Alldata set trpid=? where idcard=?";
			String sql2="delete from applytrp where idcard=?";
			Object[] obs0= {trp.getTrpid(),trp.getIdcard(),trp.getName(),trp.getNatives(),trp.getAddress(),trp.getBeginDate(),trp.getEndDate()};
			Object[] obs1= {trpid,idcard};
			Object[] obs2= {idcard};
			boolean autoCommite=conn.getAutoCommit();
			conn.setAutoCommit(false);
			a=this.execute(conn, sql0, obs0);
			b=this.execute(conn, sql1, obs1);
			c=this.execute(conn, sql2, obs2);
			conn.commit();
			conn.setAutoCommit(autoCommite);
		} catch (Exception e) {
			// TODO: handle exception
			conn.rollback();
		}
		this.closeConnection(conn);
		return a+b+c;
	}
	
	//移除暂住证信息
	public int deleTrp(int trpid) throws SQLException, IOException {
		Connection conn=this.openConnection();
		int a=0;
		int b=0;
		try {
			String sql1="delete from trp where trpid=?";
			String sql2="update alldata set trpid=0 where trpid=?";
			Object[] obs1= {trpid};
			Object[] obs2= {trpid};
			boolean autocommit=conn.getAutoCommit();
			conn.setAutoCommit(false);
			a=this.execute(conn, sql1, obs1);
			b=this.execute(conn, sql2, obs2);
			conn.commit();
			conn.setAutoCommit(autocommit);
		} catch (Exception e) {
			// TODO: handle exception
			conn.rollback();
		}
		this.closeConnection(conn);
		return a+b;
	}
	
	
}
