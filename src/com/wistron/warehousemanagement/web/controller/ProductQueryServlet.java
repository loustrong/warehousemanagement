package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wistron.warehousemanagement.domain.Product;
import com.wistron.warehousemanagement.service.IProductService;
import com.wistron.warehousemanagement.service.impl.ProductServiceImpl;
import com.wistron.warehousemanagement.util.WebUtils;
import com.wistron.warehousemanagement.web.pagebean.PageBean;

/**
 * Servlet implementation class ProductQueryServlet
 */
@WebServlet("/ProductQueryServlet")
public class ProductQueryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PageBean pagebean = new PageBean();
		int totalnumber;
//		String keeper = (String) request.getParameter("keeper");
//		String location = (String) request.getParameter("location");
//		String modifiedTime = (String) request.getParameter("modifiedTime");
//		String name = (String) request.getParameter("name");
//		String price = (String) request.getParameter("price");
//		String quantity = (String) request.getParameter("quantity");
//		String type = (String) request.getParameter("type");
		//System.out.println("before before id:"+id);
		int currentPage;
		Product product = WebUtils.request2Product(request);
		
		
		String id=(String)request.getAttribute("id");
		String keeper=(String)request.getAttribute("keeper");
		String location=(String)request.getAttribute("location");
		String modifiedTime=(String)request.getAttribute("modifiedTime");
		String name=(String)request.getAttribute("name");
		String price=(String)request.getAttribute("price");
		String quantity=(String)request.getAttribute("quantity");
		String type=(String)request.getAttribute("type");
		

		if(request.getParameter("currentPage")!=null) {
			currentPage= Integer.parseInt(request.getParameter("currentPage"));
			System.out.println("currentPage:"+currentPage);
		}else {currentPage=0;}
		
		List<Product> list = new ArrayList<Product>();
		IProductService service = new ProductServiceImpl();
		list = service.queryProduct(product,currentPage);
		
		
		if(request.getParameter("totalnumber")!=null) {
			totalnumber= Integer.parseInt(request.getParameter("totalnumber"));
		}else {totalnumber=list.size();}
		
		
		pagebean.setTotalnumber(totalnumber);
		pagebean.setCurrentPage(currentPage);
		
		
		System.out.println("list's size:"+list.size());
	
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("list",list);
		request.setAttribute("currentPage", currentPage);
		
		
		request.setAttribute("id", id);
		request.setAttribute("keeper", keeper);
		request.setAttribute("location", location);
		request.setAttribute("modifiedTime", modifiedTime);
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("quantity", quantity);
		request.setAttribute("type", type);
		
		request.getRequestDispatcher("/queryProductResult03.jsp").forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
