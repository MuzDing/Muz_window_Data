package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.SysUser;
import com.util.ConfigUtil;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public SysUser login(String userName, String password) throws ClassNotFoundException {
		SysUser user = null;
		String driver = ConfigUtil.getPropValue("jdbc.driver");
		String url = ConfigUtil.getPropValue("jdbc.url");
		String jdbcuser = ConfigUtil.getPropValue("jdbc.name");
		String pwd = ConfigUtil.getPropValue("jdbc.pwd");
		
		String sql = "SELECT * FROM sys_user WHERE "
				+ "usr_name = '"+userName+"' "
				+ "and usr_password = '"+password+"'";
		
		Class.forName(driver);
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, jdbcuser, pwd);
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				user = new SysUser();
				user.setUsrId(rs.getInt("usr_id"));
				user.setUsrNickname(rs.getString("usr_nickname"));
				user.setUsrPassword(rs.getString("usr_password"));
				user.setUsrName(rs.getString("usr_name"));
				user.setUsrImage(rs.getString("usr_image"));
				user.setUsrStatus(rs.getInt("usr_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(st != null){
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public List<SysUser> queryUserList() {
		List<SysUser> uls = new ArrayList<SysUser>();
		String sql = "SELECT * FROM sys_user";
		try {
			super.rs = super.execQuery(sql, null);
			while(super.rs.next()){
				SysUser u = new SysUser();
				u.setUsrNickname(rs.getString("usr_nickname"));
				u.setUsrPassword(rs.getString("usr_password"));
				u.setUsrName(rs.getString("usr_name"));
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrNum(rs.getInt("usr_num"));
				u.setUsrRole(rs.getString("usr_role"));
				u.setUsrStatus(rs.getInt("usr_status"));
				u.setUsrImage(rs.getString("usr_image"));
				uls.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return uls;
	}

	@Override
	public List<SysUser> queryUserList(int startIndex, int size) {
		List<SysUser> uls = new ArrayList<SysUser>();
		String sql = "SELECT * FROM sys_user LIMIT ?,?";
		Object [] objs = {startIndex,size};
		try {
			super.rs = super.execQuery(sql, objs);
			while(super.rs.next()){
				SysUser u = new SysUser();
				u.setUsrNickname(rs.getString("usr_nickname"));
				u.setUsrPassword(rs.getString("usr_password"));
				u.setUsrName(rs.getString("usr_name"));
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrNum(rs.getInt("usr_num"));
				u.setUsrRole(rs.getString("usr_role"));
				u.setUsrStatus(rs.getInt("usr_status"));
				u.setUsrImage(rs.getString("usr_image"));
				uls.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return uls;
	}

	@Override
	public int queryUserCount() {
		int count = 0;
		String sql = "SELECT count(1) usercount FROM sys_user";
		try {
			super.rs = super.execQuery(sql, null);
			while(super.rs.next()){
				count = rs.getInt("USERcount");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return count;
	}

	@Override
	public List<SysUser> queryUserList(int startIndex, int size,
			String userName, String userRole) {
		List<SysUser> uls = new ArrayList<SysUser>();
		//参数列表
		List<Object> parms = new ArrayList<Object>();
		//sql语句
		StringBuffer sb = new StringBuffer("SELECT * FROM sys_user where 1 = 1");
		if(userName != null && userName != ""){
			sb.append(" and usr_name LIKE ?");
			parms.add(userName+"%");
		}
		if(userRole != null && userRole != ""){
			sb.append(" and usr_role = ?");
			parms.add(userRole);
		}
		
		sb.append(" LIMIT ?,?");
		parms.add(startIndex);
		parms.add(size);
		
		try {
			super.rs = super.execQuery(sb.toString(), parms.toArray());
			
			while(super.rs.next()){
				SysUser u = new SysUser();
				u.setUsrNickname(rs.getString("usr_nickname"));
				u.setUsrPassword(rs.getString("usr_password"));
				u.setUsrName(rs.getString("usr_name"));
				u.setUsrId(rs.getInt("usr_id"));
				u.setUsrNum(rs.getInt("usr_num"));
				u.setUsrRole(rs.getString("usr_role"));
				u.setUsrStatus(rs.getInt("usr_status"));
				u.setUsrImage(rs.getString("usr_image"));
				uls.add(u);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return uls;
	}

	@Override
	public int queryUserCount(String userName, String userRole) {
		int count = 0;
		//sql语句
		StringBuffer sb = new StringBuffer("SELECT count(1) usercount FROM sys_user where 1 = 1");
		//参数列表
		List<Object> parms = new ArrayList<Object>();
		if(userName != null && userName != ""){
			sb.append(" and usr_name LIKE ?");
			parms.add(userName+"%");
		}
		if(userRole != null && userRole != ""){
			sb.append(" and usr_role = ?");
			parms.add(userRole);
		}
		try {
			super.rs = super.execQuery(sb.toString(), parms.toArray());
			
			while(super.rs.next()){
				count = rs.getInt("USERcount");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return count;
	}

	@Override
	public boolean updateUserImg(String userName, String imgUrl) {
		boolean bool = false;
		String sql = "UPDATE sys_user SET usr_image = ? WHERE usr_name = ?";
		Object [] objs = {imgUrl,userName};
		try {
			bool = super.execUpdate(sql, objs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean updateUserNum(int num,int userId) {
		boolean bool = false;
		String sql = "UPDATE sys_user SET usr_num = ? WHERE usr_id = ?";
		Object [] objs = {num,userId};
		try {
			bool = super.execUpdate(sql, objs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public SysUser queryUserByUserName(String userName) {
		SysUser u = null;
		//sql语句
		String sql = "SELECT * FROM sys_user where usr_name = ?";
		//参数列表
		Object [] objs = {userName};
		try {
			super.rs = super.execQuery(sql, objs);
			
			while(super.rs.next()){
				u = new SysUser();
				u.setUsrNickname(super.rs.getString("usr_nickname"));
				u.setUsrPassword(super.rs.getString("usr_password"));
				u.setUsrName(super.rs.getString("usr_name"));
				u.setUsrId(super.rs.getInt("usr_id"));
				u.setUsrNum(super.rs.getInt("usr_num"));
				u.setUsrRole(super.rs.getString("usr_role"));
				u.setUsrStatus(super.rs.getInt("usr_status"));
				u.setUsrImage(super.rs.getString("usr_image"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			super.closeResource();
		}
		return u;
	}

	@Override
	public boolean updateUserStatus(int status, int userId) {
		boolean bool = false;
		String sql = "UPDATE sys_user SET usr_status = ?,usr_num = 0 WHERE usr_id = ?";
		Object [] objs = {status,userId};
		try {
			bool = super.execUpdate(sql, objs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public boolean insertUser(SysUser user) {
		boolean bool = false;
		String sql = "insert  into `sys_user` values (null,?,?,?,'普通用户',1,0,?)";
		Object [] objs = {user.getUsrName(),user.getUsrPassword(),user.getUsrNickname(),user.getUsrImage()};
		try {
			bool = super.execUpdate(sql, objs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}

}
