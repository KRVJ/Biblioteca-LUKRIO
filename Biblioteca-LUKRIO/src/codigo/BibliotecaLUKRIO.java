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
	public static int toleranciaVerdeEstudiante=10;
	public static int toleranciaAmarilloEstudiante=0;
	public static int toleranciaRojoEstudiante=0;
	
	public static int toleranciaVerdeColega=10;
	public static int toleranciaAmarilloColega=0;
	public static int toleranciaRojoColega=0;
	
	public static int toleranciaVerdeFamiliar=10;
	public static int toleranciaAmarilloFamiliar=0;
	public static int toleranciaRojoFamiliar=0;
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
	
	JButton bRegistrarPersonas,bConsultarPersonas,bCargarPersonas,bConsultarPersPertamos,bActividadesRecientes,
	bRegistrarArticulos,bConsultarArticulos,bCargarArticulos,bConsultarArtPrestados,bAdelantarDia;
	BibliotecaLUKRIO(){
		consultarArticulos.scroll.leeArticulo();
		consultarArticulos.scroll.creaMenu();
		consultarArticulos.ventanaArticulos.setVisible(false);
		
		vPrincipal=new JFrame();
		vPrincipal.setBounds(400,100,600,360);
		vPrincipal.setLayout(null);
		vPrincipal.setTitle("Biblioteca LUKRIO");
        creaBotones();
        
        fecha.fechaInicial();
        
        ImageIcon icon=new ImageIcon("imagenes/RedDragon.jpg");
		Image icono = icon.getImage();  //Se obtiene la imagen del icono
		ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(600,360,Image.SCALE_SMOOTH)); //Cambiamos el tamaño de la imagen
		ImagenFondo fondo = new ImagenFondo(iconoEscalado.getImage());
		vPrincipal.getContentPane().add(fondo);
		
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void creaBotones(){
		bRegistrarPersonas=new JButton();
		bConsultarPersonas=new JButton();
		bCargarPersonas=new JButton();
		bConsultarPersPertamos=new JButton();
		bActividadesRecientes=new JButton();
		bRegistrarArticulos=new JButton();
		bConsultarArticulos=new JButton();
		bCargarArticulos=new JButton();
		bConsultarArtPrestados=new JButton();
		bAdelantarDia=new JButton();
		
		bRegistrarPersonas.setBounds(5,5,150,30);
		bConsultarPersonas.setBounds(5,75,150,30);
		bCargarPersonas.setBounds(5,145,150,30);
		bConsultarPersPertamos.setBounds(5,215,150,30);
		bActividadesRecientes.setBounds(5,285,150,30);
		bRegistrarArticulos.setBounds(425,5,150,30);
		bConsultarArticulos.setBounds(425,75,150,30);
		bCargarArticulos.setBounds(425,145,150,30);
		bConsultarArtPrestados.setBounds(425,215,150,30);
		bAdelantarDia.setBounds(425,285,150,30);
		
		bRegistrarPersonas.setText("Registrar Persona");
		bConsultarPersonas.setText("Consular Personas");
		bCargarPersonas.setText("Cargar Personas");
		bConsultarPersPertamos.setText("Persona con Prestamos");
		bActividadesRecientes.setText("Cambios Recientes");
		bRegistrarArticulos.setText("Registrar Articulos");
		bConsultarArticulos.setText("Consultar Articulos");
		bCargarArticulos.setText("Cargar Articulos");
		bConsultarArtPrestados.setText("Articulos Prestados");
		bAdelantarDia.setText("Adelantar Dia");
		
		bRegistrarPersonas.addMouseListener(this);
		bConsultarPersonas.addMouseListener(this);
		bCargarPersonas.addMouseListener(this);
		bConsultarPersPertamos.addMouseListener(this);
		bActividadesRecientes.addMouseListener(this);
		bRegistrarArticulos.addMouseListener(this);
		bConsultarArticulos.addMouseListener(this);
		bCargarArticulos.addMouseListener(this);
		bConsultarArtPrestados.addMouseListener(this);
		bAdelantarDia.addMouseListener(this);
		
		vPrincipal.add(bRegistrarPersonas);
		vPrincipal.add(bConsultarPersonas);
		vPrincipal.add(bCargarPersonas);
		vPrincipal.add(bConsultarPersPertamos);
		vPrincipal.add(bActividadesRecientes);
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
				cargarPersonas.cargar();
			} catch (IOException e1) {
			}
		}else if(e.getSource()==bRegistrarArticulos){
			FormularioArticulo.vRegistroLibros.setVisible(true);
		}else if(e.getSource()==bConsultarArticulos){
			//consultarArticulos.scroll.leeArticulo("libro");
			consultarArticulos.ventanaArticulos.setVisible(true);
		}else if(e.getSource()==bCargarArticulos){
			cargarArticulos.listarImagenes();
		}else if(e.getSource()==bActividadesRecientes){
			configuracion.vConfig.setVisible(true);
		}else if(e.getSource()==bAdelantarDia){
			fecha.setDia(1);
			enviarCorreos();
			consultarArticulos.scroll.leeArticulo();
			System.out.println(fecha.getDia()+"  "+fecha.getMes()+"   "+fecha.getAno());
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
