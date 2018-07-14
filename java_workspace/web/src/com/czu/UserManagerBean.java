package com.czu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UserManagerBean {
	
	public static String GetNameByID(String userID){
		if(userID=="001"){
			return "小王";
		}
		else{
			return "无法识别的学号";
		}
	}
	
	
public boolean UserCheck(UserBean ub){
		Connection con = null;
		try {
			con = getConnection.link();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Boolean bool=false;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from user where num='"+ub.getUserID()+"' and password='"+ub.getUserPassWord()+"'";
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
			e.printStackTrace();
		}
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bool;
	}
	

}
