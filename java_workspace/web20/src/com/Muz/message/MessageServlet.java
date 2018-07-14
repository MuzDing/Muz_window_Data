package com.Muz.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		 String phone=request.getParameter("phone");     
//	        response.setCharacterEncoding("UTF-8");   
//	        //获取验证码  
//	        String code = getCode(request);  
//	        //发送短信  
//	        //sendMsg(phone,code);  
//	        response.getWriter().write("true");     
//	        response.flushBuffer();    
		System.out.println("A");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//发送短信  
    private void sendMsg(String phone,String code) throws  IOException {  
    }  
      
    //获取验证码  
    private String getCode(HttpServletRequest request) {  
//        Random rand =new Random();  
//        String code = "";  
//        for(int i=0;i<4;i++) {  
//            code += rand.nextInt(10);  
//        }  
//        request.getSession().setAttribute("code",code);  
          return null;  
    }  

}
