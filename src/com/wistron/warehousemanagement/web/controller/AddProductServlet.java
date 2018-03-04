package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wistron.warehousemanagement.domain.Product;
import com.wistron.warehousemanagement.service.IProductService;
import com.wistron.warehousemanagement.service.IUserService;
import com.wistron.warehousemanagement.service.impl.ProductServiceImpl;
import com.wistron.warehousemanagement.service.impl.UserServiceImpl;
import com.wistron.warehousemanagement.util.WebUtils;
import com.wistron.warehousemanagement.web.formbean.ProductFormBean;
import com.wistron.warehousemanagement.web.formbean.RegisterFormBean;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product = WebUtils.request2Product(request);
		ProductFormBean productFormBean = new ProductFormBean();
		try {
			BeanUtils.copyProperties(productFormBean, product);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(productFormBean.validate()==false) {
			request.setAttribute("productFormBean", productFormBean);
			//校验失败就说明是用户填写的表单数据有问题，那么就跳转回register.jsp
			request.getRequestDispatcher("/WEB-INF/pages/").forward(request, response);
			return;
		}

		
			IProductService service = new ProductServiceImpl();
			service.addProduct(product);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
