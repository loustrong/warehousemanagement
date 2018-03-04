package com.wistron.warehousemanagement.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * 撠���瘜典�”��ean嚗���register.jsp銝剔�”���憿寧��?
 * RegisterFormBean銝剔��?找�egister.jsp銝剔�”���憿寧�ame銝?銝?撖孵��
 * RegisterFormBean���提�鈭�提��register.jsp銝剔�”���憿寧��潔����遙��?�撉”���憿寧��潛����?
 * @author gacl
 *
 */
public class RegisterFormBean {

	//RegisterFormBean銝剔��?找�egister.jsp銝剔�”���憿寧�ame銝?銝?撖孵��
	//<input type="text" name="userName"/>
	private String userName;
	//<input type="password" name="userPwd"/>
	private String userPwd;
	//<input type="password" name="confirmPwd"/>
	private String confirmPwd;
	
	

	
	/**
	 * 摮�撉�?�蝏����秤��內靽⊥�?
	 */
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	/*
	 * validate�瘜�提�撉”���憿?
	 * 銵典��憿寞撉����
	 * 		private String userName; �����銝箇征嚗僎銝�3-8����? abcdABcd 
	 * 		private String userPwd; 撖��銝箇征嚗僎銝��?3-8��摮?
	 * 		private String confirmPwd; 銝斗活撖�����?
	 * 		private String email; �隞乩蛹蝛綽��蛹蝛箄�銝?銝芸���蝞� 
	 * 		private String birthday; �隞乩蛹蝛綽��蛹蝛箸嚗�銝?銝芸������
	 */
	public boolean validate() {

		boolean isOk = true;

		if (this.userName == null || this.userName.trim().equals("")) {
			isOk = false;
			errors.put("userName", "�����銝箇征嚗�?");
			System.out.println("userName null");
		} else {
			if (!this.userName.matches("[a-zA-Z]{3,8}")) {
				isOk = false;
				errors.put("userName", "�����◆�3-8雿������");
				System.out.println("userName");
			}
		}

		if (this.userPwd == null || this.userPwd.trim().equals("")) {
			isOk = false;
			errors.put("userPwd", "撖��銝箇征嚗��");
			System.out.println("pwd null");
		} else {
			if (!this.userPwd.matches("\\d{3,8}")) {
				isOk = false;
				errors.put("userPwd", "撖��◆��?3-8雿�摮���");
				System.out.println("pwd");
			}
		}

		// private String password2; 銝斗活撖�����?
		if (this.confirmPwd != null) {
			if (!this.confirmPwd.equals(this.userPwd)) {
				isOk = false;
				errors.put("confirmPwd", "銝斗活撖����嚗�?");
				System.out.println("confirmedpwd");
			}
		}

		
		

		return isOk;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}


}
