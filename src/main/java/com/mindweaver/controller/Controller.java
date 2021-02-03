package com.mindweaver.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindweaver.mailsender.Request;
import com.mindweaver.mailsender.Response;
import com.mindweaver.mailsender.SendMailLink;
import com.mindweaver.query.QueryRequest;

@RestController
@RequestMapping("/api/web")
@CrossOrigin(origins = "*")
public class Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);


	@Autowired
	SendMailLink sendMailLink;


	@PostMapping("/contact")
	public ResponseEntity<Response> contactUs(@Valid @RequestBody Request request)
	{
		Response response = new Response();
		logger.info("<-------Request---------->" + request);
		
		try {
			sendMailLink.sendEmail(request.getEmail(), request.getMessage(), request.getSubject(), request.getName() , "assessment_login_template.html","Chatweaver Contact" );
			
			response.setMessage("Thankyou , We'll contact you soon!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			response.setMessage("Error occured , Try again later!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
		}
		
	}
	
	
	
	
	
	@PostMapping("/query")
	public ResponseEntity<Response> query(@Valid @RequestBody QueryRequest request)
	{
		Response response = new Response();
		logger.info("<-------Request---------->" + request);
		
		try {
			sendMailLink.sendEmail(request.getEmail(), request.getMessage(), "Chatweaver Query" , request.getEmail() , "query.html","Chatweaver Query");
			
			response.setMessage("Thankyou , We'll contact you soon!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			response.setMessage("Error occured , Try again later!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
		}
		
	}
	
	
	
	
	
	
	
	@PostMapping("/subscribe")
	public ResponseEntity<Response> subscribe(@Valid @RequestBody com.mindweaver.subscriber.Request request)
	{
		Response response = new Response();
		logger.info("<-------Request---------->" + request);
		
		try {
			sendMailLink.sendEmail(request.getEmail() , "subscribe.html");
			
			response.setMessage("Thankyou , We'll contact you soon!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			response.setMessage("Error occured , Try again later!");
			response.setSuccessful(true);
			
			return ResponseEntity.ok().body(response);
		}
		
	}
	
	
	
}
