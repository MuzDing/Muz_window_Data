package com.Muz.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Muz.domain.Product;
import com.Muz.servce.ProductService;

/**
 * Servlet implementation class SelectProductByIdServlet
 */
@WebServlet("/selectProductById")
public class SelectProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProductByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String shop_pid = request.getParameter("pid");
//		System.out.println(shop_pid);
		Product product_info =null;
		
		ProductService service = new ProductService();
		
		try {
			product_info = service.selectProductById(shop_pid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(product_info.getPid());
		request.setAttribute("product_info", product_info);
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/product_info.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
