package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.ConfigUtil;

/**
 * 针对底层数据库访问对象的封装
 * @author lx
 * @createDate 2017年4月14日
 */
public class BaseDao {

	private Connection conn = null;
	private PreparedStatement psmt = null;
	protected ResultSet rs = null;
	
	/**
	 * 获得连接
	 */
	private void getConnection() throws ClassNotFoundException, SQLException{
		//获取jdbc.properties配置文件中的配置信息
		String driver = ConfigUtil.getPropValue("jdbc.driver");
		String url = ConfigUtil.getPropValue("jdbc.url");
		String mysqluser = ConfigUtil.getPropValue("jdbc.name");
		String mysqlpwd = ConfigUtil.getPropValue("jdbc.pwd");
		//1.加载驱动
		Class.forName(driver);
		//2.获取连接
		conn = DriverManager.getConnection(url, mysqluser,mysqlpwd);
	}
	
	/**
	 * 关闭资源
	 */
	protected void closeResource(){
		//5.释放资源
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(psmt != null){
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * 查询数据返回结果集
	 * @param readSql 查询sql语句
	 * @param paras 参数列表
	 * @return 结果集
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected ResultSet execQuery(String readSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		//获取连接
		this.getConnection();
		//创建预编译sql语句prepareStatement
		psmt = conn.prepareStatement(readSql);
		//设置参数
		if(paras!=null){
			for (int i = 0;i<paras.length;i++) {
				psmt.setObject(i+1, paras[i]);
			}
		}
		//执行查询
		rs = psmt.executeQuery();
		return rs;
	}
	
	/**
	 * 更新数据返回布尔类型(增删改)
	 * @param writeSql sql语句
	 * @param paras 参数列表
	 * @return 是否成功
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected boolean execUpdate(String writeSql, Object[] paras) 
			throws ClassNotFoundException, SQLException{
		this.getConnection();
		boolean updateRs = false;
		//创建预编译语句prepareStatement
		psmt = conn.prepareStatement(writeSql);
		if(paras != null){
			//设置参数
			for (int i = 0;i<paras.length;i++) {
				psmt.setObject(i+1, paras[i]);
			}
		}
		//执行增删改
		int num = psmt.executeUpdate();
		//判断受影响行数
		if(num > 0){
			updateRs = true;
		}
		return updateRs;
	}
	
}
