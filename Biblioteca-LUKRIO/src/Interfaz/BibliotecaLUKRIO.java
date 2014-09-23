package Interfaz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class BibliotecaLUKRIO implements MouseListener {
	//Fecha fecha = new Fecha();
	JFrame vPrincipal,vRegistrarPersonas,vConsultarPersonas,vConsultarPersPrestamos,vRescientes,
	vRegistrarArticulo,vConsultarArticulos,vConsultarArtPrestamos;
	JButton bRegistrarPersonas,bConsultarPersonas,bCargarPersonas,bConsultarPersPertamos,bActividadesRecientes,
	bRegistrarArticulos,bConsultarArticulos,bCargarArticulos,bConsultarArtPrestados,bAdelantarDia;
	BibliotecaLUKRIO(){
		creaVentanas();
		creaBotones();
		vPrincipal.setVisible(true);
		vRegistrarPersonas.setVisible(false);
		vConsultarPersonas.setVisible(false);
		vConsultarPersPrestamos.setVisible(false);
		vRescientes.setVisible(false);
		vRegistrarArticulo.setVisible(false);
		vConsultarArticulos.setVisible(false);
		vConsultarArtPrestamos.setVisible(false);
	}
	public void creaVentanas(){
		vPrincipal=new JFrame();
		vPrincipal.setBounds(400,100,600,360);
		vPrincipal.setLayout(null);
		vPrincipal.setTitle("Biblioteca LUKRIO");
		
		vRegistrarPersonas=new JFrame();
		vRegistrarPersonas.setBounds(300,100,400,300);
		vRegistrarPersonas.setLayout(null);
		vRegistrarPersonas.setTitle("Registrar Persona");
		
		vConsultarPersonas=new JFrame();
		vConsultarPersonas.setBounds(100,50,500,400);
		vConsultarPersonas.setLayout(null);
		vConsultarPersonas.setTitle("Consultar Personas");
		
		vConsultarPersPrestamos=new JFrame();
		vConsultarPersPrestamos.setBounds(100,50,500,400);
		vConsultarPersPrestamos.setLayout(null);
		vConsultarPersPrestamos.setTitle("Personas con artítulos prestados");
		
		vRescientes=new JFrame();
		vRescientes.setBounds(200,50,400,400);
		vRescientes.setLayout(null);
		vRescientes.setTitle("Cambios Rescientes");
		
		vRegistrarArticulo=new JFrame();
		vRegistrarArticulo.setBounds(300,100,400,300);
		vRegistrarArticulo.setLayout(null);
		vRegistrarArticulo.setTitle("Registrar Articulo");
		
		vConsultarArticulos=new JFrame();
		vConsultarArticulos.setBounds(100,50,500,400);
		vConsultarArticulos.setLayout(null);
		vConsultarArticulos.setTitle("Consultar Articulos");
		
		vConsultarArtPrestamos=new JFrame();
		vConsultarArtPrestamos.setBounds(100,50,500,400);
		vConsultarArtPrestamos.setLayout(null);
		vConsultarArtPrestamos.setTitle("Consultar Artículos Prestados");
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
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
