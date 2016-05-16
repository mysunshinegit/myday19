<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  		<%--
  			用户名->Filter->welcome.jsp
  		 --%>
    	欢迎${!empty sessionScope.username?username:'游客'}光临
  </body>
</html>
