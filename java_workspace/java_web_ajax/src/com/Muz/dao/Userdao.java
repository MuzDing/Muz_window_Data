package com.Muz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.LifecycleListener;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.tomcat.websocket.server.WsHandshakeRequest;

import com.untity.DataSourceUtils;
import com.untity.User;

public class Userdao {

	public Boolean logCheck(String num, String password) {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where num=? and password=?";
		List<User> user = null;
		try {
			user = runner.query(sql, new BeanListHandler<User>(User.class), num, password);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (user != null) {
			return true;
		} else {
			return false;
		}

	}

	public int Add(User user) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		int count = 0;
		try {
			count = runner.update(sql, user.getName(), user.getNum(), user.getPassword(), user.getAge(), user.getSex(),
					user.getHobby(), user.getSheng(), user.getShi());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return count;

	}

	public int deleteByNum(String num) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from user where num=?";
		int count = 0;
		try {
			count = runner.update(sql, num);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return count;

	}

	public List<User> selectByNum(String num) {

		List<User> list = null;
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where num like ?";
		int count = 0;
		try {
			list = runner.query(sql, new BeanListHandler<User>(User.class), "%" + num + "%");
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		return list;

	}

	public int updatePas(String num, String password) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set password=? where num=?";
		int count = 0;
		try {
			count = runner.update(sql, password, num);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return count;
	}

	public Boolean isExist(String num) {

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where num=?";
		List<User> user = null;
		try {
			user = runner.query(sql, new BeanListHandler<User>(User.class), num);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (!user.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
