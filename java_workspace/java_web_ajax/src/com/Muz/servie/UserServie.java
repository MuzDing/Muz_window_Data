package com.Muz.servie;

import java.util.List;

import com.Muz.dao.Userdao;
import com.untity.User;

public class UserServie {
	Userdao user = new Userdao();

	public Boolean isExist(String num) {
		// TODO Auto-generated method stub
		Boolean bool = user.isExist(num);
		return bool;
	}

	public Boolean logCheck(String num, String password) {
		// TODO Auto-generated method stub
		Boolean bool = user.logCheck(num, password);
		return bool;
	}

	public int Add(User user2) {
		// TODO Auto-generated method stub
		int count = user.Add(user2);
		return count;
	}

	public int updatePas(String num, String password) {
		// TODO Auto-generated method stub
		int count = user.updatePas(num, password);
		return count;
	}

	public int deleteByNum(String num) {
		// TODO Auto-generated method stub
		int count = user.deleteByNum(num);
		return count;
	}

	public List<User> selectByNum(String num) {
		// TODO Auto-generated method stub
		List<User> list = null;
		list = user.selectByNum(num);
		return list;
	}

}
