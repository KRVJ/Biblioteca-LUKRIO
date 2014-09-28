package articulo;

import javax.swing.ImageIcon;

public class Libro extends Articulo{
	String editorial,edicion;
	int numeroLibro;
	//Constructor con los parametros para asignar los valores iniciales.
	public Libro(String lTitulo,String lAutor,String lEditorial, String lEdicion, ImageIcon lPortada,int lCalificacion,
			int numero,String lugar,boolean prestado,int ano,int mes,int dia, String lalerta){
		setPrestado(prestado);
		setTitulo(lTitulo);
		setAutorProductor(lAutor);
		setCalificacion(lCalificacion);
		setEditorial(lEditorial);
		setEdicion(lEdicion);
		setPortada(lPortada);
		setNumero(numero);
		setDireccion(lugar);
		creaBotones();
		super.fecha.setAno(ano);
		super.fecha.setMes(mes);
		super.fecha.setDia(dia);
		setAlerta(lalerta);
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
		msg="Titulo: "+getTitulo()+"\n"+"\n";
		msg+="Productor: "+getAutorProductor()+"\n"+"\n";
		msg+="Editorial: "+getEditorial()+"\n"+"\n";
		msg+="Edicióc: "+getEdicion()+"\n"+"\n";
		msg+="Calificación: "+getCalificacion();
		return msg;
	}
}
