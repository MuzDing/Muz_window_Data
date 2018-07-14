package com.czu;

public class UserManagerBean {
	
	public static String GetNameByID(String userID){
		if(userID=="001"){
			return "小王";
		}
		else{
			return "无法识别的学号";
		}
	}
	
	/**
	 * 判断用户的合法性
	 * @param ub:用户信息
	 * @return True/False
	 */
	public boolean UserCheck(UserBean ub){
		String strUserID;
		String strUserPWD;
		
		strUserID=ub.getUserID();
		strUserPWD=ub.getUserPassWord();
		if((strUserID.equals("111")) && (strUserPWD.equals("222")))
		{
			return true;			
		}
		else
		{
			return false;
		}
	}
	

}
