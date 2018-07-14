package com.Muz.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.UIManager;

import com.Muz.servie.UserServie;
import com.untity.User;
import com.Muz.dao.Userdao;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
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

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name").toString();
		String num = request.getParameter("num").toString();
		String age = request.getParameter("age").toString();
		String password = request.getParameter("password").toString();
		String sex = request.getParameter("sex").toString();
		String hobby[] = request.getParameterValues("hobby");
		String sheng = request.getParameter("sheng").toString();
		String shi = request.getParameter("shi").toString();
		String hobbies = "";

		int i = hobby.length;
		for (int j = 0; j < i; j++) {
			hobbies = hobbies + hobby[j] + ",";
		}
		User user = new User();
		user.setName(name);
		user.setNum(num);
		user.setPassword(password);
		user.setAge(age);
		user.setSex(sex);
		user.setHobby(hobbies);
		user.setSheng(sheng);
		user.setShi(shi);

		UserServie u = new UserServie();
		int rs = u.Add(user);

		if (rs == 1) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("2");
		}

	}

}
