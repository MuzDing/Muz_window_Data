package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;

import com.util.ConfigUtil;

public class Test {
	
	@org.junit.Test
	public void queryUsers() throws SQLException{
		//（1）Class.forName()加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//（2）DriverManager.getConnection(URL,用户名,密码)获得数据库连接 (Connection)
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webpro",
					"root", "root");
			//（3）获得Statement对象，执行SQL语句
			st =con.createStatement();
			//（4）处理执行结果(ResultSet)，
			String sql = "SELECT u.usr_id,u.usr_name,u.usr_nickname from sys_user u";
			rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("usr_id")+"\t"+rs.getString("usr_nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(rs != null){
				rs.close();
			}
			
			if(st != null){
				st.close();
			}
			
			if(con != null){
				con.close();
			}
		}
	}
	
	@Before
	public void before(){
		System.out.println("**********Before*****************");
	}
	
	@After
	public void after(){
		System.out.println("**********after*****************");
	}
	
	
	@org.junit.Test
	public void loginTest() throws ClassNotFoundException, SQLException{
		String userName = "admin";
		String password = "000000";
		
		String driver = ConfigUtil.getPropValue("jdbc.driver");
		String url = ConfigUtil.getPropValue("jdbc.url");
		String user = ConfigUtil.getPropValue("jdbc.name");
		String pwd = ConfigUtil.getPropValue("jdbc.pwd");
		
		String sql = "SELECT * FROM sys_user WHERE "
				+ "usr_name = '"+userName+"' "
				+ "and usr_password = '"+password+"'";
		
		Class.forName(driver);
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(rs != null){
				rs.close();
			}
			
			if(st != null){
				st.close();
			}
			
			if(con != null){
				con.close();
			}
		}
	}
	
	@org.junit.Test
	public void addUser() throws ClassNotFoundException, SQLException{
		
		String driver = ConfigUtil.getPropValue("jdbc.driver");
		String url = ConfigUtil.getPropValue("jdbc.url");
		String user = ConfigUtil.getPropValue("jdbc.name");
		String pwd = ConfigUtil.getPropValue("jdbc.pwd");
		
		String sql = "INSERT INTO sys_user VALUES(null,'www2','0002','岳不群222','普通用户',1,0)";
		
		Class.forName(driver);
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			st = con.createStatement();
			int num = st.executeUpdate(sql);
			if(num > 0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(rs != null){
				rs.close();
			}
			
			if(st != null){
				st.close();
			}
			
			if(con != null){
				con.close();
			}
		}
	}
}
