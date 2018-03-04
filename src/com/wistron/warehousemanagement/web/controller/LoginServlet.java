package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wistron.warehousemanagement.domain.User;
import com.wistron.warehousemanagement.service.IUserService;
import com.wistron.warehousemanagement.service.impl.UserServiceImpl;

/**
 * 憭���敶�ervlet
 * @author gacl
 *
 */
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//����憛怠��敶����
		String username = request.getParameter("userName");
		//����憛怠��敶��?
		String password = request.getParameter("userPwd");
		
		IUserService service = new UserServiceImpl();
		//���敶�
		User user = service.loginUser(username, password);
		if(user==null){
			String message = String.format(
					"Username can't be empty~~~ <meta http-equiv='refresh' content='2;url=%s'", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//�敶����停撠�摮�session銝?
		request.getSession().setAttribute("user", user);
		String message = String.format(
				"Congratulation,%s!Login in Successful! ! <meta http-equiv='refresh' content='3;url=%s'", 
				user.getUserName(),
				request.getContextPath()+"/queryui.jsp");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
