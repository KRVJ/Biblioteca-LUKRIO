package articulo;

import javax.swing.ImageIcon;

public class Libro extends Articulo{
	String editorial,edicion;
	int numeroLibro;
	//Constructor con los parametros para asignar los valores iniciales.
	public Libro(String lTitulo,String lAutor,String lEditorial, String lEdicion, ImageIcon lPortada,int lCalificacion){
		setTitulo(lTitulo);
		setAutorProductor(lAutor);
		setCalificacion(lCalificacion);
		setEditorial(lEditorial);
		setEdicion(lEdicion);
		setPortada(lPortada);
		creaBotones();
		setTipo("libro");
	}
	//Setters and getters de la clase libro para obtener y asignar los valores correspondientes a la clase.
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
