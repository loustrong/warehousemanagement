package com.wistron.warehousemanagement.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author gacl
 * 銝箇����釣��������ervlet
 * RegisterUIServlet韐提銝箇�颲瘜典���?
 * 敶�霈輸RegisterUIServlet�嚗停頝唾蓮�WEB-INF/pages�敶��egister.jsp憿菟
 */
public class RegisterUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		//response.sendRedirect("/WEB-INF/pages/register.jsp");
		//response.sendRedirect(request.getContextPath() + "/pages/register1.jsp");
		//request.getRequestDispatcher("/register.jsp").forward(request, response); 
		response.sendRedirect("/WarehouseManagement/register.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
