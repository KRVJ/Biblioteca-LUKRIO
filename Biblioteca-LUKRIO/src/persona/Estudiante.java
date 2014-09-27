package persona;

public class Estudiante extends Persona {
	private String institucion;
	//Constructor con los valores correspondientes para iniciar la clase Estudiante.
	public Estudiante(String pNombre, String pApellido1,String pApellido2, String pTelefono, String pCorreo, String pInstitucion,int pNumCarnet){
		setCarnet(pNumCarnet);
		setNombre(pNombre);
	    setApellido1(pApellido1);
	    setApellido2(pApellido2);
	    setTelefono(pTelefono);
	    setCorreo(pCorreo);
	    setInstitucion(pInstitucion);
	    setTipo("estudiante");
	}
	public void setInstitucion(String institucion){
		this.institucion=institucion;
	}
	public String getInstitucion(){
		return institucion;
	}
	public String toString() {
		  String msg;
		  msg="Numero de persona: "+getCarnet()+"\n";
		  msg+="Nombre: "+getNombre()+"\n";
		  msg+="Primer Apellido: "+getApellido1()+"\n";
		  msg+="Segundo Apellido: "+getApellido2()+"\n";
		  msg+="Teléfono: "+getTelefono()+"\n";
		  msg+="Correo: "+getCorreo()+"/n";
		  msg+="Institución: "+getInstitucion();
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
		  msg+=getInstitucion();
		  return msg;
	  }
}
