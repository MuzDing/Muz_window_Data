package com.czu.jdbc.test;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.czu.c3p0.C3p0Utils;

import czu.muz.info.User;

public class TestDBUtils {

	@Test
	public void testQueryAll() {
		try {
			// 1.获取核心类queryRunner
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			// 2.编写sql语句
			String sql = "select * from tbl_user";
			
			// 3.执行查询操作
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			// 4.对结果集集合进行遍历
			for (User user : users) {
				System.out.println(user.getU_admin()+"---"+user.getU_password());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	@Test
	public void testQueryUserById() {
		try {
			// 1.获取核心类queryRunner
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			// 2.编写sql语句
			String sql = "select * from tbl_user where uid=?";
			//3.为占位符设置值
			Object[] params = {1};
			// 4.执行查询操作
			User user = qr.query(sql, new BeanHandler<User>(User.class), params);
			System.out.println(user.getU_id() + " : " + user.getU_password());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void testAdduser()
	{
		try {
			// 1.创建核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3p0Utils.getDataSource());
			// 2.编写SQL语句
			String sql = "insert into tbl_user values(null,?,?)";
			// 3.为站位符设置值
			Object[] params = { "余淮", "耿耿" };
			// 4.执行添加操作
			int rows = qr.update(sql, params);
			if (rows > 0) {
				System.out.println("添加成功!");
			} else {
				System.out.println("添加失败!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
