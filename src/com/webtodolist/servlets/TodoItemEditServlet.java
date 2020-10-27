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

@WebServlet("/TodoItemEditServlet")
public class TodoItemEditServlet extends HttpServlet {
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
		TodoItemBean todoItem = todoItemDBUtil.fetchTodoItem(id);
		//System.out.println(todoItem.getDescription());
		request.setAttribute("todoItem", todoItem);
		//response.sendRedirect("/WebTodoList/TodoListStudentServlet");
		request.getRequestDispatcher("edit-todoItem.jsp").forward(request,  response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		System.out.println(description);
		TodoItemBean newItem = new TodoItemBean(id, description);
		todoItemDBUtil.updateTodoItem(newItem);
		response.sendRedirect("/WebTodoList/TodoListStudentServlet");
	}

}
