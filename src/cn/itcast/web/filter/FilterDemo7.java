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

//对敏感目录进行保护
public class FilterDemo7 implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {	
	}
	//Web容器调用
	public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) throws IOException, ServletException {
		
		//将父接口强转为子接口
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//设置请求体编码方式
		request.setCharacterEncoding("UTF-8");
		
		//取得用户请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(username != null && password != null && role != null && username.trim().length() > 0 && password.trim().length() > 0 && role.trim().length() > 0) {
			if("普通用户".equals(role)){
				request.setAttribute("message", "欢迎普通用户<font color='green'>"+username+"</font>登录");
				request.setAttribute("flag", "user");
			}else if("管理员".equals(role)){
				request.setAttribute("message", "欢迎管理员<font color='green'>"+username+"</font>登录");
				request.setAttribute("flag", "admin");
			}
			//request.getRequestDispatcher("/welcome.jsp").forward(request, response);
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
	}
}
