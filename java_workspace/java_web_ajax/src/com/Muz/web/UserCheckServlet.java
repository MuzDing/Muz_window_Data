package com.Muz.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Muz.servie.UserServie;
import com.Muz.dao.Userdao;

/**
 * Servlet implementation class UserCheckServlet
 */
@WebServlet("/UserCheckServlet")
public class UserCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserCheckServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = request.getParameter("num");
		String password = request.getParameter("password");
		// Userdao user=new Userdao();
		UserServie user = new UserServie();
		if (password.equals("")) {
			Boolean bool = user.isExist(num);
			if (bool) {
				PrintWriter out = response.getWriter();
				out.println("1");
			} else {
				PrintWriter out = response.getWriter();
				out.println("2");
			}
		} else {

			Boolean bool = user.logCheck(num, password);
			if (bool) {
				PrintWriter out = response.getWriter();
				out.println("1");
			} else {
				PrintWriter out = response.getWriter();
				out.println("2");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}