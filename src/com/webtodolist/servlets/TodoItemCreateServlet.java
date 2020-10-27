package com.webtodolist.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.webtodolist.beans.TodoItemBean;
import com.webtodolist.database.TodoItemDBUtil;


@WebServlet("/TodoItemCreateServlet")
public class TodoItemCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/webtodolistdb")
	private DataSource dataSource;
	
	private TodoItemDBUtil todoItemDBUtil;

	@Override
	public void init() throws ServletException {
		todoItemDBUtil = new TodoItemDBUtil(dataSource);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/create-todoitem.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		TodoItemBean newItem = new TodoItemBean();
		newItem.setDescription(description);
		todoItemDBUtil.createTodoItem(newItem);
		response.sendRedirect("/WebTodoList/TodoListStudentServlet");	
	}

}
