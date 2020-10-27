package com.webtodolist.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.webtodolist.beans.TodoItemBean;
import com.webtodolist.database.TodoItemDBUtil;




@WebServlet("/TodoListStudentServlet")
public class TodoListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TodoItemDBUtil todoItemDBUtil;
	
	@Resource(name="jdbc/webtodolistdb")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		todoItemDBUtil = new TodoItemDBUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<TodoItemBean> items = todoItemDBUtil.getTodoItems();
			request.setAttribute("items", items);
			TodoItemBean test = items.get(1);
			System.out.println(test.getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("todoList-studentVersion.jsp").forward(request,  response);			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
