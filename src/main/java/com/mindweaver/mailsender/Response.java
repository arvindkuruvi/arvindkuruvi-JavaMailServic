package com.mindweaver.mailsender;

public class Response {
	
	private boolean  successful =  true;
	
	private String message;

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Response [successful=" + successful + ", message=" + message + "]";
	}
	
}
