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
	 <form action="TodoItemCreateServlet" method="post" class="Todo">
	 	<div class="ToDo">
	 		<label for="descrip">ToDo description:</label>
	 		<textarea class = "description" name="description" rows="2" cols="40" required ></textarea>
	 	</div>
	 	<div class="ToDo">
	 		<label for="bluelink">ToDo drop link:</label>
	 		<input type="text" class = "link" name="link" > 
	 	</div>
	 	<div class="ToDo">
	 		<label for="bluelink">Deadline : </label>
	 		<input type="date" class = "deadline" name="deadline" value = "2020-01-01" > 
	 	</div>
	 	<div class="ToDo">
	 	<input class="validation" type="submit" value = "Save"/>
	 	</div>
	 </form>
 </div>
</body>
</html>