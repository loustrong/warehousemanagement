package com.wistron.warehousemanagement.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器处理表单传到servlet的乱码问�?
 * @author gacl
 *
 */
public class CharacterEncodingFilter implements Filter {

	//存储系统使用的字符编�?
	private String encoding=null;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding在web.xml中指�?
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//解决表单提交时的中文乱码问题
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {

	}
}


