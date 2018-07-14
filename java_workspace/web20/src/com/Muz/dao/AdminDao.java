package com.Muz.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.Muz.domain.Admin;
import com.Muz.domain.Product;
import com.Muz.utils.DataSourceUtils;

public class AdminDao {

	public Admin loginAdmin(String ad_id,String ad_password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from admin where ad_id=? and ad_password=?";
		Admin admin = runner.query(sql, new BeanHandler<Admin>(Admin.class), ad_id,ad_password);
		return admin;
	}


}
