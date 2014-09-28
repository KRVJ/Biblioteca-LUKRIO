package codigo;
import java.awt.*;
import java.awt.event.*; 

/* Clase de ventana configuraciones
 * permite editar todos los valores parametrizables */
import javax.swing.*;


public class Configuracion implements ActionListener {
	static String valor="";
	Font fuente=new Font("TimesRoman", Font.BOLD, 18);
	// creacion de los witgets
	
	//botones de la ventana configuración
	JButton  CambiarAlertas= new JButton ("Cambiar alertas"); 
	JButton  top= new JButton ("Cambiar top ");
	JButton CambiarMasPrestados = new JButton ("Cambiar más prestados");
	JButton manual = new JButton("Manual");
	JButton salir = new JButton("Salir");
	JButton aceptar= new JButton("Aceptar");
	
	// textos de la ventana configuración
	JTextArea top1= new JTextArea("Ingrese el límite del \n         top: ");
	JTextArea prest= new JTextArea("Ingrese la cantidad minima\n de veces prestadas: ");
	JTextArea rango= new JTextArea("Ingrese la cantidad de \nmeses del rango: ");
	JTextArea alertas= new JTextArea("Ingrese el límite de las alertas: ");
	JTextArea col= new JTextArea("Colega : ");
	JTextArea est= new JTextArea("Estudiante : ");
	JTextArea fam= new JTextArea("Familiar : ");
	
	// entradas de las alertas
	JTextField limite=new JTextField();
	JTextField meses=new JTextField();
	JTextField amarC=new JTextField();
	JTextField amarE=new JTextField();
	JTextField amarF=new JTextField();
	JTextField verdC=new JTextField();
	JTextField verdE=new JTextField();
	JTextField verdF=new JTextField();
	JTextField rojC=new JTextField();
	JTextField rojE=new JTextField();
	JTextField rojF=new JTextField();
	//labels
	JLabel am= new JLabel();
	JLabel rj= new JLabel();
	JLabel vd= new JLabel();
	JLabel at= new JLabel();
	JLabel imageTop = new JLabel();
	JLabel imagePila = new JLabel();
	JButton atras = new JButton();
	
	
    JFrame vConfig;
	public Configuracion() {
		//ventana
		vConfig=new JFrame();
		
	    vConfig.setBounds(400,100,720,430);//cambio
	    vConfig.setLayout(null);
		
		vConfig.setTitle("Configuraciones");
		vConfig.add(CambiarAlertas);
        vConfig.add(top);
        vConfig.add(CambiarMasPrestados);
        vConfig.add(aceptar);
        vConfig.add(manual);
        vConfig.add(top1);
        vConfig.add(limite);
        vConfig.add(prest);
        vConfig.add(rango);
        vConfig.add(meses);
        vConfig.add(amarC);
        vConfig.add(amarE);
        vConfig.add(amarF);
        vConfig.add(verdC);
        vConfig.add(verdE);
        vConfig.add(verdF);
        vConfig.add(rojC);
        vConfig.add(rojE);
        vConfig.add(col);
        vConfig.add(est);
        vConfig.add(fam);
        vConfig.add(am);
        vConfig.add(rj);
        vConfig.add(vd);
        vConfig.add(atras);
        vConfig.add(imageTop);
        vConfig.add(imagePila);
        
        //label
        am.setBounds(225, 50, 100, 100);
        vd.setBounds(400, 50, 100, 100);
        rj.setBounds(580, 50, 100, 100);
        imageTop.setBounds(220, 160, 300, 250);
        imagePila.setBounds(490, 200, 150, 150);
        atras.setBounds(8,335,50,40);//cambio
        
        
        
        // dimensiones de los witgets
        CambiarAlertas.setBounds(0, 0, 180, 30);
        top.setBounds(175, 0, 180, 30);
        CambiarMasPrestados.setBounds(350, 0, 180, 30);
        manual.setBounds(525, 0, 180, 30);
        aceptar.setBounds(50, 70, 80, 50);
        
        // textArea
        top1.setBounds(290, 90, 150, 50);
        top1.setFont(fuente);
        prest.setBounds(290, 90, 150, 50);
        prest.setFont(fuente);
        rango.setBounds(290, 190, 150,50);
        rango.setFont(fuente);
        col.setBounds(50,150,150,30);
        col.setFont(fuente);
        est.setBounds(50,220,150,30);
       est.setFont(fuente);
        fam.setBounds(50, 290, 150,30);
        fam.setFont(fuente);
        
        // textField
        meses.setBounds(290, 250, 150, 30);
        limite.setBounds(300, 50, 150, 30);
        amarC.setBounds(230, 150, 80, 30);
        amarE.setBounds(230, 220, 80, 30);
        amarF.setBounds(230, 290, 80, 30);
        verdC.setBounds(405, 150, 80, 30);
        verdE.setBounds(405, 220, 80, 30);
        verdF.setBounds(405, 290, 80, 30);
        rojC.setBounds(580, 150, 80, 30);
        rojE.setBounds(580, 220, 80, 30);
        
        
        //impedir editar los textArea y textField
        prest.setOpaque(false);
        top1.setOpaque(false);
        rango.setOpaque(false);
        alertas.setOpaque(false);
        col.setOpaque(false);
        est.setOpaque(false);
        fam.setOpaque(false);
        prest.setEditable(false);
        top1.setEditable(false);
        rango.setEditable(false);
        alertas.setEditable(false);
        col.setEditable(false);
        est.setEditable(false);
        fam.setEditable(false);
        
        
        
        
        // comandos de los botones
        CambiarAlertas.addActionListener(this);
        top.addActionListener(this);
        CambiarMasPrestados.addActionListener(this);
        manual.addActionListener(this);
        aceptar.addActionListener(this);
        // agregar widgets a la ventana
        //agrego imagenes
        am.setIcon(cargarImagen("imagenes/amarillo.png",80,80));
        rj.setIcon(cargarImagen("imagenes/rojo.png",80,80));
        vd.setIcon(cargarImagen("imagenes/verde.png",80,80));
        atras.setIcon(cargarImagen("imagenes/retroceder.png",50,40));
        imageTop.setIcon(cargarImagen("imagenes/top.png",300,250));
        imagePila.setIcon(cargarImagen("imagenes/pila.png",150,150));
        
        // esconder widgets
        top1.setVisible(false);
        limite.setVisible(false);
        prest.setVisible(false);
        rango.setVisible(false);
        meses.setVisible(false);
        amarC.setVisible(false);
        amarE.setVisible(false);
        amarF.setVisible(false);
        verdC.setVisible(false);
        verdE.setVisible(false);
        verdF.setVisible(false);
        rojC.setVisible(false);
        rojE.setVisible(false);
        rojF.setVisible(false);
        col.setVisible(false);
        est.setVisible(false);
        fam.setVisible(false);
        am.setVisible(false);
        rj.setVisible(false);
        vd.setVisible(false);
        imageTop.setVisible(false);
        imagePila.setVisible(false);
        
        vConfig.setVisible(false);
	}
	// define las dimensiones de las imagenes que son colocadas en los botones
		public ImageIcon cargarImagen(String direccion,int width,int heigth){
			ImageIcon icon=new ImageIcon(direccion);
			Image icono = icon.getImage();  //Se obtiene la imagen del icono
		    ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(width,heigth,Image.SCALE_SMOOTH));
		    return iconoEscalado;
		}
	//REVISA ENTRADA DE NUMERO
	public boolean revisarNumero(String numero){
		try{
			Integer.parseInt(numero);
			return true;
		}catch(Exception exception){
			return false;
		}
	}
    //realiza las acciones de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// opcion top
		if(e.getSource()==top){
			valor="top";
			imagePila.setVisible(false);
			imageTop.setVisible(true);
			col.setVisible(false);
	        est.setVisible(false);
	        fam.setVisible(false);
			amarC.setVisible(false);
	        amarE.setVisible(false);
	        amarF.setVisible(false);
	        verdC.setVisible(false);
	        verdE.setVisible(false);
	        verdF.setVisible(false);
	        rojC.setVisible(false);
	        rojE.setVisible(false);
			limite.setBounds(290, 150, 150, 30);
			limite.setText("");
			meses.setVisible(false);
			prest.setVisible(false);
			rango.setVisible(false);
			top1.setVisible(true);
			limite.setVisible(true);
			aceptar.setVisible(true);
			am.setVisible(false);
		    rj.setVisible(false);
		    vd.setVisible(false);
			
		}
		
		// opcion cambiar Alertas
		else if(e.getSource()==CambiarAlertas){
			imageTop.setVisible(false);
			imagePila.setVisible(false);
			valor="cambiarA";
			limite.setText("");
			col.setVisible(true);
	        est.setVisible(true);
	        fam.setVisible(true);
			meses.setVisible(false);
			top1.setVisible(false);
			limite.setVisible(true);
	        limite.setBounds(580, 290, 80, 30);
	        prest.setVisible(false);
	        rango.setVisible(false);
	        amarC.setVisible(true);
	        amarE.setVisible(true);
	        amarF.setVisible(true);
	        verdC.setVisible(true);
	        verdE.setVisible(true);
	        verdF.setVisible(true);
	        rojC.setVisible(true);
	        rojE.setVisible(true);
	        am.setVisible(true);
	        rj.setVisible(true);
	        vd.setVisible(true);
			
		}
		//opcion cambiar más prestados
		else if(e.getSource()==CambiarMasPrestados){
			imageTop.setVisible(false);
			imagePila.setVisible(true);
			valor="masP";
			col.setVisible(false);
	        est.setVisible(false);
	        fam.setVisible(false);
			amarC.setVisible(false);
	        amarE.setVisible(false);
	        amarF.setVisible(false);
	        verdC.setVisible(false);
	        verdE.setVisible(false);
	        verdF.setVisible(false);
	        rojC.setVisible(false);
	        rojE.setVisible(false);
			limite.setBounds(290, 150, 150, 30);
			limite.setVisible(true);
			top1.setVisible(false);
			limite.setText("");
			prest.setVisible(true);
			rango.setVisible(true);
			meses.setVisible(true);
			am.setVisible(false);
		    rj.setVisible(false);
		    vd.setVisible(false);
			
		}
		// configuración manual
		else if(e.getSource()==manual){
			
			
		}
		// método aceptar
		else if(e.getSource()==aceptar){
			if(valor=="top"){
				// cambiar top	
			}
			else if(valor=="cambiarA"){
				if(revisarNumero(verdE.getText())){
					BibliotecaLUKRIO.toleranciaVerdeEstudiante=Integer.parseInt(verdE.getText());
				}if(revisarNumero(verdC.getText())){
					BibliotecaLUKRIO.toleranciaVerdeColega=Integer.parseInt(verdC.getText());
				}if(revisarNumero(verdF.getText())){
					BibliotecaLUKRIO.toleranciaVerdeFamiliar=Integer.parseInt(verdF.getText());
				}if(revisarNumero(amarE.getText())){
					BibliotecaLUKRIO.toleranciaAmarilloEstudiante=Integer.parseInt(amarE.getText());
				}if(revisarNumero(amarC.getText())){
					BibliotecaLUKRIO.toleranciaAmarilloColega=Integer.parseInt(amarC.getText());
				}if(revisarNumero(amarF.getText())){
					BibliotecaLUKRIO.toleranciaAmarilloFamiliar=Integer.parseInt(amarF.getText());
				}if(revisarNumero(rojE.getText())){
					BibliotecaLUKRIO.toleranciaRojoEstudiante=Integer.parseInt(rojE.getText());
				}if(revisarNumero(rojC.getText())){
					BibliotecaLUKRIO.toleranciaRojoColega=Integer.parseInt(rojC.getText());
				}if(revisarNumero(limite.getText())){
					BibliotecaLUKRIO.toleranciaRojoFamiliar=Integer.parseInt(limite.getText());
				}
			}
			else if(valor=="masP"){
				//cambiar más prestados
			}
		}
		else if(e.getSource()==atras){
			//regresar
		}
		
	   
		
	}
	@Override
	public String toString() {
		return "Ventana [fuente=" + fuente + "\n CambiarAlertas="
				+ CambiarAlertas + "\n top=" + top + "\n CambiarMasPrestados="
				+ CambiarMasPrestados + "\n manual=" + manual + "\n salir="
				+ salir + "\n aceptar=" + aceptar + "\n top1=" + top1
				+ "\n prest=" + prest + "\n rango=" + rango + "\n alertas="
				+ alertas + ", col=" + col + ", est=" + est + ", fam=" + fam
				+ "\n limite=" + limite + "\n meses=" + meses + "\n amarC="
				+ amarC + "\n amarE=" + amarE + "\n amarF=" + amarF + "\n verdC="
				+ verdC + "\n verdE=" + verdE + "\n verdF=" + verdF + "\n rojC="
				+ rojC + "\n rojE=" + rojE + "\n rojF=" + rojF + "\n am=" + am
				+ "\n rj=" + rj + "\n vd=" + vd + "\n at=" + at + "\n atras="
				+ atras + "\n vConfig=" + vConfig + "]";
	}}
