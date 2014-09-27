package persona;

public class Familiar extends Persona {
	public String parentesco;
	public Familiar(String pNombre, String pApellido1,String pApellido2, String pTelefono, String pCorreo, String pParentesco, int pNumCarnet){
		setCarnet(pNumCarnet);
		setNombre(pNombre);
	    setApellido1(pApellido1);
	    setApellido2(pApellido2);
	    setTelefono(pTelefono);
	    setCorreo(pCorreo);
	    setParentesco(pParentesco);
	    setTipo("familiar");
	}
	public void setParentesco(String parentesco){
		this.parentesco=parentesco;
	}
	public String getParentesco(){
		return parentesco;
	}
	public String toString() {
		  String msg;
		  msg="Numero de persona: "+getCarnet()+"\n";
		  msg+="Nombre: "+getNombre()+"\n";
		  msg+="Primer Apellido: "+getApellido1()+"\n";
		  msg+="Segundo Apellido: "+getApellido2()+"\n";
		  msg+="Teléfono: "+getTelefono()+"\n";
		  msg+="Correo: "+getCorreo();
		  msg+="Parentesco: "+getParentesco();
		  return msg;
	  }
	public String consulta() {
		  String msg;
		  String espacio="             ";
		  msg=getCarnet()+espacio;
		  msg+=getNombre()+espacio;
		  msg+=getApellido1()+espacio;
		  msg+=getApellido2()+espacio;
		  msg+=getTelefono()+espacio;
		  msg+=getCorreo()+espacio;
		  msg+=getParentesco();
		  return msg;
	  }
}
