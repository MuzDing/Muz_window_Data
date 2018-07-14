package com.untity;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Userdao {

	public List<User> getAll(int i)  {
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		ResultSet rs=null;
		ResultSet count=null;
		List<User> list=new ArrayList<User>();
		
		int m=(i-1)*3;
		String sql="select * from User limit "+m+","+3+"";
		String sql1="select count(*) from user";
		try {
			ps = con.prepareStatement(sql);
			ps1 = con.prepareStatement(sql1);
			rs=ps.executeQuery();
			count=ps1.executeQuery(sql1);
			while(rs.next()){
				User u=new User();
				u.setUserPhone(rs.getString(1));
				u.setUserPassword(rs.getString(2));
				u.setState(rs.getString(3));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String getCount() throws SQLException {
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select count(*) from user";

		ps = con.prepareStatement(sql);
			
		rs=ps.executeQuery();
			
		while(rs.next()){
			return rs.getString(1);
		}
		return null;
		
	}

	public List<User> getPageContent(int page) {
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> list=new ArrayList<User>();	
		int m=(page-1)*3;
		String sql="select * from User limit "+m+","+3+"";
		
		try {
			ps = con.prepareStatement(sql);	
			rs=ps.executeQuery();
			while(rs.next()){
				User u=new User();
				u.setUserPhone(rs.getString(1));
				u.setUserPassword(rs.getString(2));
				u.setState(rs.getString(3));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Boolean logCheck(String num, String password) {
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Boolean bool=false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from User where userPhone='"+num+"' and UserPassword='"+password+"'";
		try {
		ps = con.prepareStatement(sql);		
		rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs.next()){
				bool=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}

	

	public int Add(User user) {
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps=null;
		int rs=0;
		String sql="insert into User(UserPhone,UserPassword) values('"+user.getUserPhone()+"','"+user.getUserPassword()+"')";
		 try {
			ps = con.prepareStatement(sql);
			rs=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;		
	}

	public int deleteByNum(String num) {
		Connection con = null;
		int rs=0;
		try {
			con=getConnection.link();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps=null;
		String sql="delete from user where userPhone='"+num+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public User selectByNum(String num) {
		Connection con = null;
		ResultSet rs=null;
		try {
			con=getConnection.link();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps=null;
		String sql="select * from user where userPhone='"+num+"'";
		User user=new User();
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				user.setUserPhone(rs.getString(1));
				user.setUserPassword(rs.getString(2));
				user.setState(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public int changeByNum(User user) {
		Connection con = null;
		int rs=0;
		try {
			con=getConnection.link();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps=null;
		String sql="update user set userPassword='"+user.getUserPassword()+"',state='"+user.getState()+"' where userPhone='"+user.getUserPhone()+"'";
		
		try {
			ps = con.prepareStatement(sql);
			rs=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
