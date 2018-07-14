package com.czu.jdbc.test;
import org.junit.Test;

import com.czu.jdbc.utils.*;

import java.sql.*;
public class TestMyDataSource {
	
	//@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//1创建自定义连接池对象
		MyDataSource dataSource = new MyDataSource();
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "admin");
			pstmt.setString(2, "password");
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			dataSource.backConnection(conn); 
		}
	}
	
	 
	
	@Test
	public void testAdd1() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//1创建自定义连接池对象
		MyDataSource1 dataSource = new MyDataSource1();
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "admin");
			pstmt.setString(2, "password");
			int rows = pstmt.executeUpdate();
			
			if(rows>0) {
				System.out.println("添加成功");
			}
			else {
				System.out.println("添加失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			dataSource.backConnection(conn); 
		}
	}
}
