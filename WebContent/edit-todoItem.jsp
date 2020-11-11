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
 <form action="TodoItemEditServlet" method="post" class="Todo">
 	<div class="ToDo">
	 		<label for="descrip">ToDo description:</label>
	 		<textarea class = "description" name="description" rows="2" cols="40" required >${ todoItem.description }</textarea>
	 	</div>
	 	<div class="ToDo">
	 		<label for="bluelink">ToDo drop link:</label>
	 		<input type="text" class = "link" name="link" value="${ todoItem.link }"> 
	 	</div>
	 	<div class="ToDo">
	 		<label for="date">Deadline : </label>
	 		<input type="date" class = "deadline" name="deadline" value="${ todoItem.deadline }"/> 
	 	</div>
	 	<div class="ToDo">
	 	<input class="validation" type="submit" value = "Save"/>
	 	</div>
 </form>
 </div>
 
</body>
</html>