package com.czu;

public class UserManagerBean {
	
	public static String GetNameByID(String userID){
		if(userID=="001"){
			return "С��";
		}
		else{
			return "�޷�ʶ���ѧ��";
		}
	}
	
	/**
	 * �ж��û��ĺϷ���
	 * @param ub:�û���Ϣ
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
