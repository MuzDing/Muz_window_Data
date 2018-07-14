package com.czu.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.czu.jdbc.utils.MyDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestC3p0 {
	
	@Test
	public void testAdd() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		//1创建自定义连接池对象
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_user values(null,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "14030413");
			pstmt.setString(2, "ld828521");
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
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
