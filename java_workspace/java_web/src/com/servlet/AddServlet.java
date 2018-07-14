package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.untity.User;
import com.untity.Userdao;

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
		String[] hobby = request.getParameterValues("hobby");
		String sheng = request.getParameter("sheng").toString();
		String shi = request.getParameter("shi").toString();
		User user = new User();
		user.setUserPhone(num);
		user.setUserPassword(password);
		int i = hobby.length;

		Userdao u = new Userdao();
		int rs = u.Add(user);

		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		response.getWriter().write("<html>");
		response.getWriter().write("<title>");
		response.getWriter().write("新增");
		response.getWriter().write("</title>");
		response.getWriter().write("<form>");
		response.getWriter().write("<form>");
		response.getWriter().write("姓名：" + name + "<br>");
		response.getWriter().write("手机号：" + num + "<br>");
		response.getWriter().write("年龄：" + age + "<br>");
		response.getWriter().write("性别：" + sex + "<br>");
		response.getWriter().write("爱好：");
		for (int j = 0; j < i; j++) {
			response.getWriter().write(hobby[j] + " ");
		}
		response.getWriter().write("<br>");
		response.getWriter().write("生源地：" + sheng + shi + "<br>");
		if (rs == 1) {
			response.getWriter().write("添加成功！");
		} else {
			response.getWriter().write("添加失败！");
		}
		response.getWriter().write("<input type='button' value='确定' onclick=first.jsp>");
		response.getWriter().write("<form>");
		response.getWriter().write("</body>");
		response.getWriter().write("</html>");
	}

}
