package persona;

public class Colega extends Persona {
	private String puesto;
	public Colega(String pNombre, String pApellido1,String pApellido2, String pTelefono, String pCorreo, String pPuesto,int pNumCarnet) {
		setCarnet(pNumCarnet);
		setNombre(pNombre);
	    setApellido1(pApellido1);
	    setApellido2(pApellido2);
	    setTelefono(pTelefono);
	    setCorreo(pCorreo);
	    setPuesto(pPuesto);
	}
	public void setPuesto(String puesto){
		this.puesto=puesto;
	}
	public String getPuesto(){
		return puesto;
	}
	public String toString() {
		  String msg;
		  msg="Numero de persona: "+getCarnet()+"\n";
		  msg+="Nombre: "+getNombre()+"\n";
		  msg+="Primer Apellido: "+getApellido1()+"\n";
		  msg+="Segundo Apellido: "+getApellido2()+"\n";
		  msg+="Teléfono: "+getTelefono()+"\n";
		  msg+="Correo: "+getCorreo();
		  msg+="Puesto: "+getPuesto();
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
		  msg+=getPuesto();
		  return msg;
	  }
}
