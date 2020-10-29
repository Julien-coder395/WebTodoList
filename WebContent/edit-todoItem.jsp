<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit To-do item</title>
<link type="text/css" rel="stylesheet" href="css/edit-create.css">
</head>
<body>
 <%@ include file ="welcomeMessage-logout.jsp" %>
 
 <div class="conteneur "id="container">
 <form action="TodoItemEditServlet" method="post">
 	<textarea name="description" rows="4" cols="40">${ todoItem.description }</textarea>
 	<input type="submit" value = "Save"/>
 </form>
 </div>
 
</body>
</html>