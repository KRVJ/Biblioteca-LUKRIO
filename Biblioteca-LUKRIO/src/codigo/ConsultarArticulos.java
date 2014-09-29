package codigo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ConsultarArticulos{
	public static JFrame ventanaArticulos;
	public static Scroll scroll = new Scroll("normal");
	ConsultarArticulos(){
		ventanaArticulos=new JFrame();
		ventanaArticulos.setTitle("Consultar Árticulos");  //Titulo de ventana
		ventanaArticulos.setBounds(240,80,900,580);       //Tamaño de ventana
		ventanaArticulos.setResizable(false);  //Minimizar ventana
		ventanaArticulos.add(scroll);
		ventanaArticulos.setVisible(false);   //Oculta la ventana
	}
}
