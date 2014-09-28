package articulo;

import javax.swing.ImageIcon;

public class Pelicula extends Articulo{
	String editorial,edicion;
	int numeroLibro;
	public Pelicula(String lTitulo,String lAutor,String lEditorial, String lEdicion, ImageIcon lPortada,int lCalificacion,
			int numero,String lugar,boolean prestado,int ano,int mes,int dia, String lalerta,int carnet,String tipoPersona){
		setPrestado(prestado);
		setTitulo(lTitulo);
		setAutorProductor(lAutor);
		setCalificacion(lCalificacion);
		setEditorial(lEditorial);
		setEdicion(lEdicion);
		setPortada(lPortada);
		setNumero(numero);
		creaBotones();
		setTipoPersona(tipoPersona);
		super.fecha.setAno(ano);
		super.fecha.setMes(mes);
		super.fecha.setDia(dia);
		setNumero(carnet);
		setDireccion(lugar);
		setAlerta(lalerta);
		setTipo("pelicula");
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
		msg="Titulo: "+getTitulo()+"\n"+"\n";
		msg+="Productor: "+getAutorProductor()+"\n"+"\n";
		msg+="Editorial: "+getEditorial()+"\n"+"\n";
		msg+="Edicióc: "+getEdicion()+"\n"+"\n";
		msg+="Calificación: "+getCalificacion();
		return msg;
	}
}
