package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.ProductCategory;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {

	@Override
	public List<ProductCategory> queryProductCategory(Integer pid) {
		List<ProductCategory> pcls = new ArrayList<ProductCategory>();
		
		String sql = null;
		if(pid == null){
			sql = "SELECT * from product_category WHERE pid is null";
		}else{
			sql = "SELECT * from product_category WHERE pid = "+pid;
		}
		
		try {
			ResultSet rs = super.execQuery(sql, null);
			while (rs.next()) {
				ProductCategory pc = new ProductCategory();
				
				pc.setCategoryName(rs.getString("category_name"));
				pc.setId(rs.getInt("id"));
				pc.setPid(rs.getInt("pid"));
				
				pc.setPcs(queryProductCategory(rs.getInt("id")));
				pcls.add(pc);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pcls;
	}

//	@Override
//	public List<ProductCategory> queryProductCategory(Integer pid) {
//		List<ProductCategory> pcls1 = new ArrayList<ProductCategory>();
//		
//		String sql = "SELECT * from product_category WHERE pid is null";
//		try {
//			ResultSet rs1 = super.execQuery(sql, null);
//			while (rs1.next()) {
//				ProductCategory pc1 = new ProductCategory();
//				
//				pc1.setCategoryName(rs1.getString("category_name"));
//				pc1.setId(rs1.getInt("id"));
//				pc1.setPid(rs1.getInt("pid"));
//				
//				String sql2 = "SELECT * from product_category WHERE pid = ?";
//				Object [] paras = {rs1.getInt("id")};
//				ResultSet rs2 = super.execQuery(sql2, paras);
//				List<ProductCategory> pcls2 = new ArrayList<ProductCategory>();
//				while(rs2.next()){
//					ProductCategory pc2 = new ProductCategory();
//					
//					pc2.setCategoryName(rs2.getString("category_name"));
//					pc2.setId(rs2.getInt("id"));
//					pc2.setPid(rs2.getInt("pid"));
//					
//					pcls2.add(pc2);
//				}
//				
//				pc1.setPcs(pcls2);
//				
//				pcls1.add(pc1);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return pcls1;
//	}

}
