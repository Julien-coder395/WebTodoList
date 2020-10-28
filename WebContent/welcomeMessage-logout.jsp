<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link type="text/css" rel="stylesheet" href="css/welcomeMessage.css">

<header>
	<h1>ESVIL - Todo list</h1>
</header>


<p>
	<span class="welcomeMessage">
		<c:if test="${! empty sessionScope.user }">
			<label> Welcome ${ sessionScope.user.username }</label>
		</c:if>
		<c:if test="${ empty sessionScope.user }">
			<label> Welcome </label>
		</c:if>
	</span>
		<a href = "/WebTodoList/LoginServlet?logout=1">Logout</a>
</p>





