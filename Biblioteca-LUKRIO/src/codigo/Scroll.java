package codigo;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;
public class Scroll extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	JButton bBuscar;
	JRadioButton selecLibros,selecRevistas,selecPeliculas,selecTodos;
	JTextField entradaTitulo=new JTextField("Titulo");
	JTextField entradaAutor=new JTextField("Autor");
	JTextField entradaEditorial=new JTextField("Editorial");
	JTextField entradaEdicion=new JTextField("Edici�n");
	String tipo="libro";
	
	JPanel panel = new JPanel(null);
    public Scroll(){
    	bBuscar=new JButton("Buscar");
    	selecLibros=new JRadioButton("Libros");
		selecRevistas= new JRadioButton("Revistas");
		selecPeliculas= new JRadioButton("Peliculas");
		selecTodos= new JRadioButton("Todos");
        this.setLayout(null);
    }
    public void creaMenu(){
		bBuscar.setBounds(780,10,100,30);
		bBuscar.addMouseListener(this);
		
		selecLibros.setBounds(10,10,100,30);
		selecRevistas.setBounds(110,10,100,30);
		selecPeliculas.setBounds(210,10,100,30);
		selecTodos.setBounds(310,10,100,30);
		
		selecLibros.addMouseListener(this);
		selecRevistas.addMouseListener(this);
		selecPeliculas.addMouseListener(this);
		selecTodos.addMouseListener(this);
		
		ButtonGroup selector = new ButtonGroup();
		selecLibros.setSelected(true);
		selector.add(selecLibros);
		selector.add(selecRevistas);
		selector.add(selecPeliculas);
		selector.add(selecTodos);
		panel.add(bBuscar);
		panel.add(selecLibros);
		panel.add(selecRevistas);
		panel.add(selecPeliculas);
		panel.add(selecTodos);
		
		entradaTitulo.setBounds(410,10,90,30);
		entradaAutor.setBounds(500,10,90,30);
		entradaEditorial.setBounds(590,10,90,30);
		entradaEdicion.setBounds(680,10,90,30);
	}
    private JScrollPane getPanel(Dimension d) {
        panel.setPreferredSize(d);
        JScrollPane scrollPane = new JScrollPane(panel);
        return scrollPane;
    }
    public void eliminaElementos(){
    	this.removeAll();
    	panel.removeAll();
    	
    	panel.add(bBuscar);
		panel.add(selecLibros);
		panel.add(selecRevistas);
		panel.add(selecPeliculas);
		panel.add(selecTodos);
    	panel.add(entradaTitulo);
		panel.add(entradaAutor);
		panel.add(entradaEditorial);
		panel.add(entradaEdicion);
    }
    public void setDimension(int numero){
    	eliminaElementos();
        Dimension d2 = new Dimension(860, 250*(numero));
        JScrollPane scrollpane2 =  getPanel(d2);
        this.add(scrollpane2);
        scrollpane2.setBounds(0,0,895,552);
    }
    public void leeArticulo(){
    	int largo=0;
    	for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
    		if(tipo!="todos"){
	    		if(BibliotecaLUKRIO.articulos.get(i).getTipo()==tipo){
	    			largo++;
	    		}
    		}else{
    			largo=BibliotecaLUKRIO.articulos.size();
    			break;
    		}
    	}
    	setDimension(largo);
    	int x=10,y=50;
    	if(tipo!="todos"){
	    	for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
	    		if(BibliotecaLUKRIO.articulos.get(i).getTipo()==tipo){
	    			System.out.println(tipo);
	    			anadirBoton(BibliotecaLUKRIO.articulos.get(i).getBotonPrestado(),x,y+170);
	    			anadirBoton(BibliotecaLUKRIO.articulos.get(i).getBotonEliminar(),x+110,y+170);
	    			anadirPortada(BibliotecaLUKRIO.articulos.get(i).getPortada(),x+250,y);
	    			if(BibliotecaLUKRIO.articulos.get(i).getPrestado()){
	    				System.out.println("Entra al prestado");
	    				anadirJTextArea(BibliotecaLUKRIO.articulos.get(i).fecha.toString(),x+500,y,16);
	    				ImageIcon icon=new ImageIcon("imagenes/"+BibliotecaLUKRIO.articulos.get(i).getAlerta()+".png");
	    				Image icono = icon.getImage();  //Se obtiene la imagen del icono
	    				ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(100,100,Image.SCALE_SMOOTH)); //Cambiamos el tama�o de la imagen
	    				anadirPortada(iconoEscalado,x+650,y);
	    			}else{
	    				anadirJTextArea("Sin Prestar",x+500,y+70,16);
	    			}
	    			if(tipo=="libro"){
	    				anadirJTextArea(((Libro)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
	    			}else if(tipo=="revista"){
	    				anadirJTextArea(((Revista)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
	    			}else if(tipo=="pelicula"){
	    				anadirJTextArea(((Pelicula)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
	    			}
	    			y+=210;
	    		}
	    	}
    	}else{
    		int cont=3;
    		String busco=null;
    		while(cont>0){
    			if(cont==3){
    				busco="libro";
    			}else if(cont==2){
    				busco="revista";
    			}else if(cont==1){
    				busco="pelicula";
    			}
	    		for(int i=0;i<BibliotecaLUKRIO.articulos.size();i++){
		    		if(BibliotecaLUKRIO.articulos.get(i).getTipo()==busco){
		    			System.out.println(tipo);
		    			anadirBoton(BibliotecaLUKRIO.articulos.get(i).getBotonPrestado(),x,y+170);
		    			anadirBoton(BibliotecaLUKRIO.articulos.get(i).getBotonEliminar(),x+110,y+170);
		    			anadirPortada(BibliotecaLUKRIO.articulos.get(i).getPortada(),x+250,y);
		    			y+=210;
		    			if(busco=="libro"){
		    				anadirJTextArea(((Libro)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
		    			}else if(busco=="revista"){
		    				anadirJTextArea(((Revista)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
		    			}else if(busco=="pelicula"){
		    				anadirJTextArea(((Pelicula)BibliotecaLUKRIO.articulos.get(i)).toString(),x,y,12);
		    			}
		    			if(BibliotecaLUKRIO.articulos.get(i).getPrestado()){
		    				System.out.println("Entra al prestado");
		    				anadirJTextArea(BibliotecaLUKRIO.articulos.get(i).fecha.toString(),x+500,y,16);
		    				ImageIcon icon=new ImageIcon("imagenes/"+BibliotecaLUKRIO.articulos.get(i).getAlerta()+".png");
		    				Image icono = icon.getImage();  //Se obtiene la imagen del icono
		    				ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(100,100,Image.SCALE_SMOOTH)); //Cambiamos el tama�o de la imagen
		    				anadirPortada(iconoEscalado,x+650,y);
		    			}else{
		    				anadirJTextArea("Sin Prestar",x+500,y+70,16);
		    			}
		    		}
		    	}cont--;
    		}
    	}
    }
    public void anadirBoton(JButton boton,int x,int y){
        boton.setLocation(x,y);
        panel.add(boton);
    }
    public void anadirPortada(ImageIcon imagen,int x,int y){
    	JLabel label = new JLabel();
    	label.setBounds(x, y, 200, 200);
    	label.setIcon(imagen);
    	label.setOpaque(false);
    	panel.add(label);    	
    }
    public void anadirLabel(String info,int x,int y){
    	JLabel label = new JLabel();
    	label.setBounds(x, y, 400, 30);
    	label.setText(info);
    	panel.add(label);
    }
    public void anadirRadioButton(String nombre,int x,int y){
    	JRadioButton radioButton = new JRadioButton();
    	radioButton.setBounds(x, y, 200, 30);
    	radioButton.setText(nombre);
    	panel.add(radioButton);    	
    }
    public void anadirJTextArea(String nombre,int x,int y,int letra){
    	System.out.println(nombre);
    	JTextArea informacion = new JTextArea();
    	informacion.setBounds(x, y, 200, 170);
    	informacion.setText(nombre);
    	informacion.setEditable(false);
    	informacion.setOpaque(false);
    	informacion.setFont(new Font(null, Font.BOLD,letra));
    	panel.add(informacion);
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==bBuscar){
			leeArticulo();
		}else if(selecLibros.isSelected()){
			tipo="libro";
		}else if(selecRevistas.isSelected()){
			tipo="revista";
		}else if(selecPeliculas.isSelected()){
			tipo="pelicula";
		}else if(selecTodos.isSelected()){
			tipo="todos";
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