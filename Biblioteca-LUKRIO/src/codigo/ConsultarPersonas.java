package codigo;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import articulo.Libro;
import persona.Colega;
import persona.Estudiante;
import persona.Familiar;

public class ConsultarPersonas implements MouseListener{
	JFrame ventanaConsultas=new JFrame();
	static String tipoBusqueda="estudiantes";
	private JButton buscarPersonas;
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
		scrollPane.setBounds(10,40,900,450);
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
		String personasEncontradas="";
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
			personasEncontradas+="ESTUDIANTES ENCONTRADOS:\n";
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
						Object[] libro = new Object[]{((Estudiante)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Estudiante)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Estudiante)BibliotecaLUKRIO.personas.get(i)).getInstitucion(),};
						tabla.addRow(libro);
						personasEncontradas+=((Estudiante)BibliotecaLUKRIO.personas.get(i)).consulta()+"\n";
					}
				}
			}
		if(busco=="todos"){
			personasEncontradas+="COLEGAS ENCONTRADOS:\n";
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
						Object[] libro = new Object[]{((Colega)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Colega)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Colega)BibliotecaLUKRIO.personas.get(i)).getPuesto(),};
						tabla.addRow(libro);
						personasEncontradas+=((Estudiante)BibliotecaLUKRIO.personas.get(i)).consulta()+"\n";
					}
				}
			}
			if(busco=="todos"){
				personasEncontradas+="COLEGAS ENCONTRADOS:\n";
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
						Object[] libro = new Object[]{((Familiar)BibliotecaLUKRIO.personas.get(i)).getCarnet(),((Familiar)BibliotecaLUKRIO.personas.get(i)).getNombre(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido1(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getApellido2(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getCorreo(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getTelefono(),
								((Familiar)BibliotecaLUKRIO.personas.get(i)).getParentesco(),};
						tabla.addRow(libro);
						personasEncontradas+=((Estudiante)BibliotecaLUKRIO.personas.get(i)).consulta()+"\n";
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
			refrescarBusqueda(tipoBusqueda);
		}else if(seleccionarEstudiante.isSelected()){
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