package com.everis.notificaciones.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class CorreoService {
	
	static boolean isValid(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	   }
	
	public boolean enviarCorreo(String email, String asunto, String texto) {
		// TODO Auto-generated method stub
		
		boolean exitoCorreo;
		if(isValid(email)) {
			String remitente = "academiaeveris";
			
			Properties props = System.getProperties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.user", remitente);
		    props.put("mail.smtp.clave", "tecguru$");   
		    props.put("mail.smtp.auth", "true"); 
		    props.put("mail.smtp.starttls.enable", "true");
		    props.put("mail.smtp.port", "587");
		    
		    Session session = Session.getDefaultInstance(props);
		    MimeMessage message = new MimeMessage(session);
		    
		   exitoCorreo = true;
		    
		    try {
		        message.setFrom(new InternetAddress(remitente));
		        message.addRecipients(Message.RecipientType.TO, email);   
		        message.setSubject(asunto);
		        message.setText(texto);
		        Transport transport = session.getTransport("smtp");
		        transport.connect("smtp.gmail.com", remitente, "tecguru$");
		        transport.sendMessage(message, message.getAllRecipients());
		        transport.close();
		    }
		    catch (MessagingException me) {
		        me.printStackTrace();
		    }
		}
		else{
			exitoCorreo=false;
		}
		return exitoCorreo;
		
		
	}

}
