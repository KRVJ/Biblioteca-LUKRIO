package codigo;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

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
		//ImageIcon imagen = new ImageIcon(formulario.getClass().getResource("/imagenes/fondoFormulario.jpg")); //Localidad dentro del programa
		//ImagenFondo fondo = new ImagenFondo(imagen.getImage());
		//formulario.getContentPane().add(fondo);
		formulario.setVisible(false);   //Oculta la ventana
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
			//Comprobamos que los campos de texto hayan sido modificados y no esten vacios.
			if(entradaNombre.getText().equals("Introduce el nombre")==false && entradaNombre.getText().equals("")==false &&
				entradaApellido1.getText().equals("Introduce el primer apellido")==false && entradaApellido1.getText().equals("")==false &&
				entradaApellido2.getText().equals("Introduce el segundo apellido")==false && entradaApellido2.getText().equals("")==false &&
				entradaCorreo.getText().equals("Introduce el correo")==false && entradaApellido2.getText().equals("")==false &&
				entradaTelefono.getText().equals("Introduce el teléfono")==false && entradaApellido2.getText().equals("")==false &&
				entradaNombre.getText().length()<11 && entradaApellido1.getText().length()<11 && entradaApellido2.getText().length()<11 &&
				entradaTelefono.getText().length()==8 && entradaEspecial.getText().equals("")==false && entradaEspecial.getText().equals("Introduce la institución")==false &&
				entradaEspecial.getText().equals("Introduce el parentesco")==false && entradaEspecial.getText().equals("Introduce el puesto")==false){
				//Comprobamos que el teléfono sea un número
				if(compruebaTelefono(entradaTelefono.getText())){
						if(tipoSeleccion=="estudiante"){
						BibliotecaLUKRIO.personas.add(new Estudiante(entradaNombre.getText(),entradaApellido1.getText(),entradaApellido2.getText(),
								entradaTelefono.getText(),entradaCorreo.getText(),entradaEspecial.getText(),BibliotecaLUKRIO.carnet));
						}else if(tipoSeleccion=="colega"){
							BibliotecaLUKRIO.personas.add(new Colega(entradaNombre.getText(),entradaApellido1.getText(),entradaApellido2.getText(),
									entradaTelefono.getText(),entradaCorreo.getText(),entradaEspecial.getText(),BibliotecaLUKRIO.carnet));
						}else{
							BibliotecaLUKRIO.personas.add(new Familiar(entradaNombre.getText(),entradaApellido1.getText(),entradaApellido2.getText(),
									entradaTelefono.getText(),entradaCorreo.getText(),entradaEspecial.getText(),BibliotecaLUKRIO.carnet));
						}
						Component frame = null;
						formulario.setVisible(false);
						refrescarFormulario();
						BibliotecaLUKRIO.carnet++;
						JOptionPane.showMessageDialog(frame,"La persona se ha registrada con éxito. Su número de carnet es: "+BibliotecaLUKRIO.carnet);
				}else{
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"Por favor digite un número de teléfono válido");
				}
			}else{
				Component frame = null;
				JOptionPane.showMessageDialog(frame,"Por favor llene todos los datos, recuerde que deben tener menos de 10 caracteres y el correo menos de 15 y el teléfono 8 dígitos");
			}
		}
		else if(seleccionarEstudiante.isSelected()){
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
