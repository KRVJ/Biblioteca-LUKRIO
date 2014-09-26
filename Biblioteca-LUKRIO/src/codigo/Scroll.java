package codigo;

import java.awt.*;
import javax.swing.*;
public class Scroll extends JPanel{
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel(null);
    public Scroll(int x,int y){
        this.setLayout(null);
        Dimension d = new Dimension(1000,1000);
        JScrollPane scrollpane =  getPanel(d);
        this.add(scrollpane);
        scrollpane.setBounds(10,10,x,y);
    }
    private JScrollPane getPanel(Dimension d) {
        panel.setPreferredSize(d);
        JScrollPane scrollPane = new JScrollPane(panel);
        return scrollPane;
    }
    public void setDimension(int numero){
    	this.removeAll();
        Dimension d2 = new Dimension(100*(numero), 100*(numero));
        JScrollPane scrollpane2 =  getPanel(d2);
        this.add(scrollpane2);
        scrollpane2.setBounds(10,200,870,550);
    }
    public void anadirBoton(JButton boton,int x,int y){
        boton.setLocation(x,y);
        panel.add(boton);
    }
    public void anadirPortal(ImageIcon imagen,int x,int y){
    	JLabel label = new JLabel();
    	label.setBounds(x, y, 200, 200);
    	label.setIcon(imagen);
    	panel.add(label);    	
    }
    public void anadirLabel(String info,int x,int y){
    	JLabel label = new JLabel();
    	label.setBounds(x, y, 200, 200);
    	label.setText(info);
    	panel.add(label);    	
    }
    public void anadirRadioButton(String nombre,int x,int y){
    	JRadioButton rB = new JRadioButton();
    	rB.setBounds(x, y, 200, 200);
    	rB.setText(nombre);
    	panel.add(rB);    	
    }
}