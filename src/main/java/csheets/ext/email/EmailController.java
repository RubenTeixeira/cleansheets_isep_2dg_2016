/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author Rui Bastos
 */
public class EmailController {

	public Email configureEmail(String email, String password, String server) throws MessagingException, IOException {

		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", server); //smtp.live.com
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		// or use getDefaultInstance instance if desired...
		Session session = Session.
			getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(props.
						getProperty("mail.username"), props.
													  getProperty("mail.password"));
				}
			});

		Email mail = new Email(session);
		mail.connect(server, email, password);

		updateProperties(session.getProperties(), email, password);

		return mail;
	}

	public void sendEmail(Email email, String to,
						  String subject, String body) throws MessagingException {

		email.sendMessage(to, subject, body);
	}

	private void updateProperties(Properties props, String email,
								  String password) throws FileNotFoundException, IOException {
		props.put("mail.username", email);
		props.put("mail.password", password);
		File f = new File("mail.properties");
		OutputStream out = new FileOutputStream(f);
		props.store(out, "Email data");
	}

}