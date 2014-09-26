package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ConsultarArticulos implements MouseListener{
	
	JFrame ventanaArticulos;

	JTextField entradaCarnet=new JTextField("Escriba el carnet");
	JTextField entradaTipo=new JTextField("Estudiante-Colega-Familiar");
	
	Scroll scroll = new Scroll(870,530);
	ConsultarArticulos(){
		ventanaArticulos=new JFrame();
		ventanaArticulos.setTitle("Consultar Árticulos");  //Titulo de ventana
		ventanaArticulos.setBounds(240,80,900,580);       //Tamaño de ventana
		ventanaArticulos.setResizable(false);  //Minimizar ventana
		ventanaArticulos.add(scroll);
		ventanaArticulos.setVisible(false);   //Oculta la ventana
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
