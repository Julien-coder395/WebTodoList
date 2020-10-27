<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.webtodolist.enums.EnumRole" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To-do list student version</title>
</head>
<body>
<%@ include file ="welcomeMessage-logout.jsp" %>
<div id="container">
<c:if test="${ sessionScope.user.role == EnumRole.INSTRUCTOR }">
	<div style="margin-top:10px">
	<form action="TodoItemCreateServlet" method="get">
		<input type="submit" value="Add To-do item"/>
	</form>	
</div>
</c:if>
	<div id="content">
		<table>
			<tr>
				<th>Description</th>
			</tr>
			
			<c:forEach var="tempItem" items="${ items }">	
								
					<c:url var="EditLink" value="TodoItemEditServlet">
					<c:param name="todoItemId" value="${ tempItem.id }"/>				
					</c:url>
					
					<c:url var="DeleteLink" value="TodoItemDeleteServlet">
					<c:param name="todoItemId" value="${ tempItem.id }"/>
					</c:url>
											
				<tr>
					<td> ${tempItem.description}</td>
					<c:if test="${ sessionScope.user.role == EnumRole.INSTRUCTOR }">
						<td> <a href="${ EditLink }">Edit | </a> 
								 <a href="${ DeleteLink }"> Delete</a></td>	
					</c:if>			
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>