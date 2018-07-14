package com.Muz.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Muz.domain.CartItem;
import com.Muz.domain.Product;
import com.Muz.domain.User;
import com.Muz.servce.ProductService;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
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
		User user =null;
		Product product = null;
		ArrayList<CartItem> cartItemList = null;
		//System.out.println(shop_pid);
		//获取Session
		Map<String,ArrayList<CartItem>> cartproductList=(HashMap<String,ArrayList<CartItem>>)request.getSession().getAttribute("cartproductList");
		CartItem  cartItem =null;
		//List<Product> cartproductList= (List<Product>)request.getSession().getAttribute("cartproductList");
		
		ProductService service = new ProductService();
		try {
			product = service.selectProductById(shop_pid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null == cartproductList) {
			cartproductList = new HashMap<String, ArrayList<CartItem>>();
		}
		System.out.println(product);
		if(product!=null) {
			//获取用户名
			user = (User) request.getSession().getAttribute("user");
			if(user!=null) {
				String user_id = user.getUs_id();
				//获取购物车列表
				cartItemList = cartproductList.get(user_id);
				if(cartItemList == null) {
					cartItemList =  new ArrayList<CartItem>();
				}
				//cartItem = cartproductList.get(arg0);
				//添加商品信息到购物车
				
				int temp=0;
				//判断购物车是否有商品
				if(cartItemList==null || cartItemList.size()==0) {
					cartItem = new CartItem(); 
					cartItem.setProduct(product);
					cartItem.setNumber(1);
					
				}else {
					boolean flag=false;
					for (CartItem tempcartItem : cartItemList) {
						
						if(tempcartItem.getProduct().equals(product)) {
							temp =tempcartItem.getNumber()+1;
							tempcartItem.setNumber(temp);
							flag=true;
							break;
						}
					}
					if(flag=false) {
						cartItem = new CartItem(); 
						cartItem.setProduct(product);
						cartItem.setProduct(product);
						cartItemList.add(cartItem);
					}
					
					
				}
				cartItemList.add(cartItem);
				//更新购物车
				cartproductList.put(user_id, cartItemList);
				request.getSession().setAttribute("cartproductList", cartproductList);
				//request.getRequestDispatcher("/product_info.jsp").forward(request, response);				
				response.sendRedirect(request.getContextPath() + "/product_info.jsp");
			}else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
			
		}	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
