package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductCategoryDao;
import com.dao.ProductCategoryDaoImpl;
import com.entity.ProductCategory;

public class PCServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProductCategoryDao pcd = new ProductCategoryDaoImpl();
		List<ProductCategory> pcls = pcd.queryProductCategory(null);
		req.setAttribute("pcls", pcls);
		req.getRequestDispatcher("MyJsp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
