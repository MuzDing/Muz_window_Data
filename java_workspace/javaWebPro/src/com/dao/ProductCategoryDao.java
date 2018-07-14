package com.dao;

import java.util.List;

import com.entity.ProductCategory;

public interface ProductCategoryDao {
	
	/**
	 * 商品类型 菜单查询
	 * 返回值：List<ProductCategory>
	 * 请求参数：Integer pid
	 */
	public List<ProductCategory> queryProductCategory(Integer pid);
}
