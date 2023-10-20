package com.excelr.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	JavaMailSender emailSender;
	
	public EmailService(JavaMailSender emailSender) {
		this.emailSender= emailSender;
	}
	 public void sendMessaeg(String to,String subject,String text) {
		 SimpleMailMessage mailMessage = new SimpleMailMessage();
		 mailMessage.setFrom("jocky0909@gmail.com");
		 mailMessage.setTo(to);
		 mailMessage.setSubject(subject);
		 mailMessage.setText(text);
		 this.emailSender.send(mailMessage);
	 }
	
}
