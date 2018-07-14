package com.Muz.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;

import com.Muz.domain.Admin;
import com.Muz.domain.Product;
import com.Muz.domain.User;
import com.Muz.message.HttpClientUtil;
import com.Muz.servce.AdminService;
import com.Muz.servce.UserService;

/**
 * Servlet implementation class UserloginServlet
 */
@WebServlet("/userlogin")
public class UserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String us_id = request.getParameter("userid");
		String us_password = request.getParameter("userpassword");
		String us_code = request.getParameter("usercode");
		HttpSession session = request.getSession();
		String us_phonecode = (String) session.getAttribute("phonecode");
		System.out.println(us_phonecode +"is exist" +us_code);
		UserService service = new UserService();
		User user =null;
		
		
		try {
			user  = service.loginUser(us_id, us_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//HttpSession session = request.getSession();
		

		if(user!=null ) {
			if(!us_code.equals(us_phonecode)) {
				response.sendRedirect(request.getContextPath());
			}
			
			//登录成功
			//判断用户是否勾选自动登录
			String autoLogin = request.getParameter("autoLogin");
			if(autoLogin!=null){
				 
				//对中文张三进行编码
			//	String username_code = URLEncoder.encode(username, "UTF-8");// 中文 张三
				
				Cookie cookie_username = new Cookie("cookie_username",us_id);
				Cookie cookie_password = new Cookie("cookie_password",us_password);
				//设置cookie的持久化时间
				cookie_username.setMaxAge(60*60);
				cookie_password.setMaxAge(60*60);
				//设置cookie的携带路径
				cookie_username.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				//发送cookie
				response.addCookie(cookie_username);
				response.addCookie(cookie_password);
			}
			
			//将登录的用户的user对象存到session中
			session.setAttribute("user", user);
			//重定向到首页
			response.sendRedirect(request.getContextPath());
			
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
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
