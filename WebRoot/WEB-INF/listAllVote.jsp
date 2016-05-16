<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		欢迎<font color="green">${!empty
			sessionScope.user?user.username:"游客"}</font>光临
		<c:choose>
			<c:when test="${!empty sessionScope.user}">
				<a style="text-decoration: none"
					href="${pageContext.request.contextPath}/VoteServlet?method=exit">安全退出</a>
			</c:when>
		</c:choose>
		<hr/>
		<table border="1" align="center" width="60%">
			<caption>
				<h1>
					候选人基本信息
				</h1>
			</caption>
			<tr>
				<th>
					人名
				</th>
				<th>
					票数
				</th>
				<th>
					操作
				</th>
			</tr>
			<c:forEach var="vote" items="${requestScope.voteList}">
				<tr align="center">
					<td>
						<a style="text-decoration: none"
							href="${pageContext.request.contextPath}/VoteServlet?method=findVoteById&id=${vote.id}">
							${vote.content} </a>
					</td>
					<td>
						${vote.ticket}
					</td>
					<td>
						<c:if test="${!empty sessionScope.user}">
							<a href="#" style="text-decoration: none"> 投票 </a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td>
					<a style="text-decoration: none"
						href="${pageContext.request.contextPath}/VoteServlet?method=toLoginJsp">登录</a>
				</td>
			</tr>
		</table>
	</body>
</html>
