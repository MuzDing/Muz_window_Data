package com.czu;

public class StudentManageBean {
	public boolean checkById(String id){
		if(id.equals("111")){
			return true;
		}else{
			return false;
		}
	}
	public StudentBean getInfoById(){
		StudentBean stu=new StudentBean();
		stu.setName("xiaoming");
		stu.setSex("M");
		return stu;
	}
}
