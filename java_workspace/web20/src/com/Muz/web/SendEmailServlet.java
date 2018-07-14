package com.Muz.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.Muz.message.HttpClientUtil;
import com.Muz.servce.UserService;

/**
 * Servlet implementation class SendEmailServlet
 */
@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String us_id = request.getParameter("usid");
		
		String phonecode="";
		UserService service = new UserService();
		
		try {
			phonecode = service.selectPhone(us_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.sendCode(phonecode,getCode(request));
		request.setAttribute("us_id", us_id);
		
		response.getWriter().print("1");
		
		
//		 try{  
//             System.out.println("start");  
//             Process pr = Runtime.getRuntime().exec("python d:\\sendemail.py");  
//               
//             BufferedReader in = new BufferedReader(new  
//                     InputStreamReader(pr.getInputStream()));  
//             String line;  
//             while ((line = in.readLine()) != null) {  
//                 System.out.println(line);  
//             }  
//             in.close();
//             pr.waitFor();  
//             System.out.println("end");  
//     } catch (Exception e){  
//                 e.printStackTrace();  
//             }  
//     } 
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Test
	public String getCode(HttpServletRequest request) {
 
		Random rand = new Random();
		String code = "";
		for (int i = 0; i < 4; i++) {
			code += rand.nextInt(10);
		}
		request.getSession().setAttribute("phonecode", code);
		return code;
	}

}
