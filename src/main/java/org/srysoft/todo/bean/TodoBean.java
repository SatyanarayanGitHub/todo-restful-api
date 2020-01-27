package org.srysoft.todo.bean;

import java.util.Date;

import org.srysoft.todo.entity.TodoEntity;

public class TodoBean {

	private long id;
	private String username;
	private String descritpion;

	private Date targetDate;
	private boolean isDone;

	public TodoBean(long id, String username, String descritpion, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		this.username = username;
		this.descritpion = descritpion;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public TodoBean(TodoEntity entity) {

		this.id = entity.getId();
		this.username = entity.getUserName();
		this.descritpion = entity.getDescription();
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

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
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

}
