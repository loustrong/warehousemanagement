package com.wistron.warehousemanagement.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.wistron.warehousemanagement.domain.User;
import com.wistron.warehousemanagement.exception.UserExistException;
import com.wistron.warehousemanagement.service.IUserService;
import com.wistron.warehousemanagement.service.impl.UserServiceImpl;
import com.wistron.warehousemanagement.util.WebUtils;
import com.wistron.warehousemanagement.web.formbean.RegisterFormBean;

/**
 * 憭��瘜典��ervlet
 * 
 *
 */
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//撠恥�蝡舀�漱��”���撠�RegisterFormBean撖寡情嚙�?
		RegisterFormBean formbean = WebUtils.request2Bean(request,RegisterFormBean.class);
		//�撉�瘜典�‵���”��嚙�?
		if (formbean.validate() == false) {//憒�撉仃韐�
			//撠����憛怠��”�����ormbean撖寡情���egister.jsp憿菟��orm銵典�葉餈�蝷�
			request.setAttribute("formbean", formbean);
			System.out.println("帳號密碼驗證失敗！！");
			//�撉仃韐亙停霂湔���憛怠��”�����憸�銋停頝唾蓮��egister.jsp
			request.getRequestDispatcher("/WEB-INF/pages/register1.jsp").forward(request, response);
			System.out.println("跳轉失敗！！");
			return;
		}

		User user = new User();
		try {
			// 瘜典��泵銝脣����蓮��
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);//��”����憛怠�javabean嚙�?
			user.setId(WebUtils.makeId());//霈曄蔭����d撅蕭??
			IUserService service = new UserServiceImpl();
			//靚service撅���釣�����摰��瘜典��
			service.registerUser(user);
			String message = String.format(
					"Register Success! 3 secs will jump to <meta http-equiv='refresh' content='3;url=%s'/>", 
					request.getContextPath()+"/servlet/LoginUIServlet");
			System.out.println("註冊成功，正在跳轉！！");
			request.setAttribute("message",message);
			request.getRequestDispatcher("/message.jsp").forward(request,response);

		} catch (UserExistException e) {
			System.out.println("用戶已經存在！！");
			formbean.getErrors().put("userName", "User name is wrong.");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(); // ���霈啣��蕭?
			request.setAttribute("message", "Create fail.");
			System.out.println("chuangjianshibai!!");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
