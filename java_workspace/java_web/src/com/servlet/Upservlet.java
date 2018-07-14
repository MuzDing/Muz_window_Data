package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.untity.User;
import com.untity.Userdao;

/**
 * Servlet implementation class Upservlet
 */
@WebServlet("/Upservlet")
public class Upservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("num");
		String count = "";
		if (num == null || num.equals("") || num.equals("null")) {
			num = "1";
		}
		int i = Integer.parseInt(num);
		i = i - 2;
		Userdao userdao = new Userdao();

		List<User> list = userdao.getAll(i);
		try {
			count = userdao.getCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
		int j = Integer.parseInt(count) / 3 + 2;
		String jString = i + "";
		String mcount = j + "";
		request.setAttribute("list", list);
		request.setAttribute("num", jString);
		request.setAttribute("count", mcount);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}