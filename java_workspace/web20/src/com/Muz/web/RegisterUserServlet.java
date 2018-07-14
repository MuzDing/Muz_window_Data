package com.Muz.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.Muz.domain.Product;
import com.Muz.domain.User;
import com.Muz.servce.AdminProductService;
import com.Muz.servce.UserService;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");	
		//1、获取数据
		Map<String, String[]> properties = request.getParameterMap();
		//2、封装数据
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		String us_sex = request.getParameter("us_sex");
				
		user.setUs_sex(us_sex);
		
		//此位置Product已经封装完毕----将表单的数据封装完毕
		//手动设置表单中没有数据
		//1）、private String pid;
//		user.setPid(UUID.randomUUID().toString());
//		//2）、private String pimage;
//		user.setPimage("products/1/c_0033.jpg");
//		//3）、private String pdate;//上架日期
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String pdate = format.format(new Date());
//		user.setPdate(pdate);
//		//4）、private int pflag;//商品是否下载 0代表未下架
//		user.setPflag(0);
		
		//3、传递数据给service层
		UserService service = new UserService();
		try {
			service.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
