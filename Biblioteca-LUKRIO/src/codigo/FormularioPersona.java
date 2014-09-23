package codigo;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import persona.Colega;
import persona.Estudiante;
import persona.Familiar;

public class FormularioPersona implements MouseListener{
	//Ventana del formulario para registrar personas.
	JFrame formulario=new JFrame();
	
	private JLabel labelNombre,labelApellido1,labelApellido2,labelTelefono,labelCorreo,labelEspecial;
	private String tipoSeleccion;
	private JButton registrarPersona;
	
	//Entradas de texto para el formulario
	JTextField entradaNombre=new JTextField("Introduce el nombre");
    JTextField entradaApellido1=new JTextField("Introduce el primer apellido");
    JTextField entradaApellido2=new JTextField("Introduce el segundo apellido");
    JTextField entradaCorreo=new JTextField("Introduce el correo");
    JTextField entradaTelefono=new JTextField("Introduce el teléfono");
    JTextField entradaEspecial=new JTextField("Introduce la institución");
    
	//Botones del seleccionador del formulario
	JRadioButton seleccionarEstudiante = new JRadioButton("Estudiante");
    JRadioButton seleccionarColega = new JRadioButton("Colega");
    JRadioButton seleccionarFamiliar = new JRadioButton("Familiar");
    
    //Constructor
	FormularioPersona(){
		formulario.setLayout(null);
		formulario.setTitle("Formulario");  //Titulo de ventana
		formulario.setSize(400,390);       //Tamaño de ventana
		formulario.setLocation(450,145);  //localizacion de ventana
		formulario.setResizable(false);  //Minimizar ventana
		creaInterfazFormulario();
		ImageIcon imagen = new ImageIcon(formulario.getClass().getResource("/imagenes/fondoFormulario.jpg")); //Localidad dentro del programa
		ImagenFondo fondo = new ImagenFondo(imagen.getImage());
		formulario.getContentPane().add(fondo);
		formulario.setVisible(false);   //Oculta la ventana
	}
	public void visibilidad(boolean visible){
		formulario.setVisible(visible);
	}
	//Crea toda la interfaz del formulario
	public void creaInterfazFormulario(){
		tipoSeleccion="estudiante";
		registrarPersona=new JButton("Registrar persona");
		registrarPersona.setBounds(80,300,200,30);
        formulario.add(registrarPersona);
        registrarPersona.addMouseListener(this);
        
        entradaNombre.setBounds(130,10,200,20);
        formulario.add(entradaNombre);
        labelNombre=new JLabel("Nombre:");
        labelNombre.setBounds(10,10,200,20);
        formulario.add(labelNombre);
        
        entradaApellido1.setBounds(130,50,200,20);
        formulario.add(entradaApellido1);
        labelApellido1=new JLabel("Primer apellido:");
        labelApellido1.setBounds(10,50,200,20);
        formulario.add(labelApellido1);
        
        entradaApellido2.setBounds(130,90,200,20);
        formulario.add(entradaApellido2);
        labelApellido2=new JLabel("Segundo apellido:");
        labelApellido2.setBounds(10,90,200,20);
        formulario.add(labelApellido2);
        
        entradaTelefono.setBounds(130,130,200,20);
        formulario.add(entradaTelefono);
        labelTelefono=new JLabel("Teléfono:");
        labelTelefono.setBounds(10,130,200,20);
        formulario.add(labelTelefono);
        
        entradaCorreo.setBounds(130,170,200,20);
        formulario.add(entradaCorreo);
        labelCorreo=new JLabel("Correo:");
        labelCorreo.setBounds(10,170,200,20);
        formulario.add(labelCorreo);
        
        ButtonGroup selector = new ButtonGroup();  //Grupo para el RadioButton
        
        seleccionarEstudiante.setActionCommand("Estudiante");
        seleccionarEstudiante.setSelected(true);
        seleccionarEstudiante.addMouseListener(this); 
        seleccionarEstudiante.setBounds(10,210,100,20);
        formulario.add(seleccionarEstudiante);
        
        seleccionarColega.setActionCommand("Colega");
        seleccionarColega.addMouseListener(this);
        seleccionarColega.setBounds(130,210,100,20);
        formulario.add(seleccionarColega);
        
        seleccionarFamiliar.setActionCommand("Familiar");
        seleccionarFamiliar.addMouseListener(this);
        seleccionarFamiliar.setBounds(250,210,100,20);
        formulario.add(seleccionarFamiliar);
        
        selector.add(seleccionarEstudiante);
        selector.add(seleccionarColega);
        selector.add(seleccionarFamiliar);
        
        entradaEspecial.setBounds(130,250,200,20);
        formulario.add(entradaEspecial);
        labelEspecial=new JLabel("Institución: ");
        labelEspecial.setBounds(10,250,200,20);
        formulario.add(labelEspecial);
	}
	//Volver a poner textos originales al formulario
	public void refrescarFormulario(){
		seleccionarEstudiante.setSelected(true);
		entradaNombre.setText("Introduce el nombre");
	    entradaApellido1.setText("Introduce el primer apellido");
	    entradaApellido2.setText("Introduce el segundo apellido");
	    entradaCorreo.setText("Introduce el correo");
	    entradaTelefono.setText("Introduce el teléfono");
	    refrescarSeleccion("estudiante");
	}
	//Seleccion del tipo de persona
	public void refrescarSeleccion(String seleccion){
		tipoSeleccion=seleccion;
		if (seleccion=="estudiante"){
			entradaEspecial.setText("Introduce la institución");
			labelEspecial.setText("Institución: ");
		}else if(seleccion=="colega"){
			entradaEspecial.setText("Introduce el puesto");
			labelEspecial.setText("Puesto: ");
		}else{
			entradaEspecial.setText("Introduce el parentesco");
			labelEspecial.setText("Parentesco: ");
		}
	}
	//Comprueba si la entrada del teléfono es un número o no.
	public static boolean compruebaTelefono(String telefono){
		try{
			 Integer.parseInt(telefono);
			 return true;
		}catch(Exception excepcion){
			return false;
		 }
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==registrarPersona){
			refrescarSeleccion("estudiante");
		}else if(seleccionarEstudiante.isSelected()){
			refrescarSeleccion("estudiante");
		}
		else if(seleccionarColega.isSelected()){
			refrescarSeleccion("colega");
		}
		else{
			refrescarSeleccion("familiar");
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
