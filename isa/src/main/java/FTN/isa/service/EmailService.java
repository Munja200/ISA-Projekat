package FTN.isa.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;


	@Async
	public void sendNotificaitionAsync(RegisteredUser user,String siteURL) throws MailException, InterruptedException, UnsupportedEncodingException, MessagingException {
		String toAddress = user.getPerson().getEmail();
		String fromAddress = env.getProperty("spring.mail.username");
		String senderName = "Blood Bank";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>"
				+ "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
				+ "Thank you,<br>"
				+ "Your company name.";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		
		content = content.replace("[[name]]", user.getPerson().getName());
		String verifyURL = "http://localhost:4200/login/verify/" + user.getVerificationCode();
		
		content = content.replace("[[URL]]", verifyURL);
		
		helper.setText(content, true);
		
		mailSender.send(message);
		
		System.out.println("Email has been sent");
	}
	
	@Async
	public void sendMessage(Person user) throws MailException, InterruptedException, UnsupportedEncodingException, MessagingException {
		String toAddress = user.getEmail();
		String fromAddress = env.getProperty("spring.mail.username");
		String senderName = "Blood Bank";
		String subject = "Termin za davanje krvi";
		String content = "Postovani [[name]],<br>"
				+ "Uspesno ste zakazali termin za davanje krvi:<br>"
				+ "Hvala Vam ,<br>"
				+ "Vasa kompanija.";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);
		
		content = content.replace("[[name]]", user.getName());
		
		helper.setText(content, true);
		
		mailSender.send(message);
		
		System.out.println("Email has been sent");
	}

	
	
	
	
}
