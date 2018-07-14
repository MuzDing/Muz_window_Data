package com.entity;

import java.util.List;

public class ProductCategory {
	private int id;
	private String categoryName;
	private int pid;
	private List<ProductCategory> pcs; //子集数据
	
	public List<ProductCategory> getPcs() {
		return pcs;
	}
	public void setPcs(List<ProductCategory> pcs) {
		this.pcs = pcs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
