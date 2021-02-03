package com.mindweaver.subscriber;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class Request {

	
	@NotNull(message = "email can't be null")
	@NotEmpty(message = "email can't be empty")
	private String email;
	


	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Request [email=" + email + "]";
	}

	
}
