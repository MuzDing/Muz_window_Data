package com.czu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class getConnection {

	public static Connection link() throws SQLException {
		String url = "jdbc:mysql://localhost/web";
		String user = "root";
		String password = "1234";
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";// 驱动程序名
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 加载驱动
		con = DriverManager.getConnection(url, user, password);
		return con;
	}

}