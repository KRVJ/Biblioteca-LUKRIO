package codigo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;

public class FormularioArticulo implements MouseListener {
	static JFrame vRegistroLibros=new JFrame();
	
	JButton bRegistrarArticulo,cargarPortada;
	static JLabel label=new JLabel();
	static ImageIcon portada;
	String tipoSeleccion;
	
	JTextField entradaTitulo=new JTextField("Introduce el título");
    JTextField entradaAutor=new JTextField("Introduce el autor");
    JTextField entradaEditorial=new JTextField("Introduce el editorial");
    JTextField entradaEdicion=new JTextField("Introduce la edición");
    //JTextField entradaCalificacion=new JTextField("Introduce el calificación(1-5)");
    JRadioButton calificacion1 = new JRadioButton("");
    JRadioButton calificacion2 = new JRadioButton("");
    JRadioButton calificacion3 = new JRadioButton("");
    JRadioButton calificacion4 = new JRadioButton("");
    JRadioButton calificacion5 = new JRadioButton("");
  //Botones del seleccionador del formulario
  	JRadioButton seleccionarLibro = new JRadioButton("Libro");
    JRadioButton seleccionarPelicula = new JRadioButton("Pelicula");
    JRadioButton seleccionarRevista = new JRadioButton("Revista");
      
    int calificacion=1;
    
	private JLabel labelTitulo,labelAutor,labelEditorial,labelEdicion,labelCalificacion,labelNumeroCalificacion;
	
	FormularioArticulo(){
		vRegistroLibros.setLayout(null);
		vRegistroLibros.setTitle("Cargar Libro");  //Titulo de ventana
		vRegistroLibros.setSize(550,350);       //Tamaño de ventana
		vRegistroLibros.setLocation(450,145);  //localizacion de ventana
		vRegistroLibros.setResizable(false);  //Minimizar ventana
		crearInterfaz();
		vRegistroLibros.setVisible(false);   //Oculta la ventana
		//cargarArchivo();
	}
	public void crearInterfaz(){
		tipoSeleccion="libro";
		bRegistrarArticulo=new JButton("Registrar libro");
		bRegistrarArticulo.setBounds(70,270,200,30);
		vRegistroLibros.add(bRegistrarArticulo);
		bRegistrarArticulo.addMouseListener(this);
        
        cargarPortada=new JButton("Cargar portada");
        cargarPortada.setBounds(320,220,200,30);
		vRegistroLibros.add(cargarPortada);
		cargarPortada.addMouseListener(this);
		
		entradaTitulo.setBounds(100,10,150,20);
        vRegistroLibros.add(entradaTitulo);
        labelTitulo=new JLabel("Título:");
        labelTitulo.setBounds(10,10,100,20);
        vRegistroLibros.add(labelTitulo);
        
        entradaAutor.setBounds(100,50,150,20);
        vRegistroLibros.add(entradaAutor);
        labelAutor=new JLabel("Autor:");
        labelAutor.setBounds(10,50,100,20);
        vRegistroLibros.add(labelAutor);
        
        entradaEditorial.setBounds(100,90,150,20);
        vRegistroLibros.add(entradaEditorial);
        labelEditorial=new JLabel("Editorial:");
        labelEditorial.setBounds(10,90,100,20);
        vRegistroLibros.add(labelEditorial);
        
        entradaEdicion.setBounds(100,130,150,20);
        vRegistroLibros.add(entradaEdicion);
        labelEdicion=new JLabel("Edición:");
        labelEdicion.setBounds(10,130,100,20);
        vRegistroLibros.add(labelEdicion);
        
        labelCalificacion=new JLabel("Calificación:");
        labelCalificacion.setBounds(10,170,100,20);
        vRegistroLibros.add(labelCalificacion);
        
        labelNumeroCalificacion=new JLabel("  1        2        3       4        5");
        labelNumeroCalificacion.setBounds(100,190,210,20);
        vRegistroLibros.add(labelNumeroCalificacion);
        
        ButtonGroup selecTipo = new ButtonGroup();  //Grupo para el RadioButton
        
        seleccionarLibro.setActionCommand("Libro");
        seleccionarLibro.setSelected(true);
        seleccionarLibro.addMouseListener(this); 
        seleccionarLibro.setBounds(10,230,100,20);
        seleccionarLibro.setSelected(true);
        vRegistroLibros.add(seleccionarLibro);
        
        seleccionarPelicula.setActionCommand("Pelicula");
        seleccionarPelicula.addMouseListener(this); 
        seleccionarPelicula.setBounds(110,230,100,20);
        vRegistroLibros.add(seleccionarPelicula);
        
        seleccionarRevista.setActionCommand("Revista");
        seleccionarRevista.addMouseListener(this); 
        seleccionarRevista.setBounds(210,230,100,20);
        vRegistroLibros.add(seleccionarRevista);
        
        selecTipo.add(seleccionarLibro);
        selecTipo.add(seleccionarPelicula);
        selecTipo.add(seleccionarRevista);
        
        ButtonGroup selector = new ButtonGroup();  //Grupo para el RadioButton
        
        calificacion1.setActionCommand("1");
        calificacion1.setSelected(true);
        calificacion1.addMouseListener(this); 
        calificacion1.setBounds(100,170,30,20);
        vRegistroLibros.add(calificacion1);
        
        calificacion2.setActionCommand("2");
        calificacion2.addMouseListener(this); 
        calificacion2.setBounds(130,170,20,20);
        vRegistroLibros.add(calificacion2);
        
        calificacion3.setActionCommand("3");
        calificacion3.addMouseListener(this); 
        calificacion3.setBounds(160,170,20,20);
        vRegistroLibros.add(calificacion3);
        
        calificacion4.setActionCommand("4");
        calificacion4.addMouseListener(this); 
        calificacion4.setBounds(190,170,20,20);
        vRegistroLibros.add(calificacion4);
        
        calificacion5.setActionCommand("5");
        calificacion5.addMouseListener(this); 
        calificacion5.setBounds(220,170,20,20);
        vRegistroLibros.add(calificacion5);
        
        selector.add(calificacion1);
        selector.add(calificacion2);
        selector.add(calificacion3);
        selector.add(calificacion4);
        selector.add(calificacion5);
        
        //http://docs.oracle.com/javase/tutorial/uiswing/components/border.html
        
        Object lineaExterior = BorderFactory.createLineBorder(Color.black);
        label.setText("              Cargar Portada");
        label.setBorder((Border) lineaExterior);
        label.setBounds(320,10,200,200);
        vRegistroLibros.add(label);
	}
	static BufferedImage imagen;
	public static void cargarPortada() throws IOException{
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			try{
				imagen = ImageIO.read(chooser.getSelectedFile());
			}catch(Exception exception){}
			ImageIcon icon=new ImageIcon(imagen);
			Image icono = icon.getImage();  //Se obtiene la imagen del icono
		    ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(200,200,Image.SCALE_SMOOTH)); //Cambiamos el tamaño de la imagen
			portada=iconoEscalado;
	        label.setIcon(iconoEscalado);
	        vRegistroLibros.setVisible(false);
	        vRegistroLibros.setVisible(true);
		}catch(Exception exception){
		}
	}
	public void refrescarVentana(){
		entradaTitulo.setText("Introduce el título");
		entradaAutor.setText("Introduce el título");
		entradaEditorial.setText("Introduce el editorial");
		entradaEdicion.setText("Introduce la edición");
		calificacion=1;
		calificacion1.setSelected(true);
		label.setIcon(null);
		vRegistroLibros.setVisible(false);
	}
	public void registrarLibro(){
		if(entradaTitulo.getText().equals("Introduce el título")==false && entradaTitulo.getText().equals("")==false
		&& entradaAutor.getText().equals("Introduce el autor")==false && entradaAutor.getText().equals("")==false
		&& entradaEditorial.getText().equals("Introduce el editorial")==false && entradaEditorial.getText().equals("")==false
		&& entradaEdicion.getText().equals("Introduce la edición")==false && entradaEdicion.getText().equals("")==false && label.getIcon()!=null){
			if(tipoSeleccion=="libro"){
				BibliotecaLUKRIO.articulos.add(new Libro(entradaTitulo.getText(),entradaAutor.getText(),entradaEditorial.getText(),entradaEdicion.getText(),portada,calificacion));
			}else if(tipoSeleccion=="pelicula"){
				BibliotecaLUKRIO.articulos.add(new Pelicula(entradaTitulo.getText(),entradaAutor.getText(),entradaEditorial.getText(),entradaEdicion.getText(),portada,calificacion));
			}else if(tipoSeleccion=="pelicula"){
				BibliotecaLUKRIO.articulos.add(new Revista(entradaTitulo.getText(),entradaAutor.getText(),entradaEditorial.getText(),entradaEdicion.getText(),portada,calificacion));
			}
			Component frame = null;
			refrescarVentana();
			JOptionPane.showMessageDialog(frame,tipoSeleccion+" registrad@ correctamente.");
		}else{
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Por favor rellene todos los datos");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==cargarPortada){
			try {
				cargarPortada();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource()==bRegistrarArticulo){
			registrarLibro();
		}
		if(calificacion1.isSelected()){
			calificacion=1;
		}else if(calificacion2.isSelected()){
			calificacion=2;
		}else if(calificacion3.isSelected()){
			calificacion=3;
		}else if(calificacion4.isSelected()){
			calificacion=4;
		}else if(calificacion5.isSelected()){
			calificacion=5;
		}if(seleccionarLibro.isSelected()){
			bRegistrarArticulo.setText("Registrar Libro");
			tipoSeleccion="libro";
			//refrescarSeleccion("estudiante");
		}
		else if(seleccionarPelicula.isSelected()){
			bRegistrarArticulo.setText("Registrar Película");
			tipoSeleccion="pelicula";
			//refrescarSeleccion("colega");
		}
		else if(seleccionarRevista.isSelected()){
			bRegistrarArticulo.setText("Registrar Revista");
			tipoSeleccion="revista";
			//refrescarSeleccion("familiar");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
