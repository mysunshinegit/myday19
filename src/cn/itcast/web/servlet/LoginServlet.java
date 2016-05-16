package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�û��Զ���¼
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && password != null && username.trim().length() > 0 && password.trim().length() > 0) {
			if(username.equals("jack") && password.equals("123")) {
				//��¼�ɹ�������Ϣ�󶨵�HttpSession�������
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("password", password);
				//�������д��Cookie
				Cookie cookie = new Cookie("usernameAndPassword", username+"_"+password);
				int time = Integer.parseInt(request.getParameter("time"));
				cookie.setMaxAge(time);
				response.addCookie(cookie);	
				//�ض���welcome.jsp
				response.sendRedirect(request.getContextPath()+"/welcome.jsp");
			}
		}
	}
}
