package articulo;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Revista extends Articulo{
	String seccion,tipoRevista;
	int numeroRevista;
	public Revista(String rTitulo,String rAutor,String rSeccion, String rTipo, ImageIcon rPortada,int rCalificacion,
			int numero,String lugar,boolean prestado,int ano,int mes,int dia, String lalerta,int carnet,String tipoPersona){
		setPrestado(prestado);
		setTitulo(rTitulo);
		setAutorProductor(rAutor);
		setCalificacion(rCalificacion);
		setSeccion(rSeccion);
		setTipoRevista(rTipo);
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
	public void setSeccion(String seccion){
		this.seccion=seccion;
	}
	public void setTipoRevista(String tipo){
		this.tipoRevista=tipoRevista;
	}
	public String getSeccion(){
		return seccion;
	}
	public String getTipoRevista(){
		return tipoRevista;
	}
	public String toString(){
		String msg;
		msg="Titulo: "+getTitulo()+"\n"+"\n";
		msg+="Productor: "+getAutorProductor()+"\n"+"\n";
		msg+="Sección: "+getSeccion()+"\n"+"\n";
		msg+="Tipo: "+getTipoRevista()+"\n"+"\n";
		msg+="Calificación: "+getCalificacion();
		return msg;
	}
}
