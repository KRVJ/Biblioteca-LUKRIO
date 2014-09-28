package codigo;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Autenticar extends Authenticator {
	String usuario;
	String contraseña;

	public Autenticar(String us, String cn) {
		super();
		usuario=us;
		contraseña=cn;
	}
	 
	public PasswordAuthentication getPasswordAuthentication(){
		
		if ((usuario != null) && (usuario.length() > 0) && (contraseña != null) && (contraseña.length () > 0)) { 
			return new PasswordAuthentication(usuario, contraseña); } 
		return null; }
	}


