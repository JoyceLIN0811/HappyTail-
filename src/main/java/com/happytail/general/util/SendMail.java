package com.happytail.general.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class SendMail {
	private String username = "scott";
	private String password = "tiger";
	private String contentType = "text/html;charset=UTF-8";
	private String email;
	private String subject;
	private String mailContent;
	private String hideEmail;

	public void sendMail() throws MessagingException {
		try {
			if (subject == null) {
				throw new Exception("subject cannot null");
			} else if (email == null && hideEmail == null) {
				throw new Exception("hideEmail and mail cannot both null");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("====sending email====");

		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.starttls.enable", "true"); // TLS
		Session mailSession = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Transport transport = mailSession.getTransport();

		MimeMessage message = new MimeMessage(mailSession);
		message.setSubject(subject);
		message.setContent(mailContent, contentType);
		if (email != null) {
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		}
		if (hideEmail != null) {
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(hideEmail));
		}

		transport.connect();
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public void setHideEmail(String hideEmail) {
		this.hideEmail = hideEmail;
	}
}
