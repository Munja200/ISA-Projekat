package FTN.isa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private Environment env;

	@Async
	public void sendNotificaitionAsync(RegisteredUser user,String siteURL) throws MailException, InterruptedException {
		String s = siteURL+"/api/persons/verify?code="+user.getVerificationCode();
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getPerson().getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Potvrda registracije na IsaApp");
		mail.setText("Dear " +user.getPerson().getName()+",<br>"
	            + "Please click the link below to verify your registration:"
	            +"   " +s+"  "
	            + "Thank you,<br>"
	            + "Your company name.");
		
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}



}
