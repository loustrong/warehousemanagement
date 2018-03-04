package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response){
		String name=request.getParameter("name");
		PrintWriter out=null;
		try {
			out=response.getWriter();
			out.write("{'message':'"+name+"'}");		
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			out.close();
		}
		
	}
}
