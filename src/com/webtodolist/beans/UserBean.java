package com.webtodolist.beans;

import com.webtodolist.enums.EnumRole;

public class UserBean extends BeanBase {

	private String username;
	private String password;
	private EnumRole role;
		
	public UserBean() {
		
	}
	
	public UserBean(String username, String password, EnumRole role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserBean(int id, String username, String password, EnumRole role) {
		super(id);
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EnumRole getRole() {
		return role;
	}

	public void setRole(EnumRole role) {
		this.role = role;
	}
}
