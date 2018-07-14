package com.Muz.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.Muz.domain.Admin;
import com.Muz.domain.Product;
import com.Muz.domain.User;
import com.Muz.message.HttpClientUtil;
import com.Muz.utils.DataSourceUtils;

public class UserDao {

	public Long checkUsername(String us_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select count(*) from user where us_id=?";
		Long query = (Long) runner.query(sql, new ScalarHandler(), us_id);
		return query;
	}
	public User loginUser(String us_id,String us_password) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where us_id=? and us_password=?";
		User user = runner.query(sql, new BeanHandler<User>(User.class), us_id,us_password);
		return user;
	}
	public int addUser(User user) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		int count =runner.update(sql,null,user.getUs_id(),user.getUs_name(),user.getUs_password(),
				user.getUs_sex(),user.getUs_email(),user.getUs_birthday());
		return count;
	}
	public String selectPhone(String us_id) throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select us_password from user where us_id=?";
		String phone = (String) runner.query(sql, new ScalarHandler(), us_id);
		return phone;

	}
	public void sendCode(String phonecode, String code) {
		// TODO Auto-generated method stub
		String Uid = "ld56888";
		//接口安全秘钥
		 String Key = "9f6f011ff0e1e9a6917e";
		//手机号码，多个号码如13800000000,13800000001,13800000002
		//短信内容
		 String smsText = "验证码："+code;		
		 System.out.println(smsText);
//		 HttpClientUtil client = HttpClientUtil.getInstance();		
//		//UTF发送
//		int result = client.sendMsgUtf8(Uid, Key, smsText, phonecode);
//		
//		if (result > 0) {
//			System.out.println("UTF8成功发送条数==" + result);
//		} else {
//			System.out.println(client.getErrorMsg(result));
//		}
	}
}
