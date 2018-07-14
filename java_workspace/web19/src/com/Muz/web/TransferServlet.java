package com.Muz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Muz.servie.TransferService;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接受转账的参数
		String out = request.getParameter("out");
		String in = request.getParameter("in");
		String moneyStr = request.getParameter("money");
		double money = Double.parseDouble(moneyStr);
		
		//调用业务层的转账方法
		TransferService service = new TransferService();
		boolean isTransferSuccess = service.transfer(out,in,money);
		
		response.setContentType("text/html;charset=UTF-8");
		
		if(isTransferSuccess){
			response.getWriter().write("转账成功！！！");
		}else{
			response.getWriter().write("转账失败！！！");
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
