package codigo;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import articulo.Libro;
import articulo.Pelicula;
import articulo.Revista;

public class CargarArticulos {
	public void listarImagenes(){
		try{
			JFileChooser chooser = new JFileChooser();
			String direccion = null;
			File F=new File("c:/");  //Direccion principal donde se abrir� la ventana de busqueda.
			File NameDir = null,NamePath = null;
			int Checker;
			chooser.setCurrentDirectory(F);
			Checker = chooser.showOpenDialog(null);
			if(Checker==JFileChooser.APPROVE_OPTION){
				NameDir=chooser.getCurrentDirectory();
				NamePath=chooser.getSelectedFile();
				System.out.println(NameDir.getName());
				System.out.println(NamePath.getParent());
			}
			File directory;
		    File[]listFiles;
		    directory=new File(NamePath.getParent());
		    listFiles=directory.listFiles();
		    ArrayList <String> direccionesImagenes = new ArrayList<String>();
		    ArrayList<ImageIcon> imagenesListas=new ArrayList<ImageIcon>();
		    
		    //===============================================
		    
		    direccion=NamePath.getAbsolutePath();
			System.out.println(NameDir.getName());
			System.out.println((NamePath.getAbsolutePath().split(NameDir.getName()))[0]);
			try{
				//Trata de leer el archivo por lineas.
				File archivo = null;
			    FileReader fr = null;
			    BufferedReader br = null;
				archivo = new File (direccion);
		        fr = new FileReader (archivo);
		        
		        @SuppressWarnings({ "unused", "resource" })   //Sobreescribimos el SuppresWarnings
		        
				BufferedReader bufferedReader = br = new BufferedReader(fr);
		        String linea = null;
		        String[] cInformacion = null;
		        int numLinea=1;
		        int personasRegistradas=0;
		        boolean finalizado=false;
				while(finalizado==false){
				   linea=br.readLine();
		           if(linea!=null){
			           	cInformacion=linea.split(" ");
			           	if(cInformacion.length==12){
			           		ImageIcon imagen=null;
			           		String lugar=null;
						    for(int i=0;i<listFiles.length;i++){
						    	System.out.println(listFiles[i].getAbsolutePath());
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
						    if(cInformacion[1].equals("libro")){
						    	BibliotecaLUKRIO.articulos.add(new Libro(cInformacion[2],cInformacion[3],
						    			cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
						    			BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11]));
						    }else if(cInformacion[1].equals("pelicula")){
						    	BibliotecaLUKRIO.articulos.add(new Pelicula(cInformacion[2],cInformacion[3],
						    			cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
						    			BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11]));
						    }else if(cInformacion[1].equals("revista")){
						    	BibliotecaLUKRIO.articulos.add(new Revista(cInformacion[2],cInformacion[3],
						    			cInformacion[4],cInformacion[5],imagen,Integer.parseInt(cInformacion[6]),
						    			BibliotecaLUKRIO.numeroArticulo,lugar,prestado,ano,mes,dia,cInformacion[11]));
						    }
						  //Si se encontro la linea bien [GUARDAMOS ARTICULO]
						  //Si se encontro la linea bien [GUARDAMOS ARTICULO]
						    /*int x=10,y=10;
						    System.out.println(imagenesListas.size());
						    for (int j=0;j<imagenesListas.size();j++){
						    	BibliotecaLUKRIO.consultarArticulos.scroll.anadirPortada(imagenesListas.get(j),x,y);
						    	y+=200;
					      }*/
			           	}
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