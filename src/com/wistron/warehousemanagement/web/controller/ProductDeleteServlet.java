package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wistron.warehousemanagement.domain.Product;
import com.wistron.warehousemanagement.service.IProductService;
import com.wistron.warehousemanagement.service.impl.ProductServiceImpl;
import com.wistron.warehousemanagement.util.WebUtils;

/**
 * Servlet implementation class ProductDeleteServlet
 */
@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = WebUtils.request2Product(request);
		if(product.getId()==""||product.getId()==null||product.getId()=="null") {
			return;
		}
		IProductService service = new ProductServiceImpl();
		
		service.deleteProduct(product);
		
		
	}

	  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
