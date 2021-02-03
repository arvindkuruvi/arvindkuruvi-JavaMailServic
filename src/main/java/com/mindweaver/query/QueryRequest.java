package com.mindweaver.query;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class QueryRequest {


	
	
	@NotNull(message = "email can't be null")
	@NotEmpty(message = "email can't be empty")
	private String email;
	
	
	
	@NotNull(message = "message can't be null")
	@NotEmpty(message = "message can't be empty")
	private String message;

	public QueryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Request [email=" + email + " , message=" + message + "]";
	}
	
}
