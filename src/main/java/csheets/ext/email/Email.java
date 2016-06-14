/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.email;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Rui Bastos
 */
public class Email {

	private Session session;

	public Email(Session session) {
		this.session = session;
	}

	public Session session() {
		return this.session;
	}

	public void connect(String server, String email, String password) throws NoSuchProviderException, MessagingException, FileNotFoundException, IOException {
		Transport transport = session.getTransport("smtp");
		int port = 587;
		transport.connect(server, port, email, password);
		transport.close();
	}

	public void sendMessage(String to,
							String subject, String body) throws MessagingException {
		session.setDebug(true);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(this.session.getProperties().
			getProperty("mail.username"))); //Remetente
		message.setRecipients(Message.RecipientType.TO,
							  InternetAddress.
							  parse(to)); //Destinatário(s)
		message.setSubject(subject);//Assunto
		message.
			setText(body);
		/**
		 * Método para enviar a mensagem criada
		 */
		Transport.send(message);
	}

}
