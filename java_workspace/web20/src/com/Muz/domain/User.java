package com.Muz.domain;

import java.util.Date;

public class User {
	private String us_num;
	private String us_id;
	private String us_password;
	private String us_email;
	private String us_name;
	private String us_sex;
	private String us_birthday;
	
	public String getUs_num() {
		return us_num;
	}
	public void setUs_num(String us_num) {
		this.us_num = us_num;
	}
	public String getUs_id() {
		return us_id;
	}
	public void setUs_id(String us_id) {
		this.us_id = us_id;
	}
	public String getUs_password() {
		return us_password;
	}
	public void setUs_password(String us_password) {
		this.us_password = us_password;
	}
	public String getUs_email() {
		return us_email;
	}
	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}
	public String getUs_sex() {
		return us_sex;
	}
	public void setUs_sex(String us_sex) {
		this.us_sex = us_sex;
	}
	public String getUs_birthday() {
		return us_birthday;
	}
	public void setUs_birthday(String us_birthday) {
		this.us_birthday = us_birthday;
	}
	
	@Override
	public String toString() {
		return "User [us_num=" + us_num + ", us_id=" + us_id + ", us_password=" + us_password + ", us_email=" + us_email
				+ ", us_name=" + us_name + ", us_sex=" + us_sex + ", us_birthday=" + us_birthday + "]";
	}
}
