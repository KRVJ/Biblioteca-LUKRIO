package codigo;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import persona.Persona;
import articulo.Articulo;

public class BibliotecaLUKRIO implements MouseListener {
	//if(personas.get(0).getTipo()=="Colega"){
	//((Colega)personas.get(0)).getPuesto();
	//((Estudiante)personas.get(0)).getNombre();
	//((Familiar)personas.get(0)).getNombre();
	//}
	public static ArrayList<Persona> personas = new ArrayList<Persona>();
	public static ArrayList<Articulo>articulos=new ArrayList<Articulo>();
	static int carnet=20140000;
	static int numeroArticulo=0;
	public static int toleranciaVerdeEstudiante=40;
	public static int toleranciaAmarilloEstudiante=25;
	public static int toleranciaRojoEstudiante=10;
	
	public static int toleranciaVerdeColega=45;
	public static int toleranciaAmarilloColega=30;
	public static int toleranciaRojoColega=15;
	
	public static int toleranciaVerdeFamiliar=50;
	public static int toleranciaAmarilloFamiliar=40;
	public static int toleranciaRojoFamiliar=30;
	//Fecha fecha = new Fecha();
	JFrame vPrincipal;
	
	FormularioPersona formulario = new FormularioPersona();
	ConsultarPersonas consultarPersonas=new ConsultarPersonas();
	CargarPersonas cargarPersonas = new CargarPersonas();
	CargarArticulos cargarArticulos = new CargarArticulos();
	FormularioArticulo registrarArticulo = new FormularioArticulo();
	Configuracion configuracion = new Configuracion();
	public static ConsultarArticulos consultarArticulos = new ConsultarArticulos();
	public static Fecha fecha = new Fecha();
	public static Mail correo= new Mail();
	
	JButton bRegistrarPersonas,bConsultarPersonas,bCargarPersonas,bConsultarPersPertamos,bConfiguracion,
	bRegistrarArticulos,bConsultarArticulos,bCargarArticulos,bConsultarArtPrestados,bAdelantarDia;
	BibliotecaLUKRIO(){
		consultarArticulos.scroll.leeArticulo();
		consultarArticulos.scroll.creaMenu();
		consultarArticulos.ventanaArticulos.setVisible(false);
		
		vPrincipal=new JFrame();
		vPrincipal.setBounds(400,100,620,380);
		vPrincipal.setLayout(null);
		vPrincipal.setTitle("Biblioteca LUKRIO");
        creaBotones();
        
        fecha.fechaInicial();
        
        ImagenFondo fondo = new ImagenFondo(cambiarTamañoImagen("imagenes/fondo.jpg",620,380).getImage());
		vPrincipal.getContentPane().add(fondo);
		vPrincipal.setResizable(false);
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
			cargarPersonas.cargar("personasRegistradas/archivo.txt",true);
		} catch (IOException e) {
		}
        cargarArticulos.listarImagenes("articulosGuardados","articulosGuardados/Articulos.txt");
	}
	public ImageIcon cambiarTamañoImagen(String direccion,int x,int y){
		ImageIcon icon=new ImageIcon(direccion);
		Image icono = icon.getImage();  //Se obtiene la imagen del icono
		ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(x,y,Image.SCALE_SMOOTH)); //Cambiamos el tamaño de la imagen
		return iconoEscalado;
	}
	public void creaBotones(){
		bRegistrarPersonas=new JButton();
		bConsultarPersonas=new JButton();
		bCargarPersonas=new JButton();
		bConsultarPersPertamos=new JButton();
		bConfiguracion=new JButton();
		bRegistrarArticulos=new JButton();
		bConsultarArticulos=new JButton();
		bCargarArticulos=new JButton();
		bConsultarArtPrestados=new JButton();
		bAdelantarDia=new JButton();
		
		bRegistrarPersonas.setBounds(5,5,50,60);
		bConsultarPersonas.setBounds(5,75,50,60);
		bCargarPersonas.setBounds(5,145,50,60);
		bConsultarPersPertamos.setBounds(5,215,50,60);
		bConfiguracion.setBounds(5,285,50,60);
		bRegistrarArticulos.setBounds(560,5,50,60);
		bConsultarArticulos.setBounds(560,75,50,60);
		bCargarArticulos.setBounds(560,145,50,60);
		bConsultarArtPrestados.setBounds(560,215,50,60);
		bAdelantarDia.setBounds(560,285,50,60);
		
		bRegistrarPersonas.setIcon(cambiarTamañoImagen("imagenes/libroRojo.png",50,100));
		bConsultarPersonas.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bCargarPersonas.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bConsultarPersPertamos.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bConfiguracion.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bRegistrarArticulos.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bConsultarArticulos.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bCargarArticulos.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bConsultarArtPrestados.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		bAdelantarDia.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas",108,58));
		
		bRegistrarPersonas.addMouseListener(this);
		bConsultarPersonas.addMouseListener(this);
		bCargarPersonas.addMouseListener(this);
		bConsultarPersPertamos.addMouseListener(this);
		bConfiguracion.addMouseListener(this);
		bRegistrarArticulos.addMouseListener(this);
		bConsultarArticulos.addMouseListener(this);
		bCargarArticulos.addMouseListener(this);
		bConsultarArtPrestados.addMouseListener(this);
		bAdelantarDia.addMouseListener(this);
		
		vPrincipal.add(bRegistrarPersonas);
		vPrincipal.add(bConsultarPersonas);
		vPrincipal.add(bCargarPersonas);
		vPrincipal.add(bConsultarPersPertamos);
		vPrincipal.add(bConfiguracion);
		vPrincipal.add(bRegistrarArticulos);
		vPrincipal.add(bConsultarArticulos);
		vPrincipal.add(bCargarArticulos);
		vPrincipal.add(bConsultarArtPrestados);
		vPrincipal.add(bAdelantarDia);
	}
    public static void main(String[] args) {
        BibliotecaLUKRIO biblioteca=new BibliotecaLUKRIO();
        biblioteca.vPrincipal.setVisible(true);
    }
    public void enviarCorreos(){
    	for(int i=0;i<articulos.size();i++){
    		articulos.get(i).cambiarTolerancia();
    	}
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==bRegistrarPersonas){
			formulario.formulario.setVisible(true);
		}else if(e.getSource()==bConsultarPersonas){
			consultarPersonas.ventanaConsultas.setVisible(true);
		}else if(e.getSource()==bCargarPersonas){
			try {
				cargarPersonas.cargarArchivo();
			} catch (Exception e1) {
			}
		}else if(e.getSource()==bRegistrarArticulos){
			FormularioArticulo.vRegistroLibros.setVisible(true);
		}else if(e.getSource()==bConsultarArticulos){
			//consultarArticulos.scroll.leeArticulo("libro");
			consultarArticulos.ventanaArticulos.setVisible(true);
		}else if(e.getSource()==bCargarArticulos){
			cargarArticulos.cargarCarpeta();
		}else if(e.getSource()==bConfiguracion){
			configuracion.vConfig.setVisible(true);
		}else if(e.getSource()==bAdelantarDia){
			fecha.setDia(1);
			enviarCorreos();
			consultarArticulos.scroll.leeArticulo();
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
