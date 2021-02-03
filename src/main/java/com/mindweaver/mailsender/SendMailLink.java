package com.mindweaver.mailsender;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.mindweaver.mailsenderutil.MailSenderUtil;
import com.mindweaver.util.Commonutil;

import freemarker.template.Configuration;
import freemarker.template.Template;






@Description("service to email sender service using java - mail API")
@Service
public class SendMailLink {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendMailLink.class);

	@Autowired
	private Configuration freeMakerConfig;

	public void sendEmail(String toEmail, String note, String subject , String name, String templateName ,String type) {
		try {

			Template invitationTemplate = freeMakerConfig.getTemplate(templateName);
			Map<String, String> model = new HashMap<>(0);
			model.put("note", note);
			model.put("email", toEmail);
			model.put("userName", name);
			model.put("subject", subject);


			String emailVerification = FreeMarkerTemplateUtils.processTemplateIntoString(invitationTemplate, model);

			MailSenderUtil mailSenderUtil = new MailSenderUtil(Commonutil.FROM_EMAIL_ID, 
					Commonutil.PASSWORD, Commonutil.FROM_EMAIL_ID, type,  emailVerification);

			
			
			Thread thread = new Thread(mailSenderUtil);
			thread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.info(ex.getMessage());
		}
	}
	
	
	public void sendEmail(String toEmail , String templateName) {
		try {

			Template invitationTemplate = freeMakerConfig.getTemplate(templateName);
			Map<String, String> model = new HashMap<>(0);
			
			model.put("email", toEmail);
			

			String emailVerification = FreeMarkerTemplateUtils.processTemplateIntoString(invitationTemplate, model);

			MailSenderUtil mailSenderUtil = new MailSenderUtil(Commonutil.FROM_EMAIL_ID, 
					Commonutil.PASSWORD, Commonutil.FROM_EMAIL_ID, "Chatweaver Subscribe" ,  emailVerification);

			
			Thread thread = new Thread(mailSenderUtil);
			thread.start();
		} catch (Exception ex) {
			ex.printStackTrace();
			LOGGER.info(ex.getMessage());
		}
	}

}
