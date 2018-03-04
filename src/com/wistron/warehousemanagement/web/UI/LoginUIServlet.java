package com.wistron.warehousemanagement.web.UI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author gacl
 * LoginUIServlet韐提銝箇�颲�����?
 * 敶�霈輸LoginUIServlet�嚗停頝唾蓮�WEB-INF/pages�敶��ogin.jsp憿菟
 */
public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//request.getRequestDispatcher("/login.jsp").forward(request, response);
	
	//	request.getRequestDispatcher("/login.jsp").forward(request, response);
		response.sendRedirect("/WarehouseManagement/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
