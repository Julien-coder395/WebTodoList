package com.webtodolist.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.webtodolist.beans.UserBean;
import com.webtodolist.database.UserDBUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;
      
	private UserDBUtil userDBUtil;
	
	@Resource(name="jdbc/webtodolistdb")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userDBUtil = new UserDBUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logout = request.getParameter("logout");
		if(logout != null && logout.equals("1")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", null);		
		}
		
		// Gestion du cookie lors de la connexion.
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().contentEquals("username"))
					request.setAttribute("username", cookie.getValue());
			}
		}
					
		request.getRequestDispatcher("login-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean user = null;
		String errorMessage = "";
		HttpSession session = request.getSession();
		
		try {
			user = userDBUtil.authenticate(username, password);
			if(user != null) {
				System.out.println("Authentification réussie");
				
				Cookie cookie = new Cookie("username", username);
				cookie.setMaxAge(60*60*24);
				response.addCookie(cookie);
				session.setAttribute("user", user);
				response.sendRedirect("/WebTodoList/TodoListStudentServlet");
			}
			else {
				System.out.println("Echec authentification");
				errorMessage = "Echec authentification";
				request.setAttribute("errorMessage", errorMessage);
				doGet(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}			
	}
}
