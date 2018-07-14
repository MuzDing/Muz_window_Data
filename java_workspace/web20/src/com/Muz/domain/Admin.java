package com.Muz.domain;

public class Admin {
	private int ad_num;
	private String ad_id;
	private String ad_password;
	private String ad_role;
	private int ad_operate_count;
	private String ad_dept_id;
	public int getAd_num() {
		return ad_num;
	}
	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_password() {
		return ad_password;
	}
	public void setAd_password(String ad_password) {
		this.ad_password = ad_password;
	}
	public String getAd_role() {
		return ad_role;
	}
	public void setAd_role(String ad_role) {
		this.ad_role = ad_role;
	}
	public int getAd_operate_count() {
		return ad_operate_count;
	}
	public void setAd_operate_count(int ad_operate_count) {
		this.ad_operate_count = ad_operate_count;
	}
	public String getAd_dept_id() {
		return ad_dept_id;
	}
	public void setAd_deptid(String ad_dept_id) {
		this.ad_dept_id = ad_dept_id;
	}
	public boolean isAd_del() {
		return ad_del;
	}
	public void setAd_del(boolean ad_del) {
		this.ad_del = ad_del;
	}
	private boolean ad_del;
	
}
