package articulo;

import javax.swing.ImageIcon;

public class Pelicula extends Articulo{
	String editorial,edicion;
	int numeroLibro;
	public Pelicula(String lTitulo,String lAutor,String lEditorial, String lEdicion, ImageIcon lPortada,int lCalificacion,int lNumero){
		setTitulo(lTitulo);
		setAutorProductor(lAutor);
		setCalificacion(lCalificacion);
		setEditorial(lEditorial);
		setEdicion(lEdicion);
		setPortada(lPortada);
		setPrestado(false);
		setNumeroLibro(lNumero);
	}
	public void setNumeroLibro(int numeroLibro){
		this.numeroLibro=numeroLibro;
	}
	public int getNumeroLibro(){
		return numeroLibro;
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
