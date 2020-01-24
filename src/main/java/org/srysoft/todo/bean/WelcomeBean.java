package org.srysoft.todo.bean;

/**
 * 
 * @author SATYA
 *
 */
public class WelcomeBean {

	private String message;

	public WelcomeBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
