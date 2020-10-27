package com.webtodolist.database;

import com.webtodolist.beans.UserBean;
import com.webtodolist.enums.EnumRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class UserDBUtil extends DBUtilBase{

	public UserDBUtil(DataSource dataSource) {
		super(dataSource);
		
	}
	
	public List<UserBean> getUsers() throws Exception{
		List<UserBean> users = new ArrayList<UserBean>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			String sql = "SELECT * FROM user ORDER BY username";
			myRs = myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				int id = myRs.getInt("id");
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				EnumRole role = EnumRole.fromInteger(myRs.getInt("role"));
				
				UserBean tempUser = new UserBean(id, username, password, role);
				users.add(tempUser);
			}
			return users;
		}
		finally {
			super.close(myConn, myStmt, myRs);
		}
	}
		
	public UserBean authenticate(String username, String password) throws Exception{ 		
		UserBean user = null;
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "SELECT * FROM user WHERE username = ? and password = ?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myRs = myStmt.executeQuery();
			while(myRs.next()) {
				user = new UserBean(myRs.getInt("id"), myRs.getString("username"), myRs.getString("password"),
						EnumRole.fromInteger(myRs.getInt("role")));
			}
			return user;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		finally {
			super.close(myConn, myStmt, myRs);
		}
	}
		
	public UserBean authenticate2(String username, String password) throws Exception{ 		
		UserBean result = null;
		List<UserBean> users = getUsers();
		
		for(UserBean user : users) {
			if(user.getUsername().equals(username)) {
				if(user.getPassword().equals(password)) {
					result = user;
				}
			}
		}
		return result;
	}
}
