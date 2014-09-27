package codigo;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class CargarArticulos {
	public void listarImagenes(){
		JFileChooser chooser = new JFileChooser();
		File F=new File("c:/");  //Direccion principal donde se abrirá la ventana de busqueda.
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
	    File imagenes2;
	    File[]listImages;
	    ArrayList<ImageIcon> imagenesListas=new ArrayList<ImageIcon>();
	    for(int i=0;i<listFiles.length;i++){
            try{
                imagenes2=new File(listFiles[i].getAbsolutePath());
                System.out.println(listFiles[i].getAbsolutePath());
                ImageIcon icon=new ImageIcon(listFiles[i].getAbsolutePath());
        		Image icono = icon.getImage();  //Se obtiene la imagen del icono
        		ImageIcon iconoEscalado = new ImageIcon (icono.getScaledInstance(200,200,Image.SCALE_SMOOTH)); //Cambiamos el tamaño de la imagen
        		imagenesListas.add(iconoEscalado);
            }catch(Exception exception){
            	System.out.println("catch");
        }
      }
	}
}