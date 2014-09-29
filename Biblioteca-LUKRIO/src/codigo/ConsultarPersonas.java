package codigo;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import persona.Colega;
import persona.Estudiante;
import persona.Familiar;

public class ConsultarPersonas implements MouseListener{
	JFrame ventanaConsultas=new JFrame();
	static String tipoBusqueda="estudiantes";
	private JButton buscarPersonas,bEliminarPersona,bCambiarInformacion;
	String[] columnas = {"Carnet","Nombre","Primer Apellido","Segundo Apellido","Correo",
			"Teléfono","Institución"};
	Object[][] info = {};
	DefaultTableModel tabla= new DefaultTableModel(info,columnas);
	JTable table;
	//FILTROS
	JTextField entradaNombre=new JTextField("Nombre");     //Campos de texto donde se implementara la información de los filtros.
    JTextField entradaApellido1=new JTextField("1er Apellido");
    JTextField entradaApellido2=new JTextField("2do Apellido");
    JTextField entradaCorreo=new JTextField("Correo");
    JTextField entradaTelefono=new JTextField("Teléfono");
    JTextField entradaEspecial=new JTextField("Institución");
    
	//Seleccionador de busqueda
	JRadioButton seleccionarEstudiante = new JRadioButton("Estudiante");
    JRadioButton seleccionarColega = new JRadioButton("Colega");
    JRadioButton seleccionarFamiliar = new JRadioButton("Familiar");
    JRadioButton seleccionarTodos = new JRadioButton("Todos");
	ConsultarPersonas(){
		
		ventanaConsultas.setLayout(null);      //Para que no se acomoden automaticamente
		ventanaConsultas.setTitle("Consultar personas");  //Titulo de ventana
		ventanaConsultas.setSize(1000,550);       //Tamaño de ventana
		ventanaConsultas.setLocation(200,80);  //localizacion de ventana
		ventanaConsultas.setResizable(false);  //Minimizar ventana
		
		table = new JTable(tabla);
		table.setPreferredScrollableViewportSize(new Dimension(50,50));
		table.setFillsViewportHeight(true);
		table.addMouseListener(this);  
		
		JScrollPane scrollPane=new JScrollPane(table);
		scrollPane.setBounds(10,40,970,430);
		ventanaConsultas.add(scrollPane);
		
		crearInterfazConsultar();
	}
	public void crearInterfazConsultar(){
	    ButtonGroup selector = new ButtonGroup();  //Grupo para el RadioButton
        
        seleccionarEstudiante.setActionCommand("Estudiante");
        seleccionarEstudiante.setSelected(true);
        seleccionarEstudiante.addMouseListener(this); 
        seleccionarEstudiante.setBounds(10,10,100,20);
        ventanaConsultas.add(seleccionarEstudiante);
        
        seleccionarColega.setActionCommand("Colega");
        seleccionarColega.addMouseListener(this);
        seleccionarColega.setBounds(110,10,100,20);
        ventanaConsultas.add(seleccionarColega);
        
        seleccionarFamiliar.setActionCommand("Familiar");
        seleccionarFamiliar.addMouseListener(this);
        seleccionarFamiliar.setBounds(210,10,100,20);
        ventanaConsultas.add(seleccionarFamiliar);

        seleccionarTodos.setActionCommand("Todos");
        seleccionarTodos.addMouseListener(this);
        seleccionarTodos.setBounds(310,10,100,20);
        ventanaConsultas.add(seleccionarTodos);
        
        selector.add(seleccionarEstudiante);
        selector.add(seleccionarColega);
        selector.add(seleccionarFamiliar);
        selector.add(seleccionarTodos);
        
		entradaNombre.setBounds(420,10,75,20);
        ventanaConsultas.add(entradaNombre);
        entradaApellido1.setBounds(500,10,75,20);
        ventanaConsultas.add(entradaApellido1);
        entradaApellido2.setBounds(580,10,75,20);
        ventanaConsultas.add(entradaApellido2);
        entradaTelefono.setBounds(660,10,75,20);
        ventanaConsultas.add(entradaTelefono);
        entradaCorreo.setBounds(740,10,75,20);
        ventanaConsultas.add(entradaCorreo);
        entradaEspecial.setBounds(820,10,75,20);
        ventanaConsultas.add(entradaEspecial);
        
        buscarPersonas=new JButton("Buscar");
        buscarPersonas.setBounds(900,10,75,20);
        buscarPersonas.addMouseListener(this);
        ventanaConsultas.add(buscarPersonas);
        
        bEliminarPersona=new JButton("Eliminar Persona");
        bEliminarPersona.setBounds(10,480,150,30);
        bEliminarPersona.addMouseListener(this);
        ventanaConsultas.add(bEliminarPersona);
        
        bCambiarInformacion=new JButton("Carbiar Informacion");
        bCambiarInformacion.setBounds(830,480,150,30);
        bCambiarInformacion.addMouseListener(this);
        ventanaConsultas.add(bCambiarInformacion);
	}
	//Se reinician los valores principales de la vetana
	public void refrescarVentana(){
		seleccionarEstudiante.setSelected(true);
		tipoBusqueda="estudiantes";
		entradaNombre.setText("Nombre");     //Campos de texto donde se implementara la información de los filtros.
	    entradaApellido1.setText("1er Apellido");
	    entradaApellido2.setText("2do Apellido");
	    entradaCorreo.setText("Correo");
	    entradaTelefono.setText("Teléfono");
	    entradaEspecial.setText("Institución");
	    //informacion.setText("Presiona <Buscar> para iniciar la busqueda."+"\n"+"Puedes usar los filtros para faciliarla.");
	}
	public void reiniciaTabla(){
		while(tabla.getRowCount()!=0){
			tabla.removeRow(0);
		}
	}
	//Realiza una nueva busqueda de personas.
	public void refrescarBusqueda(String busco){
		String bNombre="no",bApellido1="no",bApellido2="no",bTelefono="no",bCorreo="no",bEspecial="no";
		//Registra los filtros para ver si se utilizan
		if(entradaNombre.getText().equals("Nombre")==false && entradaNombre.getText().equals("")==false){
			System.out.println("Nombre Si");
			bNombre="si";
		}
		if (entradaApellido1.getText().equals("1er Apellido")==false && entradaApellido1.getText().equals("")==false){
			bApellido1="si";
		}
		if(entradaApellido2.getText().equals("2do Apellido")==false && entradaApellido2.getText().equals("")==false){
			bApellido2="si";
		}
		if(entradaTelefono.getText().equals("Teléfono")==false && entradaTelefono.getText().equals("")==false){
			bTelefono="si";
		}
		if(entradaCorreo.getText().equals("Correo")==false && entradaCorreo.getText().equals("")==false){
			bCorreo="si";
		}
		if(busco=="todos"){
			Object[] persona = new Object[]{"- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -",
					"ESTUDIANTES","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -"};
			tabla.addRow(persona);
		}
		if(busco=="estudiantes" || busco=="todos"){
			if(entradaEspecial.getText().equals("Institución")==false && entradaEspecial.getText().equals("")==false && entradaEspecial.getText().equals("Adicional")==false){
				bEspecial="si";
				System.out.println("xq en estudia");}
			//Revisa la lista de estudiantes y los filtra de acuerdo a las especificaciones dadas.
			for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
				if(BibliotecaLUKRIO.personas.get(i).getTipo().equals("estudiante")){
					String imprimo="si";
					if(bNombre.equals("si") && entradaNombre.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getNombre()))==false){
						imprimo="no";}
					if(bApellido1.equals("si") && entradaApellido1.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido1()))==false){
						imprimo="no";}
					if(bApellido2.equals("si") && entradaApellido2.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido2()))==false){
						imprimo="no";}
					if(bTelefono.equals("si") && entradaTelefono.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getTelefono()))==false){
						imprimo="no";}
					if(bCorreo.equals("si") && entradaCorreo.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getCorreo()))==false){
						imprimo="no";}
					if(bEspecial.equals("si") && entradaEspecial.getText().equals((((Estudiante)BibliotecaLUKRIO.personas.get(i)).getInstitucion()))==false){
						imprimo="no";}
					if(imprimo.equals("si")){
						Object[] persona = new Object[]{((Estudiante)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Estudiante)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getInstitucion(),};
						tabla.addRow(persona);
					}
				}
			}
		if(busco=="todos"){
			Object[] persona = new Object[]{"- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -",
					"COLEGAS","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -"};
			tabla.addRow(persona);
		}
		}if(busco=="colegas" || busco=="todos"){
			if(entradaEspecial.getText().equals("Puesto")==false && entradaEspecial.getText().equals("Adicional")==false && entradaEspecial.getText().equals("")==false){
				bEspecial="si";
				System.out.println("Porque en colegas");}
			for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
				if(BibliotecaLUKRIO.personas.get(i).getTipo().equals("colega")){
					String imprimo="si";
					if(bNombre.equals("si") && entradaNombre.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getNombre()))==false){
						imprimo="no";}
					if(bApellido1.equals("si") && entradaApellido1.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido1()))==false){
						imprimo="no";}
					if(bApellido2.equals("si") && entradaApellido2.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido2()))==false){
						imprimo="no";}
					if(bTelefono.equals("si") && entradaTelefono.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getTelefono()))==false){
						imprimo="no";}
					if(bCorreo.equals("si") && entradaCorreo.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getCorreo()))==false){
						imprimo="no";}
					if(bEspecial.equals("si") && entradaEspecial.getText().equals((((Colega)BibliotecaLUKRIO.personas.get(i)).getPuesto()))==false){
						imprimo="no";}
					if(imprimo.equals("si")){
						Object[] persona = new Object[]{((Colega)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Colega)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getPuesto(),};
						tabla.addRow(persona);
					}
				}
			}
			if(busco=="todos"){
				Object[] persona = new Object[]{"- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -",
						"FAMILIARES","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -","- - - - - - - - - - - - - - - - - - -"};
				tabla.addRow(persona);
			}
		}if(busco=="familiares" || busco=="todos"){
			if(entradaEspecial.getText().equals("Parentesco")==false && entradaEspecial.getText().equals("Adicional")==false && entradaEspecial.getText().equals("")==false){
				bEspecial="si";}
			for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
				if(BibliotecaLUKRIO.personas.get(i).getTipo().equals("familiar")){
					String imprimo="si";
					if(bNombre.equals("si") && entradaNombre.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getNombre()))==false){
						imprimo="no";}
					if(bApellido1.equals("si") && entradaApellido1.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido1()))==false){
						imprimo="no";}
					if(bApellido2.equals("si") && entradaApellido2.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido2()))==false){
						imprimo="no";}
					if(bTelefono.equals("si") && entradaTelefono.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getTelefono()))==false){
						imprimo="no";}
					if(bCorreo.equals("si") && entradaCorreo.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getCorreo()))==false){
						imprimo="no";}
					if(bEspecial.equals("si") && entradaEspecial.getText().equals((((Familiar)BibliotecaLUKRIO.personas.get(i)).getParentesco()))==false){
						imprimo="no";}
					if(imprimo.equals("si")){
						Object[] persona = new Object[]{((Familiar)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Familiar)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getParentesco(),};
						tabla.addRow(persona);
					}
				}
			}
		}
		ventanaConsultas.setVisible(false);
		ventanaConsultas.setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==buscarPersonas){
			reiniciaTabla();
			refrescarBusqueda(tipoBusqueda);
		}else if(e.getSource()==bEliminarPersona){
			//Revisamos que este una linea seleccionada
			if(table.getSelectedRow()!=-1){
				//Obtenemos el carnet de la linea seleccionada
				String carnet0=tabla.getDataVector().get(table.getSelectedRow()).toString().split(",")[0];
				//Carnet0 tiene el carnet mas un "[" al inicio, usamos carnet para quitarselo
				int carnet=Integer.parseInt(carnet0.substring(1));
				for(int k=0;k<BibliotecaLUKRIO.personas.size();k++){
					if(BibliotecaLUKRIO.personas.get(k).getCarnet()==carnet){
						BibliotecaLUKRIO.personas.remove(k);
						reiniciaTabla();
						refrescarBusqueda(tipoBusqueda);
						break;
					}
				}	
			}
		}else if(e.getSource()==bCambiarInformacion){
			String carnet0,nombre,apellido1,apellido2,correo,telefono,adicional;
			int carnet;
			boolean telefonoBueno;
			for(int k=0;k<tabla.getDataVector().size();k++){
				telefonoBueno=true;
				carnet0=tabla.getDataVector().get(k).toString().split(",")[0];
				nombre=tabla.getDataVector().get(k).toString().split(",")[1];
				apellido1=tabla.getDataVector().get(k).toString().split(",")[2];
				apellido2=tabla.getDataVector().get(k).toString().split(",")[3];
				correo=tabla.getDataVector().get(k).toString().split(",")[4];
				telefono=tabla.getDataVector().get(k).toString().split(",")[5];
				adicional=tabla.getDataVector().get(k).toString().split(",")[6];
				carnet=Integer.parseInt(carnet0.substring(1));
				try{
					//Obtiene el telefono con un espacio al inicio
					Integer.parseInt(telefono.substring(1,telefono.length()));
				}catch(Exception exception){
					telefonoBueno=false;
				}
				if(telefono.substring(1, telefono.length()).length()!=8){
					telefonoBueno=false;
				}
				for(int j=0;j<BibliotecaLUKRIO.personas.size();j++){
					if(BibliotecaLUKRIO.personas.get(j).getCarnet()==carnet){
						if(telefonoBueno && nombre.equals(" ")==false && apellido1.equals(" ")==false &&
								apellido2.equals(" ")==false && correo.equals(" ")==false){
							System.out.println(nombre);
							BibliotecaLUKRIO.personas.get(j).setNombre(nombre.substring(1,nombre.length()));
							System.out.println(BibliotecaLUKRIO.personas.get(j).getNombre());
							BibliotecaLUKRIO.personas.get(j).setApellido1(apellido1.substring(1,apellido1.length()));
							BibliotecaLUKRIO.personas.get(j).setApellido2(apellido2.substring(1,apellido2.length()));
							BibliotecaLUKRIO.personas.get(j).setCorreo(correo.substring(1,correo.length()));
							BibliotecaLUKRIO.personas.get(j).setTelefono(telefono.substring(1, telefono.length()));
						break;
						}
					}
				}
			}
			reiniciaTabla();
			refrescarBusqueda(tipoBusqueda);
		}
		else if(seleccionarEstudiante.isSelected()){
			entradaEspecial.setText("Institución");
			tipoBusqueda="estudiantes";
		}
		else if(seleccionarColega.isSelected()){
			tipoBusqueda="colegas";
			entradaEspecial.setText("Puesto");
		}
		else if(seleccionarFamiliar.isSelected()){
			tipoBusqueda="familiares";
			entradaEspecial.setText("Parentesco");
		}else if(seleccionarTodos.isSelected()){
			tipoBusqueda="todos";
			entradaEspecial.setText("Adicional");
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