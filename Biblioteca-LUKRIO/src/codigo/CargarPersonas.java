package codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import persona.Colega;
import persona.Estudiante;
import persona.Familiar;

public class CargarPersonas {
	public void cargarArchivo(){
		String direccion = null;
		JFileChooser chooser = new JFileChooser();
		File F=new File("c:/");  //Direccion principal donde se abrirá la ventana de busqueda.
		File NameDir,NamePath;
		int Checker;
		chooser.setCurrentDirectory(F);
		Checker = chooser.showOpenDialog(null);
		if(Checker==JFileChooser.APPROVE_OPTION){
			NameDir=chooser.getCurrentDirectory();
			NamePath=chooser.getSelectedFile();
			direccion=NamePath.getAbsolutePath();
			try {
				cargar(direccion);
			} catch (IOException e) {
			}
		}
	}
	public void cargar(String direccion) throws IOException{
		//Abrir un archivo desde la base de datos
		try{
			//Trata de leer el archivo por lineas.
		    File archivo = new File (direccion);
		    FileReader fr = new FileReader (archivo);
	        
	        @SuppressWarnings({ "unused", "resource" })   //Lo pedia el BufferedReader
	        
			BufferedReader br = new BufferedReader(fr);
	        String linea = null;
	        String[] cInformacion = null;
	        int numLinea=1;
	        int personasRegistradas=0;
	        boolean finalizado=false;
			while(finalizado==false){
			   linea=br.readLine();
	           if(linea!=null){
		           	cInformacion=linea.split(" ");
					try{
						//Por cada linea que encuentra, comprueba que los valores sean correctos y los asigna a la lista de clases que pertenezca.
						if(FormularioPersona.compruebaTelefono(cInformacion[4]) && cInformacion.length==7){
							if(cInformacion[0].equals("estudiante")){
								personasRegistradas++;
								BibliotecaLUKRIO.personas.add(new Estudiante(cInformacion[1],cInformacion[2],cInformacion[3],cInformacion[4],
										cInformacion[5],cInformacion[6],BibliotecaLUKRIO.carnet));
								BibliotecaLUKRIO.carnet++;
							}else if(cInformacion[0].equals("colega")){
								personasRegistradas++;
								BibliotecaLUKRIO.personas.add(new Colega(cInformacion[1],cInformacion[2],cInformacion[3],cInformacion[4],
										cInformacion[5],cInformacion[6],BibliotecaLUKRIO.carnet));
								BibliotecaLUKRIO.carnet++;
							}else if(cInformacion[0].equals("familiar")){
								personasRegistradas++;
								BibliotecaLUKRIO.personas.add(new Familiar(cInformacion[1],cInformacion[2],cInformacion[3],cInformacion[4],
										cInformacion[5],cInformacion[6],BibliotecaLUKRIO.carnet));
								BibliotecaLUKRIO.carnet++;
							}else{
								JOptionPane.showMessageDialog(null, "Problema en el archivo: "+direccion+" En la linea: "+numLinea+" Con el tipo de persona");
							}
							//personas.add(new Persona(cInformacion[0],cInformacion[1],cInformacion[2],cInformacion[3],cInformacion[4],cInformacion[5]));
						}else{
							JOptionPane.showMessageDialog(null, "Problema en el archivo: "+direccion+" En la linea: "+numLinea+" Con el número de teléfono o con el largo del archivo.");
						}
					}catch(Exception exception){
						JOptionPane.showMessageDialog(null, "Problema en el archivo: "+direccion+" En la linea: "+numLinea+" Está mal redactada la información.");
				}
	        }else{
	        	finalizado=true;
	        }
	        numLinea++;
		}JOptionPane.showMessageDialog(null,"Se registraron "+personasRegistradas+" correctamente.");
		}catch(Exception exception){
			System.out.println("Cancelar");
		}
     }
}
