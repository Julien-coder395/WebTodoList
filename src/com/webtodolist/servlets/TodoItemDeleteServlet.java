package com.webtodolist.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.webtodolist.database.TodoItemDBUtil;

@WebServlet("/TodoItemDeleteServlet")
public class TodoItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TodoItemDBUtil todoItemDBUtil;
	
	@Resource(name="jdbc/webtodolistdb")
	private DataSource dataSource;
	
	int id;
	
	@Override
	public void init() throws ServletException {
		super.init();
		todoItemDBUtil = new TodoItemDBUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("todoItemId"));
		todoItemDBUtil.deleteTodoItem(id);
		response.sendRedirect("/WebTodoList/TodoListStudentServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
