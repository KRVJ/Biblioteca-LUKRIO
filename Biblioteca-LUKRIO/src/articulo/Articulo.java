package articulo;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import codigo.BibliotecaLUKRIO;
import codigo.Fecha;

public class Articulo implements MouseListener{
	String titulo,autorProductor;
	ImageIcon portada;
	public boolean prestado;
	int calificacion;
	int carnetPersona;
	String tipo=null;
	String tipoPersona;
	JButton bPrestar,bEliminar,bPrestar2;
	String tipoAlerta;
	int numero;
	JFrame ventanaCarnet;
	String alerta;
	String direccionImagen;
	JTextField entradaCarnet;
	public Fecha fecha = new Fecha();
	//Setters y getters que comparten las subClases que heredan de Artículo.
	public void setDireccion(String direccionImagen){
		this.direccionImagen=direccionImagen;
	}
	public String getDireccionImagen(){
		return direccionImagen;
	}
	public void setNumero(int numero){
		this.numero=numero;
	}
	public int getNumero(){
		return numero;
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
	public void setBotonPrestado(JButton bPrestado){
		this.bPrestar=bPrestado;
	}
	public JButton getBotonPrestado(){
		return bPrestar;
	}
	public void setBotonEliminar(JButton bEliminar){
		this.bEliminar=bEliminar;
	}
	public JButton getBotonEliminar(){
		return bEliminar;
	}
	public void setPrestado(boolean prestado){
		this.prestado=prestado;
	}
	public boolean getPrestado(){
		return prestado;
	}
	public void devolver(){
		setPrestado(false);
		tipoAlerta="verde";
		tipo=null;
	}
	public void creaBotones(){
		bEliminar=new JButton();
		bEliminar.setText("Eliminar");
		bEliminar.setSize(100,30);
		bEliminar.addMouseListener(this);
		bPrestar=new JButton();
		bPrestar.setText("Prestar");
		bPrestar.addMouseListener(this);
		bPrestar.setSize(100,30);
		bPrestar2=new JButton();
		bPrestar2.setText("Prestar");
		bPrestar2.addMouseListener(this);
		bPrestar2.setBounds(10,40,150,30);
		setBotonPrestado(bPrestar);
		setBotonEliminar(bEliminar);
		creaVentana();
	}
	public void creaVentana(){
		entradaCarnet=new JTextField("Carnet");
		entradaCarnet.setBounds(10,10,150,30);
		ventanaCarnet=new JFrame();
		ventanaCarnet.setLayout(null);
		ventanaCarnet.setBounds(400,300,200,130);
		ventanaCarnet.add(bPrestar2);
		ventanaCarnet.add(entradaCarnet);
		ventanaCarnet.setVisible(false);
	}
	public int getPersona(){
		return carnetPersona;
	}
	public void prestarArticulo(int numeroCarnet){
		boolean existePersona=false;
		String tipoPersona=null;
		for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
			if(BibliotecaLUKRIO.personas.get(i).getCarnet()==numeroCarnet){
				existePersona=true;
				tipoPersona=BibliotecaLUKRIO.personas.get(i).getTipo();
				System.out.println(BibliotecaLUKRIO.personas.get(i).getTipo());
				break;
			}
		}
		if(existePersona){
			ventanaCarnet.setVisible(false);
			setPrestado(true);
			bPrestar.setText("Devolver");
			carnetPersona=numeroCarnet;
			entradaCarnet.setText("Carnet");
			setAlerta("verde");
			fecha.fechaInicial();
			setTipoPersona(tipoPersona);
			setFechaDevolucion();
			BibliotecaLUKRIO.consultarArticulos.scroll.leeArticulo();
		}else{
			JOptionPane.showMessageDialog(null,"La persona con el número de carnet: "+numeroCarnet+" no existe.");
		}
	}
	public void setTipoPersona(String tipoPersona){
		this.tipoPersona=tipoPersona;
	}
	public void setFechaDevolucion(){
		System.out.println(tipo+"  "+alerta);
		if(alerta=="verde"){
			if(tipoPersona=="estudiante"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaVerdeEstudiante);
			}else if(tipoPersona=="colega"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaVerdeColega);
			}else{
				fecha.setDia(BibliotecaLUKRIO.toleranciaVerdeFamiliar);
			}
		}else if(alerta=="amarillo"){
			if(tipoPersona=="estudiante"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaAmarilloEstudiante);
			}else if(tipoPersona=="colega"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaAmarilloColega);
			}else{
				fecha.setDia(BibliotecaLUKRIO.toleranciaAmarilloFamiliar);
			}
		}else if(alerta=="rojo"){
			if(tipoPersona=="estudiante"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaRojoEstudiante);
			}else if(tipoPersona=="colega"){
				fecha.setDia(BibliotecaLUKRIO.toleranciaRojoColega);
			}else{
				fecha.setDia(BibliotecaLUKRIO.toleranciaRojoFamiliar);
			}
		}
	}
	public boolean tiempoAcabado(){
		if(fecha.getDia()!=0 && fecha.getMes()!=0 && fecha.getAno()!=0){
			if(BibliotecaLUKRIO.fecha.getAno()==fecha.getAno()){
				if(BibliotecaLUKRIO.fecha.getMes()==fecha.getMes()){
					if(BibliotecaLUKRIO.fecha.getDia()==fecha.getDia()){
						return false;
					}else if(BibliotecaLUKRIO.fecha.getDia()<fecha.getDia()){
						return false;
					}else{return true;}
				}else if(BibliotecaLUKRIO.fecha.getMes()<fecha.getMes()){
					return false;
				}else{return true;}
			}else if(BibliotecaLUKRIO.fecha.getAno()<fecha.getAno()){
				return false;
			}else{
				return true;}
		}else{
			return false;}
	}
	public void cambiarTolerancia(){
		if(tiempoAcabado()){
			if(alerta.equals("verde")){
				setAlerta("amarillo");
				BibliotecaLUKRIO.correo.setMail("kntor497@gmail.com", "kramirezvegaj@hotmail.com","Se le ha acabado el"
						+ "primero tiempo para entregar el libro, la alerta pasarada de verde a "
						+ "amarillo y se le otorgaran unos dias mas para la devolución del mismo."
						+ " Gracias!!","mail", "1123581321kyk");
				//EnviaCorreo de alerta VERDE-AMARILLA
			}else if(alerta.equals("amarillo")){
				setAlerta("rojo");
				BibliotecaLUKRIO.correo.setMail("kntor497@gmail.com", "kramirezvegaj@hotmail.com","Se le ha acabado el"
						+ "segundo tiempo para entregar el libro, la alerta pasarada de amarillo a "
						+ "amarillo y se le otorgaran unos dias mas para la devolución del mismo."
						+ " Gracias!!","mail", "1123581321kyk");
				//EnviaCorreo de alerta AMARILLA-ROJA
			}else{
				BibliotecaLUKRIO.correo.setMail("kntor497@gmail.com", "kramirezvegaj@hotmail.com","Se le ha acabado el"
						+ "ultimo tiempo para entregar el libro, la alerta pasarada de amarillo a "
						+ "rojo y se le otorgaran los ultimos dias mas para la devolución del mismo."
						+ " Gracias!!","mail", "1123581321kyk");
				//EnviaCorreo de alerta ROJA
			}
			setFechaDevolucion();
		}
	}
	public void setAlerta(String alerta){
		this.alerta=alerta;
	}
	public String getAlerta(){
		return alerta;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==bEliminar){
			for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
				if(BibliotecaLUKRIO.articulos.get(i).getNumero()==this.getNumero()){
					BibliotecaLUKRIO.articulos.remove(i);
					BibliotecaLUKRIO.consultarArticulos.scroll.leeArticulo();
					break;
				}
			}
		}else if(e.getSource()==bPrestar){
			if(getPrestado()){
				bPrestar.setText("Prestar");
				entradaCarnet.setText("Carnet");
				carnetPersona=0;
				devolver();
			}else{
				ventanaCarnet.setVisible(true);
			}
		}else if(e.getSource()==bPrestar2){
			try{
				prestarArticulo(Integer.parseInt(entradaCarnet.getText()));
			}catch(Exception exception){
				Component frame=null;
				JOptionPane.showMessageDialog(frame,"Inserte un número de carnet válido");
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
