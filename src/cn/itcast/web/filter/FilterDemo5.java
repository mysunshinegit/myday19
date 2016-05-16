package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ֹ��������涯̬��Դ������jsp��Դ
public class FilterDemo5 implements Filter {
	private FilterConfig filterConfig;
	public void init(FilterConfig filterConfig) throws ServletException {	
		this.filterConfig = filterConfig;
	}
	//Web��������
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		
		//�����ӿ�ǿתΪ�ӽӿ�
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//NO1:ȡ�ÿͻ��˷��ʵ���Դ��URI����ʽ/myday19/login.jsp
		String uri = request.getRequestURI();
		//NO2:�ж��Ƿ���jsp��β������̬��Դ
		if(uri != null && uri.endsWith("jsp")) {
			//NO3:����Ƕ�̬��Դ������������Ӧͷ��֪ͨ�����������
			response.setHeader("expires", "-1");
			response.setHeader("cache-control", "no-cache");
			response.setHeader("pragma", "no-cache");
		}else if(uri != null && uri.endsWith("html")) {
			//NO4:����Ǿ�̬��Դ������һ����ʱ��
			String strHtml = filterConfig.getInitParameter("html");
			long time = System.currentTimeMillis() + Integer.parseInt(strHtml) * 1000;
			//timeΪ����ֵ
			response.setDateHeader("expires", time);
			response.setHeader("cache-control", time/1000+"");
			response.setHeader("pragma", time/1000+"");
		}
		//NO5:������Դ
		chain.doFilter(request, response);
	}
	public void destroy() {
	}
}
