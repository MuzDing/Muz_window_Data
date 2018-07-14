package com.Muz.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessTimeSertlet
 */
@WebServlet("/lastAccess")
public class LastAccessTimeSertlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LastAccessTimeSertlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获得当前时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		String currentTime = format.format(date);
		
		//1、创建Cookie 记录当前的最新的访问时间
		Cookie cookie = new Cookie("lastAccessTime",currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		
		//2、获得客户端携带cookie ---- lastAccessTime
		String lastAccessTime = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie coo : cookies){
				if("lastAccessTime".equals(coo.getName())){
					lastAccessTime = coo.getValue();
				}
			}
		}

		if(lastAccessTime==null){
			response.getWriter().write("您是第一次访问");
			response.getWriter().write("121212");
		}else{
			response.getWriter().write("您上次的访问的时间是："+lastAccessTime);
			response.getWriter().write("121212");
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