package com.Muz.content;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentServlet
 */
@WebServlet("/content")
public class ContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1、获得单个表单值
		String username = request.getParameter("username");
		System.out.println(username);
		String password = request.getParameter("password");
		System.out.println(password);
		//2、获得多个表单的值
		String[] hobbys = request.getParameterValues("hobby");
		for(String hobby:hobbys){
			System.out.println(hobby);
		}
		//3、获得所有的请求参数的名称
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			System.out.println(parameterNames.nextElement());
		}
		System.out.println("------------------");
		//4、获得所有的参数 参数封装到一个Map<String,String[]>
		Map<String, String[]> parameterMap = request.getParameterMap();
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()){
			System.out.println(entry.getKey());
			for(String str:entry.getValue()){
				System.out.println(str);
			}
			System.out.println("---------------------------");
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