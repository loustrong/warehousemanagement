package com.wistron.warehousemanagement.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import com.wistron.warehousemanagement.domain.Product;

/**
 * 
 * ��equest撖寡情銝剔�窈瘙�撠�bean嚙�?
 */
public class WebUtils {

	/**
	 * 撠equest撖寡情頧祆��撖寡情
	 * @param request 
	 * @param clazz
	 * @return
	 */
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try{
			T bean = clazz.newInstance();
			Enumeration<String> e = request.getParameterNames(); 
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ���UID
	 * @return
	 */
	public static String makeId(){
		return UUID.randomUUID().toString();
	}
	
	public static Product request2Product(HttpServletRequest request) throws UnsupportedEncodingException {
		Product product = new Product();
		
	    System.out.println("ID"+request.getParameter("id")+"Name:"+request.getParameter("name")+"Price:"+request.getParameter("price")+"Type:"+request.getParameter("type"));
		
		
		if(request.getParameter("id")==""||request.getParameter("id")=="null"||request.getParameter("id")==null) {
			product.setId("");
		}else {
			product.setId(request.getParameter("id"));
		}
		
		if(request.getParameter("keeper")==""||request.getParameter("keeper")=="null"||request.getParameter("keeper")==null) {
			product.setKeeper("");
			
		}else {
			
			product.setKeeper(request.getParameter("keeper"));
		}
		
		if(request.getParameter("location")==""||request.getParameter("location")=="null"||request.getParameter("location")==null) {
			product.setLocation("");
		}else {
			product.setLocation(request.getParameter("location"));
		}
		
		if(request.getParameter("modifiedTime")==""||request.getParameter("modifiedTime")=="null"||request.getParameter("modifiedTime")==null) {
			product.setModifiedTime("");
		}else {
			product.setModifiedTime(request.getParameter("modifiedTime"));
		}
		if(request.getParameter("name")==""||request.getParameter("name")=="null"||request.getParameter("name")==null) {
			product.setName("");
		}else {
			product.setName(request.getParameter("name"));
		}
		
		if(request.getParameter("price")==""||request.getParameter("price")=="null"||request.getParameter("price")==null) {
			product.setPrice("");
		}else {
			product.setPrice(request.getParameter("price"));
		}
		
		if(request.getParameter("quantity")==""||request.getParameter("quantity")=="null"||request.getParameter("quantity")==null) {
			product.setQuantity(0);
		}else {
			product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		}
		
		if(request.getParameter("type")==""||request.getParameter("type")=="null"||request.getParameter("type")==null) {
			product.setType("");
		}else {
			product.setType(request.getParameter("type"));
		}	
		

		System.out.println("ID:"+product.getId()+"Keeper:"+product.getKeeper()+"Location:"+product.getLocation()+"ModifiedTime:"+product.getModifiedTime()+"Name:"+product.getName()+"Price:"+product.getPrice()+"Quantity:"+product.getQuantity()+"Type:"+product.getType()+".");
		return product;
		
		
		
		
	}
	
}
