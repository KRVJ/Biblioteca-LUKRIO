package articulo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Revista extends Articulo{
	String editorial,edicion;
	int numeroRevista;
	public Revista(String rTitulo,String rAutor,String rEditorial, String rEdicion, ImageIcon rPortada,int rCalificacion,
			int numero,String lugar,boolean prestado,int ano,int mes,int dia, String lalerta,int carnet,String tipoPersona){
		setPrestado(prestado);
		setTitulo(rTitulo);
		setAutorProductor(rAutor);
		setCalificacion(rCalificacion);
		setEditorial(rEditorial);
		setEdicion(rEdicion);
		setPortada(rPortada);
		setNumero(numero);
		creaBotones();
		setTipoPersona(tipoPersona);
		super.fecha.setAno(ano);
		super.fecha.setMes(mes);
		super.fecha.setDia(dia);
		setNumero(carnet);
		setDireccion(lugar);
		setAlerta(lalerta);
		setTipo("revista");
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
