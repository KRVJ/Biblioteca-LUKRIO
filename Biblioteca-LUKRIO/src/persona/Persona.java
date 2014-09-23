package persona;

public class Persona{
  private int numeroCarnet=0;
  private String nombre;
  private String apellido1;
  private String apellido2;
  private String telefono;
  private String correo;
  public Persona (){
  	}
  //Setters y getters que comparten las subClases que heredan de Persona.
  public void setCarnet(int numeroCarnet){
	  this.numeroCarnet=numeroCarnet;
  }
  public void setNombre(String nombre){
	  this.nombre=nombre;
  }
  public void setApellido1(String apellido1){
	  this.apellido1=apellido1;
  }
  public void setApellido2(String apellido2){
	  this.apellido2=apellido2;
  }
  public void setTelefono(String telefono){
	  this.telefono=telefono;
  }
  public void setCorreo(String correo){
	  this.correo=correo;
  }
  public int getCarnet(){
	  return numeroCarnet;
  }
  public String getNombre(){
	  return nombre;
  }
  public String getApellido1(){
	  return apellido1;
  }
  public String getApellido2(){
	  return apellido2;
  }
  public String getTelefono(){
	  return telefono;
  }
  public String getCorreo(){
	  return correo;
  }
  public String toString() {
	  String msg;
	  msg="Numero de persona: "+getCarnet()+"\n";
	  msg+="Nombre: "+getNombre()+"\n";
	  msg+="Primer Apellido: "+getApellido1()+"\n";
	  msg+="Segundo Apellido: "+getApellido2()+"\n";
	  msg+="Teléfono: "+getTelefono()+"\n";
	  msg+="Correo: "+getCorreo();
	  return msg;
  }
}