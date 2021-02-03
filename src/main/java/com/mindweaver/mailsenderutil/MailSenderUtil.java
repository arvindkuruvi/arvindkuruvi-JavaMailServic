package com.mindweaver.mailsenderutil;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.mindweaver.util.Commonutil;

public class MailSenderUtil implements Runnable {

	@Autowired
	Configuration config;

	private static final Logger LOGGER = LoggerFactory.getLogger(MailSenderUtil.class);

	String FROM_MAIL;
	String PASSWORD;
	String TO_MAIL;
	String subject;
	String messageBody;
	String emailTemplate;

	public MailSenderUtil(String FROM_MAIL, String PASSWORD, String TO_MAIL, String subject, String emailTemplate) {
		this.FROM_MAIL = FROM_MAIL;
		this.PASSWORD = PASSWORD;
		this.TO_MAIL = TO_MAIL;
		this.subject = subject;
		this.emailTemplate = emailTemplate;
	}

	@Override
	public void run() {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.debug", "true");
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Commonutil.FROM_EMAIL_ID, Commonutil.PASSWORD);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM_MAIL));

			// set TOs (i.e., recipients)
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(TO_MAIL));// to@gmail.com

			// set subject
			message.setSubject(this.subject);

			message.setContent(emailTemplate, "text/html");
			// send mail
			Transport.send(message);
		} catch (Exception ex) {
			LOGGER.debug("exception during sending email" + ex.getMessage());
			ex.printStackTrace();
		}
	}

}