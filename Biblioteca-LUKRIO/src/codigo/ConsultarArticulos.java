package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ConsultarArticulos implements MouseListener{
	JFrame ventanaArticulos=new JFrame();
	JButton botonReiniciar;
	JRadioButton seleccionarLibro = new JRadioButton("Libros");
    JRadioButton seleccionarPelicula = new JRadioButton("Películas");
    JRadioButton seleccionarRevista = new JRadioButton("Revistas");

	JTextField entradaCarnet=new JTextField("Escriba el carnet");
	JTextField entradaTipo=new JTextField("Estudiante-Colega-Familiar");
	
	ConsultarArticulos(){
		botonReiniciar=new JButton();
		botonReiniciar.setBounds(670,440,200,30);
		botonReiniciar.setText("Reiniciar Tabla");
		botonReiniciar.addMouseListener(this);
		
		ventanaArticulos.setLayout(null);
		ventanaArticulos.setTitle("Consultar Árticulos");  //Titulo de ventana
		ventanaArticulos.setSize(900,580);       //Tamaño de ventana
		ventanaArticulos.setLocation(240,80);  //localizacion de ventana
		ventanaArticulos.setResizable(false);  //Minimizar ventana
		ventanaArticulos.setVisible(false);   //Oculta la ventana
		ventanaArticulos.add(botonReiniciar);
		creaInterfaz();
		//cargarArchivo();
	}
	public boolean confirmarCarnet(){
		try{
			Integer.parseInt(entradaCarnet.getText());
			return false;
		}catch(Exception exception){
			return true;
		}
	}
	//Usar Articulo.getPrestado() si esta prestado retorna true, sino retorna false
	public void creaInterfaz(){
		
		ButtonGroup selector = new ButtonGroup();  //Grupo para el RadioButton
        
		seleccionarLibro.setActionCommand("Libros");
		seleccionarLibro.setSelected(true);
		seleccionarLibro.addMouseListener(this); 
		seleccionarLibro.setBounds(10,10,100,20);
		seleccionarLibro.setSelected(true);
        ventanaArticulos.add(seleccionarLibro);
        
        seleccionarPelicula.setActionCommand("Películas");
        seleccionarPelicula.addMouseListener(this);
        seleccionarPelicula.setBounds(110,10,100,20);
        ventanaArticulos.add(seleccionarPelicula);
        
        seleccionarRevista.setActionCommand("Revistas");
        seleccionarRevista.addMouseListener(this);
        seleccionarRevista.setBounds(210,10,100,20);
        ventanaArticulos.add(seleccionarRevista);
        
        selector.add(seleccionarLibro);
        selector.add(seleccionarPelicula);
        selector.add(seleccionarRevista);
	}
		//ImageIcon icon = BibliotecaLUKRIO.articulos.get(posicionArticulo).getPortada();
	@Override
	public void mouseClicked(MouseEvent e) {
		
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
