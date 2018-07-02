package com.project.DBManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

/**
 * 从数据库中反向生成实体bean的工具类
 * 
 * @author Administrator
 *
 */
public class GenEntityMysql {

	public static void main(String[] args) {
		GenEntityMysql gem =new GenEntityMysql();
		gem.createAllPO("household", "root", "root", "com.project.entity");

	}
	private String authorName = "白明";// 作者名字
	// 数据库连接
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * 根据数据库中表的结构创建po类
	 * 
	 * @param dbName
	 *            <h1 style='color:red'>数据库名称</h1>
	 * @param tableName
	 *            表名称
	 * @param user
	 *            数据库用户名
	 * @param password
	 *            数据库密码
	 * @param packageOutPath
	 *            输出的包名，例如：com.han.po
	 */
	public void createPO(String dbName, String tableName, String user, String password, String packageOutPath) {
		createPO(dbName, tableName, user, password, packageOutPath, true);
	}

	/**
	 * 根据数据库中表的结构创建po类
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param tableName
	 *            表名称
	 * @param user
	 *            数据库用户名
	 * @param password
	 *            数据库密码
	 * @param packageOutPath
	 *            输出的包名，例如：com.han.po
	 * @param ignore
	 *            是否忽略已存在的类，若为true则直接覆盖，若为false则需要在控制台手动输入是否覆盖
	 */
	public void createPO(String dbName, String tableName, String user, String password, String packageOutPath,
			boolean ignore) {
		Connection con = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(URL + dbName, user, password);
			createPO(con, tableName, packageOutPath, ignore);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 生成一个类
	 * 
	 * @param con
	 *            数据库连接
	 * @param tableName
	 *            表名
	 * @param packageOutPath
	 *            输出包名
	 * @param ignore
	 *            是否忽略已存在的类，若为true则直接覆盖，若为false则需要在控制台手动输入是否覆盖
	 */
	private void createPO(Connection con, String tableName, String packageOutPath, boolean ignore) {
		File directory = new File("");
		String outputPath = directory.getAbsolutePath() + "/src/" + checkPackage(packageOutPath).replace(".", "/") + "/"
				+ firstLetterUpper(tableName) + ".java";
		File outputFile = new File(outputPath);

		boolean isCover = true;
		if (!ignore) {
			if (outputFile.exists()) {
//				System.out.println(firstLetterUpper(tableName) + ".java已存在，是否覆盖(Y)");
				Scanner input = new Scanner(System.in);
				String cover = input.nextLine();
				isCover = "Y".equalsIgnoreCase(cover);
			}
		}
		if (isCover) {
			// 判断包名是否存在
			if (!outputFile.getParentFile().exists()) {
				outputFile.getParentFile().mkdirs();
			}
			String[] colnames; // 列名数组
			String[] colTypes; // 列名类型数组
			int[] colSizes; // 列名大小数组
			
			boolean f_util = false; // 是否需要导入包java.util.*
			// 查要生成实体类的表
			String sql = "select * from `" + tableName + "`";
			PreparedStatement pStemt = null;
			PrintWriter pw = null;
			try {
				pStemt = con.prepareStatement(sql);
				ResultSetMetaData rsmd = pStemt.getMetaData();
				int size = rsmd.getColumnCount(); // 统计列
				colnames = new String[size];
				colTypes = new String[size];
				colSizes = new int[size];
				for (int i = 0; i < size; i++) {
					colnames[i] = rsmd.getColumnName(i + 1);
					colTypes[i] = rsmd.getColumnTypeName(i + 1);

					if (colTypes[i].equalsIgnoreCase("timestamp") || colTypes[i].equalsIgnoreCase("datetime")
							|| colTypes[i].equalsIgnoreCase("date")) {
						f_util = true;
					}
					colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
				}

				String content = parse(tableName, colnames, colTypes, colSizes, packageOutPath, f_util);
				pw = new PrintWriter(new FileWriter(outputPath));
				pw.println(content);
				pw.flush();
			} catch (SQLException | IOException e) {
				System.out.println("表名称错误");
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
		}
	}

	/**
	 * 生成类
	 * 
	 * @param tableName
	 *            表名称
	 * @param colnames
	 *            列名称
	 * @param colTypes
	 *            列类型
	 * @param colSizes
	 *            列大小
	 * @param packageOutPath
	 *            输出的包路径
	 * @param f_util
	 *            是否需要util包
	 * @param f_sql
	 *            是否需要sql包
	 * @return 类字符串
	 */
	private String parse(String tableName, String[] colnames, String[] colTypes, int[] colSizes, String packageOutPath,
			boolean f_util) {
		StringBuffer sb = new StringBuffer();

		sb.append("package " + checkPackage(packageOutPath) + ";\r\n\r\n");

		sb.append("import java.io.Serializable;\r\n");
		
		// 判断是否导入工具包
		if (f_util) {
			sb.append("import java.util.Date;\r\n\r\n");
		}
		// 注释部分
		sb.append("/**\n");
		sb.append(" * \n * " + tableName + " 实体类\r\n");
		sb.append(" * " + new Date() + "\r\n");
		sb.append(" * " + "@author " + authorName + " \r\n");
		sb.append(" * \n */ \r\n");
		// 实体部分
		sb.append("public class " + firstLetterUpper(tableName) + " implements Serializable{\r\n");
		
		//私有字段
		sb.append(processAllAttrs(colnames, colTypes));
		//无参的构造方法
		sb.append(processDefaultConstructor(tableName));
		//有参数的构造方法
		sb.append(processArgsConstructor(tableName, colnames, colTypes));
		//toString()
		sb.append(processToString(tableName, colnames));
		//get,set方法
		sb.append(processAllMethod(colnames, colTypes));// get set方法
		sb.append("}\r\n");
		return sb.toString();
	}

	/**
	 * 检查包名，若前后有非小写字母，则过滤
	 * @param packageOutPath 包名
	 * @return 过滤非小写字母后的包名
	 */
	private String checkPackage(String packageOutPath){
		
		char[] ch = packageOutPath.trim().toCharArray();
		int start = 0;
		int count = ch.length;
		int end = ch.length;
		
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]>='a' && ch[i]<='z'){
				start = i;
				break;
			}
		}
		for (int i = ch.length - 1; i > 0; i--) {
			if(ch[i]>='a' && ch[i]<='z'){
				end = i+1;
				break;
			}
		}
		count = end - start;
//		System.out.println(new String(ch, start, count));
		return new String(ch, start, count);
	}
	
	/**
	 * 生成所有的属性
	 * 
	 * @param colnames
	 *            列名称
	 * @param colTypes
	 *            列类型
	 * @return 属性字符串
	 */
	private String processAllAttrs(String[] colnames, String[] colTypes) {
//		System.out.println("属性生成中。。。");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + firstLetterLower(colnames[i]) + ";\r\n");
		}
//		System.out.println("属性生成结束");
		return sb.toString();
	}

	private String processDefaultConstructor(String tableName) {
//		System.out.println("属性生成中。。。");
		StringBuffer sb = new StringBuffer();
		sb.append("\n\tpublic " + firstLetterUpper(tableName) + "(){\n");
		sb.append("\t\tsuper();\n");
		sb.append("\t}\n");
//		System.out.println("属性生成结束");
		return sb.toString();
	}

	private String processArgsConstructor(String tableName, String[] colnames, String[] colTypes) {
//		System.out.println("属性生成中。。。");
		StringBuffer sb = new StringBuffer();
		StringBuffer sbAttrs = new StringBuffer();
		sb.append("\n\tpublic " + firstLetterUpper(tableName) + "(");
		for (int i = 0; i < colTypes.length; i++) {
			String lowName = firstLetterLower(colnames[i]);
			sb.append(sqlType2JavaType(colTypes[i]));
			sb.append(" " + lowName + ",");

			sbAttrs.append("\t\tthis." + lowName + "=" + lowName + ";\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("){\n");
		sb.append("\t\tsuper();\n");

		sb.append(sbAttrs);

		sb.append("\t}\n");
//		System.out.println("属性生成结束");
		return sb.toString();
	}

	private String processToString(String tableName, String[] colnames) {
		StringBuffer sb = new StringBuffer();
		sb.append("\n\t@Override\n");
		sb.append("\tpublic String toString(){\n");
		sb.append("\t\treturn \"" + firstLetterUpper(tableName) + " [");
		for (int i = 0; i < colnames.length; i++) {
			String lowName = firstLetterLower(colnames[i]);
			sb.append(lowName + "=\" + " + lowName + " + \", ");
		}
		sb.delete(sb.length()-2,sb.length());
		sb.append("]\";\n");
		sb.append("\t}\n");
		return sb.toString();
	}

	/**
	 * 生成所有的getset方法
	 * 
	 * @param colnames
	 *            列名称
	 * @param colTypes
	 *            列类型
	 * @return getset字符串
	 */
	private String processAllMethod(String[] colnames, String[] colTypes) {
//		System.out.println("方法生成中。。。");
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < colnames.length; i++) {
			String upName = firstLetterUpper(colnames[i]);
			String lowName = firstLetterLower(colnames[i]);
			sb.append("\n\tpublic void set" + upName + "(" + sqlType2JavaType(colTypes[i]) + " " + lowName + "){\r\n");
			sb.append("\t\tthis." + lowName + "=" + lowName + ";\r\n");
			sb.append("\t}\r\n");
			sb.append("\n\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + upName + "(){\r\n");
			sb.append("\t\treturn " + lowName + ";\r\n");
			sb.append("\t}\r\n");
		}
//		System.out.println("方法生成结束");
		return sb.toString();
	}

	/**
	 * 将输入字符串的首字母改成大写
	 * 
	 * @param str
	 *            首字母要变成大写的字符串
	 * @return 首字母变成大写的字符串
	 */
	private String firstLetterUpper(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}

	/**
	 * 将输入字符串的首字母改成小写
	 * 
	 * @param str
	 *            首字母要变成小写的字符串
	 * @return 首字母变成小写的字符串
	 */
	private String firstLetterLower(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'A' && ch[0] <= 'Z') {
			ch[0] = (char) (ch[0] + 32);
		}
		return new String(ch);
	}

	/**
	 * 根据数据库的数据类型获取对应的java数据类型
	 * 
	 * @param sqlType
	 *            数据库数据类型
	 * @return 对应的java数据类型
	 */
	private String sqlType2JavaType(String sqlType) {

		if (sqlType.equalsIgnoreCase("bit")) {
			return "boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
			return "byte";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
			return "short";
		} else if (sqlType.equalsIgnoreCase("int")) {
			return "int";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
			return "long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			return "float";
		} else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney") || sqlType.equalsIgnoreCase("double")) {
			return "double";
		} else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text") || sqlType.equalsIgnoreCase("varbinary")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("datetime")|| sqlType.equalsIgnoreCase("date")||sqlType.equalsIgnoreCase("timestamp")) {
			return "Date";
		} else if (sqlType.equalsIgnoreCase("image")) {
			return "Blod";
		} 
		return null;
	}

	/**
	 * 根据数据库中表的结构创建po类
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param user
	 *            数据库用户名
	 * @param password
	 *            数据库密码
	 * @param packageOutPath
	 *            输出的包名，例如：com.han.po
	 */
	public void createAllPO(String dbName, String user, String password, String packageOutPath) {

		createAllPO(dbName, user, password, packageOutPath, true);

	}

	/**
	 * 根据数据库中表的结构创建po类
	 * 
	 * @param dbName
	 *            数据库名称
	 * @param user
	 *            数据库用户名
	 * @param password
	 *            数据库密码
	 * @param packageOutPath
	 *            输出的包名，例如：com.han.po
	 * @param ignore
	 *            是否忽略已存在的类，若为true则直接覆盖，若为false则需要在控制台手动输入是否覆盖
	 */
	public void createAllPO(String dbName, String user, String password, String packageOutPath, boolean ignore) {
		Connection con = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			con = DriverManager.getConnection(URL + dbName, user, password);
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				String tableName = rs.getString(3);
				System.out.println(tableName);
				createPO(con, tableName, packageOutPath, ignore);
				
				
			}
		} catch (SQLException e) {
			System.out.println("数据库配置错误");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}