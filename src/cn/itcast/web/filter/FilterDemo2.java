package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//自定义Filter过滤器
public class FilterDemo2 implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		//放行请求
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}
