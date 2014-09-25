package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import persona.Colega;
import persona.Estudiante;
import persona.Familiar;
import persona.Persona;
import articulo.Articulo;
import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;

public class BibliotecaLUKRIO implements MouseListener {
	//if(personas.get(0).getTipo()=="Colega"){
	//((Colega)personas.get(0)).getPuesto();
	//((Estudiante)personas.get(0)).getNombre();
	//((Familiar)personas.get(0)).getNombre();
	//}
	public static ArrayList<Persona> personas = new ArrayList<Persona>();
	public static ArrayList<Articulo>articulos=new ArrayList<Articulo>();
	static int carnet=20140000;
	//Fecha fecha = new Fecha();
	JFrame vPrincipal;
	FormularioPersona formulario = new FormularioPersona();
	ConsultarPersonas consultarPersonas=new ConsultarPersonas();
	JButton bRegistrarPersonas,bConsultarPersonas,bCargarPersonas,bConsultarPersPertamos,bActividadesRecientes,
	bRegistrarArticulos,bConsultarArticulos,bCargarArticulos,bConsultarArtPrestados,bAdelantarDia;
	BibliotecaLUKRIO(){
        vPrincipal=new JFrame();
		vPrincipal.setBounds(400,100,600,360);
		vPrincipal.setLayout(null);
		vPrincipal.setTitle("Biblioteca LUKRIO");
        creaBotones();
        vPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vPrincipal.setVisible(true);
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
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==bRegistrarPersonas){
			formulario.formulario.setVisible(true);
		}else if(e.getSource()==bConsultarPersonas){
			consultarPersonas.ventanaConsultas.setVisible(true);
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
