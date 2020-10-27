package com.webtodolist.beans;

public class TodoItemBean extends BeanBase {

	private String description;
	
	public TodoItemBean() {
	}
	
	public TodoItemBean(int id, String description) {
		super(id);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
