package codigo;

import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator; 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication; 
import javax.mail.Session;
import javax.mail.Transport;

public class Mail {
	// atributos
	String remitente;
	String destinatario;
	String mensaje;
	String asunto;
	String servidor;
	String contraseña;
	Properties propiedades = System.getProperties();
	
   public void setMail(String usuario, String pDestinatario,String pMensaje,String pAsunto, String pContraseña){
    	// setea los atributos
    	  setRemitente(usuario);
    	  setDestinatario(pDestinatario);
    	  setMensaje(pMensaje);
    	  setAsunto(pAsunto);
    	  setContraseña(pContraseña);
    	  setServidor("smtp.gmail.com");
    	  // propiedades
    	 propiedades.put("mail.smtp.starttls.enable","true"); 
 	     propiedades.setProperty("mail.smtp.host", servidor);//modo de envio 
 	     propiedades.put("mail.smtp.port", 587);// puerto de red
 	     propiedades.put("mail.smtp.auth", "true");
 	     propiedades.put("mail.user", remitente); // configura quien envia el mensaje
	     propiedades.put("mail.password", contraseña);//configura la contraseña
	     Session sesion = Session.getDefaultInstance( propiedades, new Autenticar(remitente,contraseña));
	     try{
	    	 
	    	 MimeMessage mensaje =new MimeMessage(sesion);
	    	 mensaje.setFrom(new InternetAddress(remitente));
	    	 mensaje.addRecipient(Message.RecipientType.TO, 
	    	 new InternetAddress(destinatario));
	    	 mensaje.setSubject(getAsunto());
	    	 mensaje.setText(getMensaje());
	    	 Transport.send(mensaje);
	    	 System.out.println("mensaje enviado");
	    	 
	     }
	     catch(MessagingException e){
	    	 e.printStackTrace();
	     }
 	     
    	  
      }
    
    // setters y getters
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getServidor() {
		return servidor;
	}
	public void setServidor(String servidor) {
		this.servidor = servidor;
	}
	public Properties getPropiedades() {
		return propiedades;
	}
	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}