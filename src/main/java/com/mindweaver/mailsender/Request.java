package com.mindweaver.mailsender;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Request {

	@NotNull(message = "name can't be null")
	@NotEmpty(message = "name can't be empty")
	private String name;
	
	
	@NotNull(message = "email can't be null")
	@NotEmpty(message = "email can't be empty")
	private String email;
	
	
	@NotNull(message = "subject can't be null")
	@NotEmpty(message = "subject can't be empty")
	private String subject;
	
	@NotNull(message = "message can't be null")
	@NotEmpty(message = "message can't be empty")
	private String message;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Request [name=" + name + ", email=" + email + ", subject=" + subject + ", message=" + message + "]";
	}
	
}
