package codigo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
//Clase para importar una imagen que este en el programa de java.
public class ImagenFondo extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image fondo;  //Declaramos fondo tipo Image
	public ImagenFondo(Image fondo){
		this.fondo=fondo;
		Dimension dimension = new Dimension(fondo.getWidth(null),fondo.getHeight(null));
		this.setPreferredSize(dimension);
		this.setMaximumSize(dimension);
		this.setSize(dimension);
		this.setLayout(null);
	}
	@Override
	protected void paintComponent(Graphics g){
		g.drawImage(fondo,0,0,null);
	}
}
