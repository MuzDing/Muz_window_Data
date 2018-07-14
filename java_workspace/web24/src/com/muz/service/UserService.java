package com.muz.service;

import java.sql.SQLException;

import com.muz.dao.UserDao;
import com.muz.domain.User;

public class UserService {

	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}
}
