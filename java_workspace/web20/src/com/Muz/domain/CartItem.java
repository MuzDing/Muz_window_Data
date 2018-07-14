package com.Muz.domain;

public class CartItem {
	private Product product;// 图书对象的成员变量
	private Integer number;  // 购买的数量；
	
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Product product, Integer number) {
		pppppp();
		this.product =  product;
		this.number = number;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	private void pppppp() {
		this.product = new Product();
	}

}
