package codigo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import persona.Colega;
import persona.Estudiante;
import persona.Familiar;
import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;

public class ConsultarArticulos implements MouseListener{
	static JFrame ventanaArticulos=new JFrame();
	static JTable table;
	String[] columnas = {"Titulo","Autor","Editorial","Editor"};
	Object[][] info = {};
	DefaultTableModel tabla= new DefaultTableModel(info,columnas);
	JButton botonReiniciar,botonPrestar;
	static JButton prestarArticulo;;
	static JRadioButton seleccionarLibro = new JRadioButton("Libros");
    JRadioButton seleccionarPelicula = new JRadioButton("Películas");
    JRadioButton seleccionarRevista = new JRadioButton("Revistas");
    
    static Frame ventanaPrestarDevolver=new JFrame();
	JTextField entradaCarnet=new JTextField("Escriba el carnet");
	JTextField entradaTipo=new JTextField("Estudiante-Colega-Familiar");
    
    static JLabel label=new JLabel();
	
	ConsultarArticulos(){
		botonReiniciar=new JButton();
		botonReiniciar.setBounds(670,440,200,30);
		botonReiniciar.setText("Reiniciar Tabla");
		botonReiniciar.addMouseListener(this);
		
		prestarArticulo=new JButton();
		prestarArticulo.setBounds(670,390,200,30);
		prestarArticulo.setText("Prestar");
		prestarArticulo.addMouseListener(this);
		
		ventanaArticulos.setLayout(null);
		ventanaArticulos.setTitle("Consultar Árticulos");  //Titulo de ventana
		ventanaArticulos.setSize(900,580);       //Tamaño de ventana
		ventanaArticulos.setLocation(240,80);  //localizacion de ventana
		ventanaArticulos.setResizable(false);  //Minimizar ventana
		ventanaArticulos.setVisible(false);   //Oculta la ventana
		ventanaArticulos.add(botonReiniciar);
		ventanaArticulos.add(prestarArticulo);
		creaInterfaz();
		reiniciaTabla();
		creaVentanaPrestamos();
		//cargarArchivo();
	}
	public void creaVentanaPrestamos(){
		ventanaPrestarDevolver.setLayout(null);
		ventanaPrestarDevolver.setSize(400,200);
		ventanaPrestarDevolver.setLocation(300,200);
		
		botonPrestar=new JButton();
		botonPrestar.setBounds(20,70,200,30);
		botonPrestar.setText("Prestar");
		botonPrestar.addMouseListener(this);
		
		entradaCarnet.setBounds(20,10,200,30);
		entradaTipo.setBounds(20,40,200,30);
		
		ventanaPrestarDevolver.add(entradaCarnet);
		ventanaPrestarDevolver.add(entradaTipo);
		ventanaPrestarDevolver.add(botonPrestar);
		//El boton Prestar Articulo es para imprimirlo en la pantalla de busqueda.
		ventanaPrestarDevolver.setVisible(false);
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
		table = new JTable(tabla);
		table.setPreferredScrollableViewportSize(new Dimension(50,50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(this); 
		
		Object lineaExterior = BorderFactory.createLineBorder(Color.black);
		label.setText("              Cargar Portada");
        label.setBorder((Border) lineaExterior);
        label.setBounds(650,40,200,200);
        ventanaArticulos.add(label);
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10,40,600,500);
		ventanaArticulos.add(scrollPane);
		
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
	public void setValoresTabla(String busqueda){
		reiniciaTabla();
		if(busqueda=="Libros"){
			for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
				if(BibliotecaLUKRIO.articulos.get(i).getTipo()=="libro"){
				Object[] libro = new Object[]{((Libro)BibliotecaLUKRIO.articulos.get(i)).getTitulo(),((Libro)BibliotecaLUKRIO.articulos.get(i)).getAutorProductor(),((Libro)BibliotecaLUKRIO.articulos.get(i)).getEdicion(),
						((Libro)BibliotecaLUKRIO.articulos.get(i)).getEditorial()};
				tabla.addRow(libro);
				}
			}
		}else if(busqueda=="Peliculas"){
			for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
				if(BibliotecaLUKRIO.articulos.get(i).getTipo()=="pelicula"){
				Object[] libro = new Object[]{((Pelicula)BibliotecaLUKRIO.articulos.get(i)).getTitulo(),((Pelicula)BibliotecaLUKRIO.articulos.get(i)).getAutorProductor(),((Pelicula)BibliotecaLUKRIO.articulos.get(i)).getEdicion(),
						((Pelicula)BibliotecaLUKRIO.articulos.get(i)).getEditorial()};
				tabla.addRow(libro);
				}
			}
		}else{
			for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
				if(BibliotecaLUKRIO.articulos.get(i).getTipo()=="pelicula"){
				Object[] libro = new Object[]{((Revista)BibliotecaLUKRIO.articulos.get(i)).getTitulo(),((Revista)BibliotecaLUKRIO.articulos.get(i)).getAutorProductor(),((Revista)BibliotecaLUKRIO.articulos.get(i)).getEdicion(),
						((Revista)BibliotecaLUKRIO.articulos.get(i)).getEditorial()};
				tabla.addRow(libro);
				}
			}
		}
	}
	public void modificarColumnas(String caracteristicaA,String caracteristicaB){
		//tabla.setColumnIdentifiers(Object[]{"Título","Autor",a,b});
	}
	public void reiniciaTabla(){
		while(tabla.getRowCount()!=0){
			tabla.removeRow(0);
		}
	}
	public static void cargarPortada(int posicionArticulo){
		if (posicionArticulo!=-1){
			if(seleccionarLibro.isSelected()){
				System.out.println("Mostrando Portada");
				if(BibliotecaLUKRIO.articulos.get(posicionArticulo).getPrestado()){
					System.out.println(BibliotecaLUKRIO.articulos.get(posicionArticulo).getPrestado()+"  tITULO"+BibliotecaLUKRIO.articulos.get(posicionArticulo).getTitulo());
		        	prestarArticulo.setText("Devolver");
		        }else{
		        	System.out.println("SIN PRESTAR"+BibliotecaLUKRIO.articulos.get(posicionArticulo).getPrestado()+"  tITULO"+BibliotecaLUKRIO.articulos.get(posicionArticulo).getTitulo());
		        	prestarArticulo.setText("Prestar");
		        }
				ImageIcon icon = BibliotecaLUKRIO.articulos.get(posicionArticulo).getPortada();
		        label.setIcon(icon);
		        System.out.println("Se brinco el else");
		        ventanaArticulos.setVisible(false);
		        ventanaArticulos.setVisible(true);
			}
		}
	}
	/*public void prestarArticulo(int numeroCarnet,String tipo){
		if(Interfaz.libros.get(table.getSelectedRow()).getPrestado()==false){
			boolean existePersona=false;
			if(tipo.equals("Estudiante")){
				for(Estudiante i:Interfaz.estudiantes){
					if(i.getCarnet()==numeroCarnet){
						existePersona=true;
						break;
					}
				}
			}else if(tipo.equals("Colega")){
				for(Colega i:Interfaz.colegas){
					if(i.getCarnet()==numeroCarnet){
						existePersona=true;
						break;
					}
				}
			}else{
				for(Familiar i:Interfaz.familiares){
					if(i.getCarnet()==numeroCarnet){
						existePersona=true;
						break;
					}
				}
			}
			if(existePersona){
				Interfaz.libros.get(table.getSelectedRow()).setPrestado(true);
				prestarArticulo.setText("Devolver");
			}else{
				Component frame=null;
				JOptionPane.showMessageDialog(frame,"El número de carnet: "+numeroCarnet+" no se encontro en "+tipo+"s");
			}
			
		}else{
			//prestarArticulo.setText("Prestar");
			Interfaz.libros.get(table.getSelectedRow()).setPrestado(false);
			Interfaz.libros.get(table.getSelectedRow()).setPersonaPrestado("nadie",0);
			prestarArticulo.setText("Prestar");
		}
	}*/
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table){
			cargarPortada(table.getSelectedRow());
		}else{
			if(e.getSource()==prestarArticulo){
				if(table.getSelectedRow()!=-1){
					System.out.println("Abriendo ventana");
					ventanaPrestarDevolver.setVisible(true);
				}else{
						//Seleccione una casilla
				}
			}else if(e.getSource()==botonPrestar){
				if(entradaCarnet.getText().equals("Escriba el carnet") || entradaCarnet.getText().equals("") || confirmarCarnet()){
					Component frame=null;
					JOptionPane.showMessageDialog(frame,"Escriba el número de carnet valido por favor");
				}else{
					if(entradaTipo.getText().equals("Estudiante") || entradaTipo.getText().equals("Colega") || entradaTipo.getText().equals("Familiar")){
							//prestarArticulo(Integer.parseInt(entradaCarnet.getText()),entradaTipo.getText());
						}else{
							Component frame=null;
							JOptionPane.showMessageDialog(frame,"Ingrese un tipo válido: <Estudiante> <Colega> <Familiar>");
						}
					}
				}else if(seleccionarLibro.isSelected()){
					setValoresTabla("Libros");
				}else if(seleccionarPelicula.isSelected()){
					setValoresTabla("Peliculas");
				}else if(seleccionarRevista.isSelected()){
					setValoresTabla("Revistas");
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
