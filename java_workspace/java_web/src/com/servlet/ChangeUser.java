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
 * Servlet implementation class ChangeUser
 */
@WebServlet("/ChangeUser")
public class ChangeUser extends HttpServlet {
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
		String num = request.getParameter("num").toString();
		String password = request.getParameter("king").toString();
		String state = request.getParameter("sta").toString();
		User user = new User();
		user.setUserPhone(num);
		user.setUserPassword(password);
		user.setState(state);
		Userdao userdao = new Userdao();
		int rs = userdao.changeByNum(user);
		String rs1 = rs + "";
		request.setAttribute("rs1", rs1);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
