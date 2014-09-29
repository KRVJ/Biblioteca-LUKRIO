package codigo;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import persona.Persona;
import articulo.Articulo;
import articulo.Libro;

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
	public static ConsultarArticulosPrestados consultarArticulosPrestados = new ConsultarArticulosPrestados();
	public static Fecha fecha = new Fecha();
	public static Mail correo= new Mail();
	JLabel lFecha = new JLabel();
	
	JButton bRegistrarPersonas,bConsultarPersonas,bCargarPersonas,bSalir,bConfiguracion,
	bRegistrarArticulos,bConsultarArticulos,bCargarArticulos,bConsultarArtPrestados,bAdelantarDia;
	BibliotecaLUKRIO(){
		consultarArticulos.scroll.leeArticulo();
		consultarArticulos.scroll.creaMenu();
		consultarArticulos.ventanaArticulos.setVisible(false);
		
		consultarArticulosPrestados.scroll.leeArticulo();
		consultarArticulosPrestados.scroll.creaMenu();
		consultarArticulosPrestados.ventanaArticulosPrestados.setVisible(false);
		
		vPrincipal=new JFrame();
		vPrincipal.setBounds(400,100,720,480);
		vPrincipal.setLayout(null);
		vPrincipal.setTitle("Biblioteca LUKRIO");
        creaBotones();
        
        fecha.fechaInicial();
        
        lFecha.setBounds(185,300,200,50);
        lFecha.setText(fecha.getDia()+"/"+fecha.getMes()+"/"+fecha.getAno());
        lFecha.setFont(new Font(null, Font.BOLD,24));
        vPrincipal.add(lFecha);
        
        ImagenFondo fondo = new ImagenFondo(cambiarTamañoImagen("imagenes/fondo.jpg",720,480).getImage());
		vPrincipal.getContentPane().add(fondo);
		vPrincipal.setResizable(false);
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
			cargarPersonas.cargar("personasRegistradas/archivo.txt",true);
		} catch (IOException e) {
		}
        cargarArticulos.listarImagenes("articulosGuardados","articulosGuardados/Articulos.txt");
	}
	public static ImageIcon cambiarTamañoImagen(String direccion,int x,int y){
		ImageIcon icon=new ImageIcon(direccion);
		Image icono = icon.getImage();  //Se obtiene la imagen del icono
		ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(x,y,Image.SCALE_SMOOTH)); //Cambiamos el tamaño de la imagen
		return iconoEscalado;
	}
	public void creaBotones(){
		bRegistrarPersonas=new JButton();
		bConsultarPersonas=new JButton();
		bCargarPersonas=new JButton();
		bSalir=new JButton();
		bConfiguracion=new JButton();
		bRegistrarArticulos=new JButton();
		bConsultarArticulos=new JButton();
		bCargarArticulos=new JButton();
		bConsultarArtPrestados=new JButton();
		bAdelantarDia=new JButton();
		
		bRegistrarPersonas.setBounds(5,5,70,80);
		bConsultarPersonas.setBounds(5,95,70,80);
		bCargarPersonas.setBounds(5,185,70,80);
		bConfiguracion.setBounds(5,275,70,80);
		bSalir.setBounds(5,365,70,80);
		bRegistrarArticulos.setBounds(635,5,70,80);
		bConsultarArticulos.setBounds(635,95,70,80);
		bCargarArticulos.setBounds(635,185,70,80);
		bConsultarArtPrestados.setBounds(635,275,70,80);
		bAdelantarDia.setBounds(635,365,70,80);
		
		bRegistrarPersonas.setIcon(cambiarTamañoImagen("imagenes/bRegistrarPersonas.png",80,90));
		bConsultarPersonas.setIcon(cambiarTamañoImagen("imagenes/bConsultarPersonas.png",80,90));
		bCargarPersonas.setIcon(cambiarTamañoImagen("imagenes/bCargarPersonas.png",80,90));
		bSalir.setIcon(cambiarTamañoImagen("imagenes/bSalir.png",80,90));
		bConfiguracion.setIcon(cambiarTamañoImagen("imagenes/bConfiguracion.png",80,90));
		bRegistrarArticulos.setIcon(cambiarTamañoImagen("imagenes/bRegistrarArticulos.png",80,90));
		bConsultarArticulos.setIcon(cambiarTamañoImagen("imagenes/bConsultarArticulos.png",80,90));
		bCargarArticulos.setIcon(cambiarTamañoImagen("imagenes/bCargarArticulos.png",80,90));
		bConsultarArtPrestados.setIcon(cambiarTamañoImagen("imagenes/bConsultarArtPrestados.png",80,90));
		bAdelantarDia.setIcon(cambiarTamañoImagen("imagenes/bAdelantarDia.png",80,90));
		
		bRegistrarPersonas.addMouseListener(this);
		bConsultarPersonas.addMouseListener(this);
		bCargarPersonas.addMouseListener(this);
		bSalir.addMouseListener(this);
		bConfiguracion.addMouseListener(this);
		bRegistrarArticulos.addMouseListener(this);
		bConsultarArticulos.addMouseListener(this);
		bCargarArticulos.addMouseListener(this);
		bConsultarArtPrestados.addMouseListener(this);
		bAdelantarDia.addMouseListener(this);
		
		vPrincipal.add(bRegistrarPersonas);
		vPrincipal.add(bConsultarPersonas);
		vPrincipal.add(bCargarPersonas);
		vPrincipal.add(bSalir);
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
			lFecha.setText(fecha.getDia()+"/"+fecha.getMes()+"/"+fecha.getAno());
		}else if(e.getSource()==bConsultarArtPrestados){
			consultarArticulosPrestados.ventanaArticulosPrestados.setVisible(true);
		}else if(e.getSource()==bSalir){
			System.exit(0);
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
