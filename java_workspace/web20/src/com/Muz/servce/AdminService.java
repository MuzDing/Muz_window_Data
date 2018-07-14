package com.Muz.servce;

import java.sql.SQLException;
import java.util.List;

import com.Muz.dao.AdminDao;
import com.Muz.dao.AdminProductDao;
import com.Muz.domain.Admin;
import com.Muz.domain.Category;

public class AdminService {
	
	public Admin loginAdmin(String ad_id,String ad_password) throws SQLException {
		AdminDao dao = new AdminDao();
		return dao.loginAdmin(ad_id, ad_password);
	}
}
