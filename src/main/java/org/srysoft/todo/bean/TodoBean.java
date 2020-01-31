package org.srysoft.todo.bean;

import java.util.Date;

import org.srysoft.todo.entity.TodoEntity;

public class TodoBean {

	private long id;
	private String username;
	private String description;

	private Date targetDate;
	private boolean isDone;

	public TodoBean(long id, String username, String description, Date targetDate, boolean isDone) {
		//super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public TodoBean(TodoEntity entity) {
		this.id = entity.getId();
		this.username = entity.getUserName();
		this.description = entity.getDescription();
		this.targetDate = entity.getTargetDate();
		this.isDone = entity.isDone();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descritpion) {
		this.description = descritpion;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "TodoBean [id=" + id + ", username=" + username + ", description=" + description + ", targetDate="
				+ targetDate + ", isDone=" + isDone + "]";
	}
	
	

}
