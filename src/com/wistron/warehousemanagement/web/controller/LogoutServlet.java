package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//蝘駁摮�session銝剔�ser撖寡情嚗�瘜券�?��
		request.getSession().removeAttribute("user");
		//�鈭�泵銝脖葉������嚗餈��銝蝙�MessageFormat.format�瘜�摮泵銝脫撠曹��憸?
		//MessageFormat.format�瘜����泵銝脖葉������������捆憛怠�������泵銝?
		String tempStr1 = MessageFormat.format(
				"You are loginout,please wait 3 secs. <meta http-equiv='refresh' content='3;url={0}'/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		System.out.println(tempStr1);//颲蝏��釣��?������3蝘�蛹���頝喳�敶△�嚗��<meta http-equiv=refresh content=3;url={0}/>
		System.out.println("---------------------------------------------------------");
		/**
		 * 閬閫��"憒������泵銝脣�����嚗銋essageFormat.format�瘜停�����泵銝脖葉������������捆憛怠�������泵銝�"餈葵�憸�?
		 * �銋隞仿�?閬蝙����撘絲����泵銝脖葉雿輻2銝芸��撘絲�嚗���?"<meta http-equiv=''refresh'' content=''3;url={0}''/>"
		 * 餈MessageFormat.format("<meta http-equiv=''refresh'' content=''3;url={0}''/>","index.jsp")撠勗隞交迤撣貉��?
		 * <meta http-equiv=''refresh'' content=''3;url=index.jsp'/>
		 */
		String tempStr2 = MessageFormat.format(
				"Is Logout <meta http-equiv=''refresh'' content=''3;url={0}''/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		/**
		 * 颲蝏��?
		 * 瘜券�������3蝘�蛹���頝喳�敶△�嚗��
		 * <meta http-equiv='refresh' content='3;url=/webmvcframework/servlet/LoginUIServlet'/>
		 */
		System.out.println(tempStr2);
		
		String message = String.format(
				"You Are Logout !!!! !!!!<meta http-equiv='refresh' content='3;url=%s'/>", 
				request.getContextPath()+"/servlet/LoginUIServlet");
		request.setAttribute("message",message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
