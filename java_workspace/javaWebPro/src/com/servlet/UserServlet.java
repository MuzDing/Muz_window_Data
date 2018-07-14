package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biz.UserBiz;
import com.biz.UserBizImpl;
import com.entity.SysUser;
import com.util.MD5Util;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserBiz ub = new UserBizImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置session失效时间，单位秒
	    //session.setMaxInactiveInterval(5);
		
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		String action = request.getParameter("action");
		if("unLogin".equals(action)){
			//注销
			unLogin(session,application,response);
		}else if("login".equals(action)){
			//登录
			login(session,application,request,response);
		}else if("queryUserList".equals(action)){
			queryUserList(request,response);
		}else if("updateStatus".equals(action)){
			updateStatus(request,response);
		}
	}
	
	public void updateStatus(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String userId = request.getParameter("userId");
		ub.updateUserStatus(1, Integer.valueOf(userId));
		response.sendRedirect("index.jsp?updateStatusBool=true");
	}
	
	/**
	 * 查询全部用户
	 */
	public void queryUserList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		String userName = request.getParameter("userName");
		String userRole = request.getParameter("userRole");
		
		//当前页
		String pi = request.getParameter("pageIndex");
		int pageIndex = Integer.valueOf(pi);
		
		int pageSize = 3;
		//起始位置 = 每页显示的记录数 * (当前页 - 1)
		int startIndex = pageSize * (pageIndex - 1);
		
		int uc = ub.queryUserCount(userName,userRole);
		//总页数
		int pageTotal = 0;
		if(uc % pageSize == 0){
			//判断总记录数和每页显示的数量相除有没有余数，如果有余数则总页数为: 总记录数 / 每页显示的数量
			pageTotal = uc / pageSize;
		}else{
			//如果有余数则总页数为: 总记录数 / 每页显示的数量 + 1
			pageTotal = uc / pageSize + 1;
		}
		
		List<SysUser> uls = ub.queryUserList(startIndex, pageSize,userName,userRole);
		request.setAttribute("userList", uls);
		//当前页
		request.setAttribute("pageIndex", pageIndex);
		//尾页
		request.setAttribute("pageTotal", pageTotal);
		
		//查询条件-用户名
		request.setAttribute("userName", userName);
		//查询条件-角色
		request.setAttribute("userRole", userRole);
		//response.sendRedirect("index.jsp");
		//转发到index.jsp页面
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * 注销
	 */
	private void unLogin(HttpSession session,ServletContext application,HttpServletResponse response) throws IOException{
		session.removeAttribute("userLogin");

//		int userCount = 0;
//		Object object = application.getAttribute("userCount");
//		if(object != null){
//			userCount = Integer.valueOf(object.toString());
//		}
//		userCount--;
//		application.setAttribute("userCount", userCount);
		
		response.sendRedirect("login.jsp");
	}
	
	/**
	 * 登录
	 */
	private void login(HttpSession session,ServletContext application,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int type = -1;//-1:用户名或密码错误,0:用户未启用,1:正常
		
		
		SysUser u = null;
		try {
			u = ub.login(userName, MD5Util.getMD5(password));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(u != null){
			
			if(u.getUsrStatus() == 0){
				type = 0;
				response.sendRedirect("login.jsp?type="+type);
			}else{
				ub.updateUserNum(0,u.getUsrId());
				type = 1;
				session.setAttribute("userLogin", u);
		    	
		    	Cookie ck = new Cookie("userNameCookie",userName);
		    	//设置实效时间,单位秒
		    	ck.setMaxAge(5);
		    	Cookie ck2 = new Cookie("passwordCookie",password);
		    	ck2.setMaxAge(5);
		    	
		    	response.addCookie(ck);
		    	response.addCookie(ck2);
		    	
				response.sendRedirect("main.jsp");
			}
		}else{
			//根据用户名查询用户对象
			SysUser user = ub.queryUserByUserName(userName);
			if(user != null){
				//判断错误次数是否为三次或三次以上，这里判断2是因为判断是在修改之前进行的
				if(user.getUsrNum() >= 2){
					ub.updateUserStatus(0, user.getUsrId());
				}else{
					//修改用户错误次数
					ub.updateUserNum(user.getUsrNum()+1,user.getUsrId());
				}
			}
			
			type = -1;
			response.sendRedirect("login.jsp?type="+type);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
