package articulo;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import codigo.BibliotecaLUKRIO;

public class Articulo implements MouseListener{
	String titulo,autorProductor;
	ImageIcon portada;
	public boolean prestado=false;
	int calificacion;
	int carnetPersona=0;
	String tipo;
	JButton bPrestar,bEliminar,bPrestar2;
	int diasTolerancia=0;
	String tipoAlerta="verde";
	int numero=0;
	JFrame ventanaCarnet;
	JTextField entradaCarnet;
	Articulo(){
	}
	//Setters y getters que comparten las subClases que heredan de Artículo.
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
	public void setPrestado(boolean prestado){
		this.prestado=prestado;
	}
	public boolean getPrestado(){
		return prestado;
	}
	public void devolver(){
		prestado=false;
		tipoAlerta="verde";
		diasTolerancia=0;
	}
	public void creaBotones(){
		bEliminar=new JButton();
		bEliminar.addMouseListener(this);
		bEliminar.setText("Eliminar");
		bEliminar.setSize(100,30);
		bPrestar=new JButton();
		bPrestar.setText("Prestar");
		bPrestar.addMouseListener(this);
		bPrestar.setSize(100,30);
		bPrestar2=new JButton();
		bPrestar2.setText("Prestar");
		bPrestar2.addMouseListener(this);
		bPrestar2.setBounds(10,100,100,30);
		creaVentana();
	}
	public void creaVentana(){
		entradaCarnet=new JTextField("Carnet");
		entradaCarnet.setBounds(10,20,100,30);
		ventanaCarnet=new JFrame();
		ventanaCarnet.setBounds(400,200,200,100);
		ventanaCarnet.add(bPrestar2);
		ventanaCarnet.add(entradaCarnet);
		ventanaCarnet.setVisible(false);
	}
	public int getPersona(){
		return carnetPersona;
	}
	public void prestarArticulo(int numeroCarnet){
		boolean existePersona=false;
		for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
			if(BibliotecaLUKRIO.personas.get(i).getCarnet()==numeroCarnet){
				existePersona=true;
				break;
			}
		}
		if(existePersona){
			ventanaCarnet.setVisible(false);
			bPrestar.setText("Devolver");
			carnetPersona=numeroCarnet;
			entradaCarnet.setText("Carnet");
		}else{
			Component frame=null;
			JOptionPane.showMessageDialog(frame,"El número de carnet: "+numeroCarnet+" no se encontro en "+tipo+"s");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==bEliminar){
			for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
				if(BibliotecaLUKRIO.articulos.get(i).getNumero()==getNumero()){
					BibliotecaLUKRIO.articulos.remove(i);
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
