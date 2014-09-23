package articulo;

import javax.swing.ImageIcon;

public class Revista extends Articulo{
	String editorial,edicion;
	int numeroRevista;
	public Revista(String rTitulo,String rAutor,String rEditorial, String rEdicion, ImageIcon rPortada,int rCalificacion, int rNumero){
		setTitulo(rTitulo);
		setAutorProductor(rAutor);
		setCalificacion(rCalificacion);
		setEditorial(rEditorial);
		setEdicion(rEdicion);
		setPortada(rPortada);
		setRevistaNumero(rNumero);
		setPrestado(false);
	}
	public void setRevistaNumero(int numeroRevista){
		this.numeroRevista=numeroRevista;
	}
	public int getNumeroRevista(){
		return numeroRevista;
	}
	public void setEditorial(String editorial){
		this.editorial=editorial;
	}
	public void setEdicion(String edicion){
		this.edicion=edicion;
	}
	public String getEditorial(){
		return editorial;
	}
	public String getEdicion(){
		return edicion;
	}
	public String toString(){
		String msg;
		msg=getTitulo()+"/n";
		msg+=getAutorProductor()+"/n";
		msg+=getEditorial()+"/n";
		msg+=getEdicion();
		msg+=getCalificacion();
		return msg;
	}
}