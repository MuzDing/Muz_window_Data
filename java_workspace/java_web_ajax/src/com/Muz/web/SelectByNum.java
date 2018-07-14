package com.Muz.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.untity.User;
import com.Muz.dao.Userdao;
import com.Muz.servie.UserServie;

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
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");

		UserServie us = new UserServie();

		List<User> list = null;
		list = us.selectByNum(num);
		String str = "{user:[";
		if (list != null) {
			for (User user : list) {
				str = str + "{name:'" + user.getName() + "',num:'" + user.getNum() + "',password:'" + user.getPassword()
						+ "',age:'" + user.getAge() + "',sex:'" + user.getSex() + "',hobby:'" + user.getHobby()
						+ "',sheng:'" + user.getSheng() + "',shi:'" + user.getShi() + "',},";
			}
		}
		str = str + "]}";
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(str.toString());
	}

}