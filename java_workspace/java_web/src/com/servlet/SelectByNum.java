package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.untity.User;
import com.untity.Userdao;

/**
 * Servlet implementation class SelectByNum
 */
@WebServlet("/SelectByNum")
public class SelectByNum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		String num = request.getParameter("num");
		Userdao userdao = new Userdao();
		User user = userdao.selectByNum(num);
		request.setAttribute("person", user);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
