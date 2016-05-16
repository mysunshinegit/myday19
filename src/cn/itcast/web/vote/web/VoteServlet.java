package cn.itcast.web.vote.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.web.vote.domain.Content;
import cn.itcast.web.vote.domain.User;
import cn.itcast.web.vote.domain.Vote;
import cn.itcast.web.vote.service.VoteService;

public class VoteServlet extends HttpServlet {
	//安全退出
	public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "安全退出失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	}
	
	//根据ID查询候选人详细信息
	public void findVoteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			VoteService voteService = new VoteService();
			Content content = voteService.findContentById(Integer.parseInt(id));
			request.setAttribute("content", content);
			request.getRequestDispatcher("/WEB-INF/listContent.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "根据ID查询候选人详细信息失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	}
	
	//查询所有的候选人信息
	public void findAllVote(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			VoteService voteService = new VoteService();
			List<Vote> voteList = voteService.findAllVote();
			request.setAttribute("voteList", voteList);
			request.getRequestDispatcher("/WEB-INF/listAllVote.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查询所有候选人信息失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method != null) {
			if("findAllVote".equals(method)) {
				this.findAllVote(request, response);
			}else if("findVoteById".equals(method)) {
				this.findVoteById(request, response);
			}else if("toLoginJsp".equals(method)) {
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}else if("exit".equals(method)) {
				this.exit(request, response);
			}
		}
	}
	
	//投票用户登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		if(username != null && username.trim().length() > 0) {
			User user = new User();
			user.setUsername(username);
			request.getSession().setAttribute("user", user);
			response.sendRedirect(request.getContextPath()+"/welcome.jsp");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method != null) {
			if("login".equals(method)) {
				this.login(request, response);
			}
		}
	}
}
