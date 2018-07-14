package com.czu.jdbc.utils;

import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.sql.DataSource;
public class MyDataSource1 implements DataSource {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		driver = bundle.getString("driver");
		url = bundle.getString("url");
		username = bundle.getString("username");
		password = bundle.getString("password");
			
	}
	
	
	//1.创建一个容器,存储connection对象
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	  
	//2.创建5个连接放到容器中
	static {
		for(int i = 0 ;i < 5 ; i++) {
			try {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url,username,password);
				//改造
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		//3.使用前先判断
		if(pool.size()==0) {
			//4.如果没有创建一个
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,username,password);
				MyConnection myconn = new MyConnection(conn, pool);
				pool.add(myconn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		//5.从池子里获取连接对象
		conn = pool.remove(0);
		return conn;
	}
	/**
	 * 归还连接对象到连接池
	 */
	public void backConnection(Connection conn) {
		pool.add(conn);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
