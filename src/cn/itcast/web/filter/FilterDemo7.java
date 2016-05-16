package cn.itcast.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

//������Ŀ¼���б���
public class FilterDemo7 implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {	
	}
	//Web��������
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		
		//�����ӿ�ǿתΪ�ӽӿ�
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//������������뷽ʽ
		request.setCharacterEncoding("UTF-8");
		
		//ȡ���û��������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(username != null && password != null && role != null && username.trim().length() > 0 && password.trim().length() > 0 && role.trim().length() > 0) {
			if("��ͨ�û�".equals(role)){
				request.setAttribute("message", "��ӭ��ͨ�û�<font color='green'>"+username+"</font>��¼");
				request.setAttribute("flag", "user");
			}else if("����Ա".equals(role)){
				request.setAttribute("message", "��ӭ����Ա<font color='green'>"+username+"</font>��¼");
				request.setAttribute("flag", "admin");
			}
			//request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
	}
}
