package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		Object obj = req.getSession().getAttribute("userLogin");
		//获取页面路径 如："/index.jsp"
		String path = req.getServletPath();
		//判断是否是登录页面
		if(path.indexOf("login.jsp") != -1 || path.indexOf("reg.jsp") != -1 || path.indexOf("upload.jsp") != -1){
			arg2.doFilter(arg0, arg1);
		}else{
			//判断用户是否登录
			if(obj != null){
				arg2.doFilter(arg0, arg1);
			}else{
				resp.sendRedirect("login.jsp");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
