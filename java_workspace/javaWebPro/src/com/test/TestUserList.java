package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.entity.CountNumber;


public class TestUserList {

	public static void main(String[] args) throws SQLException{
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
	

}
