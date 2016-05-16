package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//����������Ӧ�ı��뷽ʽ����
public class FilterDemo4 implements Filter {
	private FilterConfig filterConfig;
	public FilterDemo4() {
	}
	public void init(FilterConfig filterConfig) throws ServletException {	
		this.filterConfig = filterConfig;
	}
	//Web��������
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		String encoding = filterConfig.getInitParameter("encoding");
		//POST�����������
		request.setCharacterEncoding("UTF-8");
		
		//��Ӧ��������
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
