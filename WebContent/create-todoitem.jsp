<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create to-do item</title>
<link type="text/css" rel="stylesheet" href="css/edit-create.css">
</head>
<body>
<%@ include file ="welcomeMessage-logout.jsp" %>

<div class="conteneur "id="container">
	 <form action="TodoItemCreateServlet" method="post">
	 	<textarea name="description" rows="4" cols="40"></textarea>
	 	<input type="submit" value = "Save"/>
	 </form>
 </div>
</body>
</html>