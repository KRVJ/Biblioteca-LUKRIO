package articulo;

import javax.swing.ImageIcon;

public class Articulo{
	String titulo,autorProductor;
	ImageIcon portada;
	static boolean estaPrestado1;
	int calificacion;
	static String personaPrestada1;
	static int carnetPersona1;
	String tipo;
	Articulo(){
	}
	//Setters y getters que comparten las subClases que heredan de Artículo.
	public void setPersonaPrestado(String personaPrestada,int carnetPersona){
		personaPrestada1=personaPrestada;
		carnetPersona1=carnetPersona;
		System.out.println("Libro prestado al tipo: "+personaPrestada1+" Carnet: "+carnetPersona1);
	}
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getTipo(){
		return tipo;
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	public void setAutorProductor(String autorProductor){
		this.autorProductor=autorProductor;
	}
	public void setCalificacion(int calificacion){
		this.calificacion=calificacion;
	}
	public void setPortada(ImageIcon portada){
		this.portada=portada;
	}
	public String getTitulo(){
		return titulo;
	}
	public String getAutorProductor(){
		return autorProductor;
	}
	public ImageIcon getPortada(){
		return portada;
	}
	public int getCalificacion(){
		return calificacion;
	}
	public void setPrestado(boolean estaPrestado){
		estaPrestado1=estaPrestado;
	}
	public boolean getPrestado(){
		return estaPrestado1;
	}
}
