package com.webtodolist.beans;

public class TodoItemBean extends BeanBase {

	private String description;
	private String link;
	private String deadline;
	
	public TodoItemBean() {
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public TodoItemBean(int id, String description, String link, String deadline) {
		super(id);
		this.description = description;
		this.link = link;
		this.deadline = deadline;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
