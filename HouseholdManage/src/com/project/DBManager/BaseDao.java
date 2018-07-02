package com.project.DBManager;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BaseDao<T> {

	public Connection getconnection() {

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/household", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void close(Connection conn, PreparedStatement ps) {
		close(ps);
		close(conn);
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		close(rs);
		close(conn, ps);
	}

	public int executeUpdate(String sql) {
		return executeUpdate(sql, null);
	}

	public int executeUpdate(String sql, Object... args) {
		int c = 0;
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getconnection();
			ps = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}
			c = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps);
		}
		return c;
	}

	public List<T> executeQuery(String sql, Class cls) {
		return executeQuery(sql, cls, null);
	}

	public List<T> executeQuery(String sql, Class cls, Object... args) {
		List<T> objects = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getconnection();
			ps = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				T obj = (T) cls.newInstance();
				Field[] fields = cls.getDeclaredFields();
				for (Field field : fields) {
					String methodName = "set" + StringUtil.UpperFirstLetter(field.getName());
					Class argClass = field.getType();
					Method method = cls.getMethod(methodName, argClass);
					method.invoke(obj, rs.getObject(field.getName()));
				}
				objects.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(conn, ps, rs);
		}
		return objects;
	}

	public List<T> executeQuery(String sql, String classStr){
		try {
			return executeQuery(sql, Class.forName(classStr));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<T> executeQuery(String sql, String classStr,String... args){
		try {
			return executeQuery(sql, Class.forName(classStr),args);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int countRecord(String sql) {
		return countRecord(sql,null);
	}
	
	public int countRecord(String sql,Object...obs) {
		int c=0;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		conn=getconnection();
		try {
			ps=conn.prepareStatement(sql);
			if(obs!=null) {
				for (int s = 0; s < obs.length; s++) {
					ps.setObject(s+1,obs[s]);
				}
			}
			rs=ps.executeQuery();
			if(rs.next()) {
				c=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return c;
	}
}
