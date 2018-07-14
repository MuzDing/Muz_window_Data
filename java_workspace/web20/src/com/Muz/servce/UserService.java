package com.Muz.servce;

import java.sql.SQLException;

import com.Muz.dao.AdminDao;
import com.Muz.dao.UserDao;
import com.Muz.domain.Admin;
import com.Muz.domain.User;

public class UserService {

	public boolean checkUsername(String us_id) throws SQLException {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		Long isExist = dao.checkUsername(us_id);
		return isExist>0?true:false;
	}
	public User loginUser(String us_id,String us_password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.loginUser(us_id, us_password);
	}
	public int addUser(User user) throws SQLException {
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}
	public String selectPhone(String us_id) throws SQLException {
		UserDao dao = new UserDao();
		return dao.selectPhone(us_id);
	}
	public void sendCode(String phonecode, String code) {
		// TODO Auto-generated method stub
		UserDao dao = new UserDao();
		dao.sendCode(phonecode, code);
	}

}
