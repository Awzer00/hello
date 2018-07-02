<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="role">
		<ul>
			<li id="code">编号</li>
			<li id="name">姓名</li>
			<li id="logID">登录号</li>
			<li id="power">权限</li>
		</ul>
		
		<c:forEach items="${role }" var="r" >
			<ul id="roleInfo">
				<li id="code">${r.id }</li>
				<li id="name">${r.roleName }</li>
				<li id="logID">${r.logId }</li>
				<li id="power">${r.rlimit }</li>
		    </ul>
		</c:forEach><br/>
			
		<c:choose>
			<c:when test="${showPage-1 eq 0}">
				<a href="showPowerServlet?showPage=1">上一页</a>
			</c:when>
			<c:otherwise>
				<a href="showPowerServlet?showPage=${showPage-1 }">上一页</a>
			</c:otherwise>
		</c:choose>
		
		<c:forEach items="${page }" var="page">
			<a href="showPowerServlet?showPage=${page }">${page }</a>
		</c:forEach>
		
		<c:choose>
			<c:when test="${showPage eq maxPage }">
				<a href="showPowerServlet?showPage=${maxPage }">下一页</a>
			</c:when>
			<c:otherwise>
				<a href="showPowerServlet?showPage=${showPage+1 }">下一页</a>
			</c:otherwise>
		</c:choose>
	</div>	
</body>
</html>