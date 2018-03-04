package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wistron.warehousemanagement.web.TokenProccessor;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String token = TokenProccessor.getInstance().makeToken();//创建令牌
	        System.out.println("在FormServlet中生成的token："+token);
	        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
	        request.getRequestDispatcher("/form.jsp").forward(request, response);//跳转到form.jsp页面
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
