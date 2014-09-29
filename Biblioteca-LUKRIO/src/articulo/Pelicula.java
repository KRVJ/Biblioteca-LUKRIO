package articulo;

import javax.swing.ImageIcon;

public class Pelicula extends Articulo{
	String genero,categoria;
	int numeroLibro;
	public Pelicula(String pTitulo,String pAutor,String pGenero, String pCategoria, ImageIcon pPortada,int pCalificacion,
			int numero,String lugar,boolean prestado,int ano,int mes,int dia, String pAlerta,int carnet,String tipoPersona){
		setPrestado(prestado);
		setTitulo(pTitulo);
		setAutorProductor(pAutor);
		setCalificacion(pCalificacion);
		setGenero(pGenero);
		setCategoria(pCategoria);
		setPortada(pPortada);
		setNumero(numero);
		creaBotones();
		setTipoPersona(tipoPersona);
		super.fecha.setAno(ano);
		super.fecha.setMes(mes);
		super.fecha.setDia(dia);
		setNumero(carnet);
		setDireccion(lugar);
		setAlerta(pAlerta);
		setTipo("pelicula");
	}
	public void setGenero(String genero){
		this.genero=genero;
	}
	public void setCategoria(String categoria){
		this.categoria=categoria;
	}
	public String getGenero(){
		return genero;
	}
	public String getCategoria(){
		return categoria;
	}
	public String toString(){
		String msg;
		msg="Titulo: "+getTitulo()+"\n"+"\n";
		msg+="Productor: "+getAutorProductor()+"\n"+"\n";
		msg+="Genero: "+getGenero()+"\n"+"\n";
		msg+="categoría: "+getCategoria()+"\n"+"\n";
		msg+="Calificación: "+getCalificacion();
		return msg;
	}
}
