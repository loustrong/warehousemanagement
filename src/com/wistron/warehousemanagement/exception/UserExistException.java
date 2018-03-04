package com.wistron.warehousemanagement.exception;

/**
 * @author gacl
 * 自定义异�?
 */
public class UserExistException extends Exception {

	public UserExistException() {
		super();
	}

	public UserExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistException(String message) {
		super(message);
	}

	public UserExistException(Throwable cause) {
		super(cause);
	}
}
