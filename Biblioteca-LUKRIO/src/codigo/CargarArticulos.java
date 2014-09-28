package codigo;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;

public class CargarArticulos {
	public void cargarCarpeta(){
		JFileChooser chooser = new JFileChooser();
		File F=new File("c:/");  //Direccion principal donde se abrirá la ventana de busqueda.
		File NamePath = null;
		int Checker;
		chooser.setCurrentDirectory(F);
		Checker = chooser.showOpenDialog(null);
		if(Checker==JFileChooser.APPROVE_OPTION){
			NamePath=chooser.getSelectedFile();
			System.out.println(NamePath.getAbsolutePath());
			listarImagenes(NamePath.getParent(),NamePath.getAbsolutePath());
		}
	}
	public void listarImagenes(String carpeta,String direccion){
		try{
			File directory;
		    File[]listFiles;
		    directory=new File(carpeta);
		    listFiles=directory.listFiles();
		    ArrayList <String> direccionesImagenes = new ArrayList<String>();
		    ArrayList<ImageIcon> imagenesListas=new ArrayList<ImageIcon>();
			try{
				//Trata de leer el archivo por lineas.
				File archivo = new File (direccion);
				FileReader fr = new FileReader (archivo);
		        
		        @SuppressWarnings({ "unused", "resource" })   //Sobreescribimos el SuppresWarnings
		        
				BufferedReader br = new BufferedReader(fr);
		        String linea = null;
		        String[] cInformacion = null;
		        int numLinea=1;
		        int personasRegistradas=0;
		        boolean finalizado=false;
		        int cont=1;
				while(finalizado==false){
				   linea=br.readLine();
		           if(linea!=null){
			           	cInformacion=linea.split(" ");
			           	if(cInformacion.length==14){
			           		ImageIcon imagen=null;
			           		String lugar=null;
						    for(int i=0;i<listFiles.length;i++){
						    	if(listFiles[i].getName().toString().equals(cInformacion[0])){
						            imagen=modificarTamano(new ImageIcon(listFiles[i].getAbsolutePath()));
						            lugar=listFiles[i].getAbsolutePath().toString();
						            break;
						    	}
						    }if(imagen==null){
						    	//Cambiar por imagenes/incognito...
						    	imagen=(new ImageIcon("imagenes/RedDragon.png"));
						    }
						    int ano=0,mes=0,dia=0;
						    boolean prestado=false;
						    if(cInformacion[7].equals("si")){
						    	prestado=true;
						    	ano=Integer.parseInt(cInformacion[8]);
						    	mes=Integer.parseInt(cInformacion[9]);
				    			dia=Integer.parseInt(cInformacion[10]);
						    }
						    boolean existePersona=false;
							for(int i=0;i<BibliotecaLUKRIO.personas.size();i++){
								if(BibliotecaLUKRIO.personas.get(i).getCarnet()==Integer.parseInt(cInformacion[12])){
									existePersona=true;
									break;
								}
							}
							if(existePersona==false && prestado){
								prestado=false;
								ano=0;
						    	mes=0;
				    			dia=0;
				    			JOptionPane.showMessageDialog(null,"Este árticulo está prestado a una persona no registrada. Linea: "+cont+" "
										+ ". Por lo tanto se registrara el árticulo como no prestado");
							}
							if(cInformacion[1].equals("libro")){
							    	BibliotecaLUKRIO.articulos.add(new Libro(cInformacion[2],cInformacion[3],
						    			cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
						    			BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11],
							   			Integer.parseInt(cInformacion[12]),cInformacion[13]));
							}else if(cInformacion[1].equals("pelicula")){
							    	BibliotecaLUKRIO.articulos.add(new Pelicula(cInformacion[2],cInformacion[3],
							   			cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
							   			BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11],
							   			Integer.parseInt(cInformacion[12]),cInformacion[13]));
						   }else if(cInformacion[1].equals("revista")){
								   BibliotecaLUKRIO.articulos.add(new Revista(cInformacion[2],cInformacion[3],
									   cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
							    		BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11],
							    		Integer.parseInt(cInformacion[12]),cInformacion[13]));
						   }
			           	}else{
			           		JOptionPane.showMessageDialog(null,"Hay un error de información en la línea: "+cont);
			           	}
			           	cont++;
		           }else{
		        	   finalizado=true;
		           }
				}
			}catch(Exception exception){
				//No se leyo el archivo
			}
		}catch(Exception exception){
			
		}
	}
	public ImageIcon modificarTamano(ImageIcon icon){
		Image icono = icon.getImage();  //Se obtiene la imagen del icono
    	return new ImageIcon (icono.getScaledInstance(200,200,Image.SCALE_SMOOTH));
	}
}