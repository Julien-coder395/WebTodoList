<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web to-dot list - LOGIN</title>
<link type="text/css" rel="stylesheet" href="css/login-page.css">
</head>
<body>
 <%@ include file ="welcomeMessage-logout.jsp" %>
 <form action="LoginServlet" method="post">
  <div class="container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" value="${ username }" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>

    <button type="submit">Login</button>
  </div>  
  <div>
  	<label>${ errorMessage }</label>
  </div>
</form> 

</body>
</html>