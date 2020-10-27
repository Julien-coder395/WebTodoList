package com.webtodolist.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class DBUtilBase {

	protected DataSource dataSource;
		
	public DBUtilBase(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myStmt != null)
				myStmt.close();
			if(myRs != null)
				myRs.close();
			if(myConn != null)
				myConn.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected void deleteById(int id, String nameOfTable) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			myConn = dataSource.getConnection();
			String sql = "DELETE FROM " + nameOfTable + " " + "WHERE id=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setInt(1, id);
			myStmt.execute();		
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			close(myConn, myStmt, null);
		}		
	}
}
