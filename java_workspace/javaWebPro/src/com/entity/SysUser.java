package com.entity;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SysUser implements HttpSessionBindingListener {

	private int usrId;				//用户ID
	private String usrName;			//用户登录名 
	private String usrPassword;	//密码 
	private String usrNickname;	//用户昵称
	private String usrRole;		//用户角色：普通用户、超级用户
	private int usrStatus;			//用户状态 0：未启用，1：启用
	private int usrNum;			//错误次数记录
	private String usrImage;	//用户头像
	
	public String getUsrImage() {
		return usrImage;
	}
	public void setUsrImage(String usrImage) {
		this.usrImage = usrImage;
	}
	public int getUsrId() {
		return usrId;
	}
	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrPassword() {
		return usrPassword;
	}
	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}
	public String getUsrNickname() {
		return usrNickname;
	}
	public void setUsrNickname(String usrNickname) {
		this.usrNickname = usrNickname;
	}
	public String getUsrRole() {
		return usrRole;
	}
	public void setUsrRole(String usrRole) {
		this.usrRole = usrRole;
	}
	public int getUsrStatus() {
		return usrStatus;
	}
	public void setUsrStatus(int usrStatus) {
		this.usrStatus = usrStatus;
	}
	public int getUsrNum() {
		return usrNum;
	}
	public void setUsrNum(int usrNum) {
		this.usrNum = usrNum;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		//添加SysUser到session中
		CountNumber.userCount++;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		//session中删除SysUser
		CountNumber.userCount--;
	}
	
}
