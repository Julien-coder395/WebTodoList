package com.webtodolist.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.webtodolist.beans.TodoItemBean;

public class TodoItemDBUtil extends DBUtilBase {

	public TodoItemDBUtil(DataSource dataSource) {
		super(dataSource);
	}
	
	public List<TodoItemBean> getTodoItems() throws Exception {
		List<TodoItemBean> items = new ArrayList<TodoItemBean>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
			
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql = "SELECT * FROM webtodolistdb.todoitem ORDER BY id";
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String description = myRs.getString("description");
				
				TodoItemBean item = new TodoItemBean(id, description);
				items.add(item);
			}
			return items;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}
	
	public void deleteTodoItem(int id) {
		super.deleteById(id, "todoitem");
	}
	
	public TodoItemBean fetchTodoItem(int id) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		TodoItemBean item = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM todoitem WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myRs = myStmt.executeQuery();
			
			while(myRs.next()) {	
				item = new TodoItemBean(id, myRs.getString("description"));
			}
			return item;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		finally {
			close(myConn, myStmt, myRs);
		}
	}
	
	public void updateTodoItem(TodoItemBean item) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "UPDATE todoitem SET description=? where id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, item.getDescription());
			myStmt.setInt(2, item.getId());
			myStmt.execute();		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn, myStmt, null);
		}		
	}
	
	public void createTodoItem(TodoItemBean item) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.prepareStatement("INSERT INTO todoitem (description) VALUES(?);");
			myStmt.setString(1, item.getDescription());
			myStmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(myConn, myStmt, null);
		}
	}
}
